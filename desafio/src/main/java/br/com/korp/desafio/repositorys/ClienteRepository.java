package br.com.korp.desafio.repositorys;

import br.com.korp.desafio.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
