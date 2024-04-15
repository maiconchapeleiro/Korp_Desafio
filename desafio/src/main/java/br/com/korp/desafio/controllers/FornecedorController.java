package br.com.korp.desafio.controllers;

import br.com.korp.desafio.dtos.ClienteDto;
import br.com.korp.desafio.dtos.FornecedorDto;
import br.com.korp.desafio.models.Cliente;
import br.com.korp.desafio.models.Fornecedor;
import br.com.korp.desafio.services.ClienteService;
import br.com.korp.desafio.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("buscar/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedor(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedor(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<FornecedorDto>> buscarTodosFornecedores() {
        List<FornecedorDto> listaFornecedoresDtos = fornecedorService.buscarTodosFornecedores().stream().map(FornecedorDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaFornecedoresDtos);
    }

    @PostMapping("/criar")
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = fornecedorService.criarFornecedor(fornecedorDto.toFornecedor());
        return ResponseEntity.ok().body(fornecedor);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Fornecedor> editarFornecedor(@PathVariable Long id, @RequestBody FornecedorDto fornecedorDto) {
        try {
            Fornecedor fornecedor = fornecedorService.editarFornecedor(id, fornecedorDto.toFornecedor());
            return ResponseEntity.ok().body(fornecedor);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        try {
            fornecedorService.deletarFornecedor(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
