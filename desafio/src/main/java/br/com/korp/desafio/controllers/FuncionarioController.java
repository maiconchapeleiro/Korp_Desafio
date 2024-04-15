package br.com.korp.desafio.controllers;

import br.com.korp.desafio.dtos.ClienteDto;
import br.com.korp.desafio.models.Cliente;
import br.com.korp.desafio.services.ClienteService;
import br.com.korp.desafio.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("buscar/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
        Cliente cliente = funcionarioService.buscarCliente(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ClienteDto>> buscarTodosClientes() {
        List<ClienteDto> listaClientesDtos = funcionarioService.buscarTodosClientes().stream().map(ClienteDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaClientesDtos);
    }

    @PostMapping("/criar")
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteDto clienteDto) {
        Cliente Cliente = clienteService.criarCliente(clienteDto.toCliente());
        return ResponseEntity.ok().body(Cliente);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        try {
            Cliente cliente = clienteService.editarCliente(id, clienteDto.toCliente());
            return ResponseEntity.ok().body(cliente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        try {
            clienteService.deletarCliente(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
