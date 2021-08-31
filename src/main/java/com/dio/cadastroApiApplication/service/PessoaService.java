package com.dio.cadastroApiApplication.service;

import com.dio.cadastroApiApplication.dto.response.MensagemRespostaDTO;
import com.dio.cadastroApiApplication.entity.Pessoa;
import com.dio.cadastroApiApplication.exception.PessoaNaoEncontradaException;
import com.dio.cadastroApiApplication.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MensagemRespostaDTO createPessoa(Pessoa pessoa) {
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return criaMensagemResposta(savedPessoa.getId(), "Criado cadastro com o id ");
    }
    public MensagemRespostaDTO updatePessoaById(Long id, Pessoa pessoa) throws PessoaNaoEncontradaException {
        verifcaSeExiste(id);
        Pessoa updatePessoa = pessoaRepository.save(pessoa);
        return criaMensagemResposta(updatePessoa.getId(), "Cadastro atualizado. ID: ");
    }
    public Optional<Pessoa> encontraById(Long id) throws PessoaNaoEncontradaException {
        verifcaSeExiste(id);
        return pessoaRepository.findById(id);
    }
    public List<Pessoa> listaTudo() {
        return pessoaRepository.findAll();
    }
    public void removeById(Long id) throws PessoaNaoEncontradaException {
        verifcaSeExiste(id);
        pessoaRepository.deleteById(id);
    }

    private void verifcaSeExiste(Long id) throws PessoaNaoEncontradaException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }
    private MensagemRespostaDTO criaMensagemResposta(Long id, String mensagem) {
        return MensagemRespostaDTO.builder()
                .mensagem(mensagem + id)
                .build();
    }

}