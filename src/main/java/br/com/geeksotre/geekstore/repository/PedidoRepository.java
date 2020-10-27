package br.com.geeksotre.geekstore.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.geeksotre.geekstore.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}
