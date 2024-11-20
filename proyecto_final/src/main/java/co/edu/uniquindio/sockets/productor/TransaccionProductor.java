package co.edu.uniquindio.sockets.productor;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.uniquindio.DTO.TransaccionDTO;

public class TransaccionProductor {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private String exchange = "intercambio-transaccion-luxora";
    private String routingKey = "transaccion.key";

    public void enviarTransaccion(TransaccionDTO transaccion) {
        amqpTemplate.convertAndSend(exchange, routingKey, transaccion);
        System.out.println("Transacción enviada: " + transaccion);
    }
    
}
