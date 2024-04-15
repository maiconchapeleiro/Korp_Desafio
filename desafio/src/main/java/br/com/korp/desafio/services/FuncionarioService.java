package br.com.korp.desafio.services;

import br.com.korp.desafio.models.Cliente;
import br.com.korp.desafio.models.Funcionario;
import br.com.korp.desafio.repositorys.ClienteRepository;
import br.com.korp.desafio.repositorys.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario buscarFuncionario(Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return  funcionario.get();
    }

    public List<Funcionario> buscarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {
        funcionario.setDataCadastro(new Date());
        funcionario.setUltimaAtualizacao(new Date());

        return funcionarioRepository.saveAndFlush(funcionario);
    }

    public Funcionario editarFuncionario(Long id, Funcionario funcionario) throws Exception {
        Funcionario funcionarioOld = buscarFuncionario(id);
        funcionarioOld.setNome(funcionario.getNome());
        funcionarioOld.setEmail(funcionario.getEmail());
        funcionarioOld.setTipoPessoa(funcionario.getTipoPessoa());
        funcionarioOld.setTelefone(funcionario.getTelefone());
        funcionarioOld.setRg(funcionario.getRg());
        funcionarioOld.setCpf(funcionario.getCpf());
        funcionarioOld.setUltimaAtualizacao(new Date());
        funcionarioOld.setDadosTrabalhistas(funcionario.getDadosTrabalhistas());

        return funcionarioRepository.saveAndFlush(funcionarioOld);
    }

    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
