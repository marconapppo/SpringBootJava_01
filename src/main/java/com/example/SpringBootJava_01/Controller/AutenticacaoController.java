package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Controller.Dto.LoginForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController
{
    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form)
    {
        return ResponseEntity.ok().build();
    }
}
