package com.dio.cadastroApiApplication.repository;

import com.dio.cadastroApiApplication.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
