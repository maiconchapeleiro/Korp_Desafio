package br.com.korp.desafio.models.abstratics;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public abstract class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String tipoPessoa;
    private String telefone;
    private Date dataCadastro;
    private Date ultimaAtualizacao;
}
