package com.dio.cadastroApiApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 2, max = 100)
    private String primeiroNome;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 2, max = 100)
    private String ultimoNome;

    @Column(nullable = false, unique = true)
    @NotEmpty
    @Size(min = 14, max = 14)
    private String cpf;

    private LocalDate dataDeNascimento;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REMOVE})
    @Valid
    @NotEmpty
    private List<Telefone> telefones;
}
