package com.dio.cadastroApiApplication.controller;

import com.dio.cadastroApiApplication.dto.response.MensagemRespostaDTO;
import com.dio.cadastroApiApplication.entity.Pessoa;
import com.dio.cadastroApiApplication.exception.PessoaNaoEncontradaException;
import com.dio.cadastroApiApplication.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MensagemRespostaDTO createPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.createPessoa(pessoa);
    }
    @PutMapping("/{id}")
    public MensagemRespostaDTO updatePessoaById(
            @PathVariable Long id,
            @RequestBody
            @Valid Pessoa pessoa) throws PessoaNaoEncontradaException {
        return pessoaService.updatePessoaById(id, pessoa);
    }
    @GetMapping("/{id}")
    public java.util.Optional<Pessoa> encontraById(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return pessoaService.encontraById(id);
    }
    @GetMapping
    public List<Pessoa> listaTodos() {
        return pessoaService.listaTudo();
    }
    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id) throws PessoaNaoEncontradaException {
        pessoaService.removeById(id);
    }
}
