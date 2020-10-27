package br.com.geeksotre.geekstore.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.geeksotre.geekstore.model.Entrega;

public interface EntregaRepository extends CrudRepository<Entrega, Long> {
	
}
