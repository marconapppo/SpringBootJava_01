package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Domain.Topico;
import com.example.SpringBootJava_01.JpaRepository.CursoRepository;
import com.example.SpringBootJava_01.JpaRepository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void cadastrar(@RequestBody TopicoForm form)
    {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);
    }

}
