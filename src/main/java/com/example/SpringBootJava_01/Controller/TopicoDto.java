package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Domain.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto
{
    public Long id;
    public String titulo;
    public String mensagem;
    public LocalDateTime dataCriacao;

    public TopicoDto(Topico topico)
    {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDto> Converter(List<Topico> topicos)
    {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }
}
