package br.com.korp.desafio.dtos;

import br.com.korp.desafio.models.Cliente;
import br.com.korp.desafio.models.DadosTrabalhistas;
import br.com.korp.desafio.models.Funcionario;
import lombok.Data;

@Data
public class FuncionarioDto {

    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String telefone;
    private String tipoPessoa;
    private DadosTrabalhistasDto dadosTrabalhistasDto;

    public FuncionarioDto() {

    }

    public FuncionarioDto(Funcionario funcionario){
        this.setId(funcionario.getId());
        this.setNome(funcionario.getNome());
        this.setRg(funcionario.getRg());
        this.setCpf(funcionario.getCpf());
        this.setEmail(funcionario.getEmail());
        this.setTelefone(funcionario.getTelefone());
        this.setTipoPessoa(funcionario.getTipoPessoa());
        this.setDadosTrabalhistasDto(new DadosTrabalhistasDto(funcionario.getDadosTrabalhistas()));
    }

    public Funcionario toFuncionario() {
        Funcionario funcionario = new Funcionario();

        funcionario.setId(this.getId());
        funcionario.setNome(this.getNome());
        funcionario.setRg(this.getRg());
        funcionario.setCpf(this.getCpf());
        funcionario.setEmail(this.getEmail());
        funcionario.setTelefone(this.getTelefone());
        funcionario.setTipoPessoa(this.getTipoPessoa());
        funcionario.setDadosTrabalhistas(this.dadosTrabalhistasDto.toDadosTrabalhistas());

        return funcionario;
    }

}
