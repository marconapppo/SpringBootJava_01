package com.example.SpringBootJava_01.Controller.Dto;

import com.example.SpringBootJava_01.Domain.Curso;
import com.example.SpringBootJava_01.Domain.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;

public class TopicoDto
{
    public Long id;
    public String titulo;
    public String mensagem;
    public LocalDateTime dataCriacao;
    public Curso curso;

    public TopicoDto(Topico topico)
    {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.curso = topico.getCurso();
    }

    public static List<TopicoDto> converter(List<Topico> topicos)
    {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

    public static Page<TopicoDto> converter(Page<Topico> topicos) {
        return topicos.map(TopicoDto::new);
    }
}
