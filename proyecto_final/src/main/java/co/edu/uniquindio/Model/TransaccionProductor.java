package co.edu.uniquindio.Model;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

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
