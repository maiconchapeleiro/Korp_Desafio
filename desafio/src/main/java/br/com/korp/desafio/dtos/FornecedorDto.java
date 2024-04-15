package br.com.korp.desafio.dtos;

import br.com.korp.desafio.models.Cliente;
import br.com.korp.desafio.models.Fornecedor;
import lombok.Data;

@Data
public class FornecedorDto {

    private Long id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String tipoPessoa;

    public FornecedorDto() {

    }

    public FornecedorDto(Fornecedor fornecedor){
        this.setId(fornecedor.getId());
        this.setNome(fornecedor.getNome());
        this.setCnpj(fornecedor.getCnpj());
        this.setEmail(fornecedor.getEmail());
        this.setTelefone(fornecedor.getTelefone());
        this.setTipoPessoa(fornecedor.getTipoPessoa());
    }

    public Fornecedor toFornecedor() {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setId(this.getId());
        fornecedor.setNome(this.getNome());
        fornecedor.setCnpj(this.getCnpj());
        fornecedor.setEmail(this.getEmail());
        fornecedor.setTelefone(this.getTelefone());
        fornecedor.setTipoPessoa(this.getTipoPessoa());

        return fornecedor;
    }

}
