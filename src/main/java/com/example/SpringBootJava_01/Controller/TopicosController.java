package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Controller.Dto.AtualizacaoTopicoForm;
import com.example.SpringBootJava_01.Controller.Dto.DetalhesDoTopicoDto;
import com.example.SpringBootJava_01.Controller.Dto.TopicoDto;
import com.example.SpringBootJava_01.Controller.Dto.TopicoForm;
import com.example.SpringBootJava_01.Domain.Topico;
import com.example.SpringBootJava_01.JpaRepository.CursoRepository;
import com.example.SpringBootJava_01.JpaRepository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("Topicos")
public class TopicosController
{
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

//    @GetMapping()
//    public List<TopicoDto> GetAll(String nomeCurso)
//    {
//        List<Topico> topicos;
//        if (nomeCurso == null)
//        {
//            topicos = topicoRepository.findAll();
//        }
//        else
//        {
//            topicos = topicoRepository.findByCurso_Nome(nomeCurso);
//        }
//        return TopicoDto.converter(topicos);
//    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder)
    {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id)
    {
        var topico = topicoRepository.findById(id);

        if(topico.isPresent()) { return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get())); };

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form)
    {
        Topico topico = form.atualizar(id, topicoRepository);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id)
    {
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso, @RequestParam int pagina, @RequestParam int qtd)
    {
        Pageable paginacao = PageRequest.of(pagina, qtd);

        Page<Topico> topicos;
        if (nomeCurso == null)
        {
            topicos = topicoRepository.findAll(paginacao);
        }
        else
        {
            topicos = topicoRepository.findByCurso_Nome(nomeCurso, paginacao);
        }
        return TopicoDto.converter(topicos);
    }
}
