package br.com.geeksotre.geekstore.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.geeksotre.geekstore.controller.dto.PedidoDto;
import br.com.geeksotre.geekstore.model.Cliente;
import br.com.geeksotre.geekstore.model.Entrega;
import br.com.geeksotre.geekstore.model.Pedido;
import br.com.geeksotre.geekstore.model.Produto;
import br.com.geeksotre.geekstore.repository.ClienteRepository;
import br.com.geeksotre.geekstore.repository.EntregaRepository;
import br.com.geeksotre.geekstore.repository.PedidoRepository;
import br.com.geeksotre.geekstore.repository.ProdutoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private RabbitMQSender rabbitMQSender;

	public void processar(Pedido pedido) {

		Entrega entrega = new Entrega();
		entrega.setEndereco(pedido.getCliente().getEndereco());
		entrega.setBairro(pedido.getCliente().getBairro());
		entrega.setCep(pedido.getCliente().getCep());
		entrega.setCidade(pedido.getCliente().getCidade());
		entrega.setEstado(pedido.getCliente().getEstado());
		entrega.setIdpedido(pedido.getId());
		entregaRepository.save(entrega);

	}

	public void cadastrarPedido(PedidoDto novoPedido) {
		double total = 0.00;
		
		Cliente c = clienteRepository.findByCodigoCliente(novoPedido.getCodigoCliente());
		
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		for (int i = 0; i < novoPedido.getListaProdutos().size(); i++) {
			Produto buscaProduto = produtoRepository.findByCodigoProdutos(novoPedido.getListaProdutos().get(i));
			listaProdutos.add(buscaProduto);
			total += buscaProduto.getValorProduto();

		}

		Pedido atualPedido = new Pedido();
		atualPedido.setCliente(c);
		atualPedido.setProduto(listaProdutos);
		atualPedido.setValorTotal(total);

		pedidoRepository.save(atualPedido);
		rabbitMQSender.send(atualPedido);
	}
}