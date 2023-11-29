package com.example.SpringBootJava_01.Controller.Dto;

import com.example.SpringBootJava_01.Domain.Resposta;

import java.time.LocalDateTime;

public class RespostaDto
{
    public Long id;
    public String mensagem;
    public LocalDateTime dataCriacao;
    public String nomeAutor;

    public RespostaDto(Resposta resposta)
    {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }
}
