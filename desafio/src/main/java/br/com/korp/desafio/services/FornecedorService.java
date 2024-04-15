package br.com.korp.desafio.services;

import br.com.korp.desafio.models.Fornecedor;
import br.com.korp.desafio.repositorys.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor buscarFornecedor(Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return  fornecedor.get();
    }

    public List<Fornecedor> buscarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        fornecedor.setDataCadastro(new Date());
        fornecedor.setUltimaAtualizacao(new Date());

        return fornecedorRepository.saveAndFlush(fornecedor);
    }

    public Fornecedor editarFornecedor(Long id, Fornecedor fornecedor) throws Exception {
        Fornecedor fornecedorOld = buscarFornecedor(id);
        fornecedorOld.setNome(fornecedor.getNome());
        fornecedorOld.setEmail(fornecedor.getEmail());
        fornecedorOld.setTipoPessoa(fornecedor.getTipoPessoa());
        fornecedorOld.setTelefone(fornecedor.getTelefone());
        fornecedorOld.setCnpj(fornecedor.getCnpj());
        fornecedorOld.setUltimaAtualizacao(new Date());

        return fornecedorRepository.saveAndFlush(fornecedorOld);
    }

    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

}
