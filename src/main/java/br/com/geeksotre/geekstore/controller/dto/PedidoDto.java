package br.com.geeksotre.geekstore.controller.dto;

import java.util.List;
import com.sun.istack.NotNull;

public class PedidoDto {

	@NotNull
	private String codigoCliente;
	@NotNull
	private List<String> listaProdutos;
	
	public PedidoDto() {
		
	}

	public PedidoDto(String codigoCliente, List<String> listaProdutos) {
		super();
		this.codigoCliente = codigoCliente;
		this.listaProdutos = listaProdutos;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public List<String> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<String> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
