package br.com.korp.desafio.dtos;

import br.com.korp.desafio.models.Cliente;
import lombok.Data;

@Data
public class ClienteDto {

    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String telefone;
    private String tipoPessoa;

    public ClienteDto() {

    }

    public ClienteDto(Cliente cliente){
        this.setId(cliente.getId());
        this.setNome(cliente.getNome());
        this.setRg(cliente.getRg());
        this.setCpf(cliente.getCpf());
        this.setEmail(cliente.getEmail());
        this.setTelefone(cliente.getTelefone());
        this.setTipoPessoa(cliente.getTipoPessoa());
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente();

        cliente.setId(this.getId());
        cliente.setNome(this.getNome());
        cliente.setRg(this.getRg());
        cliente.setCpf(this.getCpf());
        cliente.setEmail(this.getEmail());
        cliente.setTelefone(this.getTelefone());
        cliente.setTipoPessoa(this.getTipoPessoa());

        return cliente;
    }

}
