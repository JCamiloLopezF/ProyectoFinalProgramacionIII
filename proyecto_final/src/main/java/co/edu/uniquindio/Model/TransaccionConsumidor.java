package co.edu.uniquindio.Model;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransaccionConsumidor {

    @Autowired
    private TransaccionServicio transaccionServicio;

    @RabbitListener(queues = "luxora-transaction-queue")
    public void processTransaction(TransaccionDTO transaction) {
        System.out.println("Procesando transacción: " + transaction);
        transaccionServicio.processTransaction(transaction);
    }
}
