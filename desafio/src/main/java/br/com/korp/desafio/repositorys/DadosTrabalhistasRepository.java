package br.com.korp.desafio.repositorys;

import br.com.korp.desafio.models.DadosTrabalhistas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosTrabalhistasRepository extends JpaRepository<DadosTrabalhistas, Long> {
}
