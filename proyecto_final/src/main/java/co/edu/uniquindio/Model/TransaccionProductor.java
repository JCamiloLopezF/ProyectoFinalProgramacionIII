package co.edu.uniquindio.Model;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TransaccionProductor {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String QUEUE_NAME = "transaccionesQueue";

    public void enviarTransaccion(Transaccion transaccion) {
        amqpTemplate.convertAndSend(QUEUE_NAME, transaccion);
    }
    
}
