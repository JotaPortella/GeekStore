package br.com.geeksotre.geekstore.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.geeksotre.geekstore.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	Produto findByCodigoProdutos(String codigoProdutos);

}
