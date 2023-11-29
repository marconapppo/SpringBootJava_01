package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Controller.Dto.DetalhesDoTopicoDto;
import com.example.SpringBootJava_01.Controller.Dto.TopicoDto;
import com.example.SpringBootJava_01.Controller.Dto.TopicoForm;
import com.example.SpringBootJava_01.Domain.Topico;
import com.example.SpringBootJava_01.JpaRepository.CursoRepository;
import com.example.SpringBootJava_01.JpaRepository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Topicos")
public class TopicosController
{
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping()
    public List<TopicoDto> GetAll(String nomeCurso)
    {
        List<Topico> topicos;
        if (nomeCurso == null)
        {
            topicos = topicoRepository.findAll();
        }
        else
        {
            topicos = topicoRepository.findByCurso_Nome(nomeCurso);
        }
        return TopicoDto.Converter(topicos);
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder)
    {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    public DetalhesDoTopicoDto detalhar(@PathVariable Long id)
    {
        var topico = topicoRepository.getReferenceById(id);
        return new DetalhesDoTopicoDto(topico);
    }
}
