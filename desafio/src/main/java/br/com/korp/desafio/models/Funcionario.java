package br.com.korp.desafio.models;

import br.com.korp.desafio.models.abstratics.Entidade;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Funcionario extends Entidade {

    private String cpf;
    private String rg;

    @OneToOne
    private DadosTrabalhistas dadosTrabalhistas;

}
