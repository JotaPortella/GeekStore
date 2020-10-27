package br.com.geeksotre.geekstore.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.geeksotre.geekstore.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	Cliente findByCodigoCliente(String codigoCliente);

}
