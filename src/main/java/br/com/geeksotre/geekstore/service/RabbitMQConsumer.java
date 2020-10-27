package br.com.geeksotre.geekstore.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.geeksotre.geekstore.model.Pedido;

@Component
public class RabbitMQConsumer {
	
	@Autowired
	private PedidoService pedidoService;

	@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
	public void recievedMessage(Pedido pedido) {
		System.out.println("Recieved Message From RabbitMQ: " + pedido);
		pedidoService.processar(pedido);
	}

}

