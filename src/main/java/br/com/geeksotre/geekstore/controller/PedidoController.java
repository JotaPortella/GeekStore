package br.com.geeksotre.geekstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.geeksotre.geekstore.controller.dto.PedidoDto;
import br.com.geeksotre.geekstore.service.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@PostMapping("/produtos")
	public void cadastraPedido(@RequestBody @Validated PedidoDto novoPedido) {

		pedidoService.cadastrarPedido(novoPedido);

	}
}
