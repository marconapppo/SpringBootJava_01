package com.example.SpringBootJava_01.Controller.Dto;

import com.example.SpringBootJava_01.Domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesDoTopicoDto
{
    public Long id;
    public String titulo;
    public String mensagem;
    public LocalDateTime dataCriacao;
    public String nomeAutor;
    public StatusTopico status;
    public List<RespostaDto> respostas;

    public DetalhesDoTopicoDto(Topico topico)
    {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.status = topico.getStatus();
        this.respostas = new ArrayList<RespostaDto>();
        this.respostas.addAll( topico.getRespostas().stream().map(RespostaDto::new).toList() );
    }
}
