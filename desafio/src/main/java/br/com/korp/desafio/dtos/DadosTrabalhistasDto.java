package br.com.korp.desafio.dtos;


import br.com.korp.desafio.models.DadosTrabalhistas;
import lombok.Data;

@Data
public class DadosTrabalhistasDto {

    private String posicao;
    private double salario;

    public DadosTrabalhistasDto(){

    }

    public DadosTrabalhistasDto(DadosTrabalhistas dadosTrabalhistas){
        this.setPosicao(dadosTrabalhistas.getPosicao());
        this.setSalario(dadosTrabalhistas.getSalario());
    }

    public DadosTrabalhistas toDadosTrabalhistas(){
        DadosTrabalhistas dadosTrabalhistas = new DadosTrabalhistas();

        dadosTrabalhistas.setPosicao(this.getPosicao());
        dadosTrabalhistas.setSalario(this.getSalario());

        return dadosTrabalhistas;
    }
}
