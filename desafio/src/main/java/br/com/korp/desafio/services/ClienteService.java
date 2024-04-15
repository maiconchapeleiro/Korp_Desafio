package br.com.korp.desafio.services;

import br.com.korp.desafio.models.Cliente;
import br.com.korp.desafio.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return  cliente.get();
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente criarCliente(Cliente cliente) {
        cliente.setDataCadastro(new Date());
        cliente.setUltimaAtualizacao(new Date());

        return clienteRepository.saveAndFlush(cliente);
    }

    public Cliente editarCliente(Long id, Cliente cliente) throws Exception {
        Cliente clienteOld = buscarCliente(id);
        clienteOld.setNome(cliente.getNome());
        clienteOld.setEmail(cliente.getEmail());
        clienteOld.setTipoPessoa(cliente.getTipoPessoa());
        clienteOld.setTelefone(cliente.getTelefone());
        clienteOld.setRg(cliente.getRg());
        clienteOld.setCpf(cliente.getCpf());
        clienteOld.setUltimaAtualizacao(new Date());

        return clienteRepository.saveAndFlush(clienteOld);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
