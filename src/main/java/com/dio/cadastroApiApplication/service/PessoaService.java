package com.dio.cadastroApiApplication.service;

import com.dio.cadastroApiApplication.dto.response.MensagemRespostaDTO;
import com.dio.cadastroApiApplication.entity.Pessoa;
import com.dio.cadastroApiApplication.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    public MensagemRespostaDTO createPessoa(Pessoa pessoa) {
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return MensagemRespostaDTO
                .builder()
                .mensagem("Cadastrada pessoa com o ID" + savedPessoa.getId())
                .build();
    }

}
