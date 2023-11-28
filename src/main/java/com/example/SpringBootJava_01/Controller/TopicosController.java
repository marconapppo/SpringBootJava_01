package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Domain.Topico;
import com.example.SpringBootJava_01.JpaRepository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Topicos")
public class TopicosController
{
    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping()
    public List<TopicoDto> GetAll(String nomeCurso)
    {
        if (nomeCurso == null)
        {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.Converter(topicos);
        }
        else
        {
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
            return TopicoDto.Converter(topicos);
        }
    }

    //TODO: Criar find by name
}
