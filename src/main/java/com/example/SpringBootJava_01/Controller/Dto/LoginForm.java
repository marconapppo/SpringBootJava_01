package com.example.SpringBootJava_01.Controller.Dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm
{
    public String email;
    public String senha;

    public UsernamePasswordAuthenticationToken converter()
    {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
