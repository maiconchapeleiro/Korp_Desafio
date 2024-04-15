package br.com.korp.desafio.models;


import br.com.korp.desafio.models.abstratics.Entidade;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Cliente extends Entidade {

    private String cpf;
    private String rg;

}
