package com.dio.cadastroApiApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pessoa")
public class PessoaController {

    @GetMapping
    public String getPessoa() {
        return "Olá";
    }
}
