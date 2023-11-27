package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Domain.Curso;
import com.example.SpringBootJava_01.Domain.Topico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("Topicos")
public class TopicosController
{

    @GetMapping()
    public List<Topico> GetAll()
    {
        var topico = new Topico("Duvida", "Duvida com Spring", new Curso("Spring", "Programação"));

        return Arrays.asList(topico, topico, topico );
    }
}
