package com.example.SpringBootJava_01.Controller.Dto;

import com.example.SpringBootJava_01.Domain.Topico;
import com.example.SpringBootJava_01.JpaRepository.TopicoRepository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AtualizacaoTopicoForm
{
    @NotNull @NotEmpty @Length(min = 5)
    public String titulo;
    @NotNull @NotEmpty @Length(min = 5)
    public String mensagem;

    public Topico atualizar(Long id, TopicoRepository topicoRepository)
    {
        Topico topico = topicoRepository.getReferenceById(id);

        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);

        return topico;
    }
}
