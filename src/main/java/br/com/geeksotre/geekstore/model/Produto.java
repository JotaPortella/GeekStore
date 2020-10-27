package br.com.geeksotre.geekstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Long id;
	private String codigoProdutos;
	private String nomeProduto;
	private double valorProduto;

	public Produto(Long id, String codigoProdutos, String nomeProduto, double valorProduto) {
		super();
		this.id = id;
		this.codigoProdutos = codigoProdutos;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
	}
	
	public Produto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoProdutos() {
		return codigoProdutos;
	}

	public void setCodigoProdutos(String codigoProdutos) {
		this.codigoProdutos = codigoProdutos;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

}
