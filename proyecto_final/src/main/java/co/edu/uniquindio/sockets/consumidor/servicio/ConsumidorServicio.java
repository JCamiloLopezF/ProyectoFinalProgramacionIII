package co.edu.uniquindio.sockets.consumidor.servicio;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import co.edu.uniquindio.sockets.productor.config.RabbitFactory;

public class ConsumidorServicio {

    private static final String QUEUE_NAME = "transacciones_queue";
    private RabbitFactory rabbitFactory;

    public ConsumidorServicio() {
        this.rabbitFactory = new RabbitFactory();
    }

    public void enviarMensaje(String mensaje) {
        try {
            Channel channel = rabbitFactory.createChannel();
            channel.basicPublish("", "luxora-transaction-queue", null, mensaje.getBytes());
            System.out.println("Mensaje enviado: " + mensaje);
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recibirMensajes() {
        try {
            Connection connection = rabbitFactory.createConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mensaje = new String(delivery.getBody(), "UTF-8");
                System.out.println("Mensaje recibido: " + mensaje);
                // Procesar el mensaje y actualizar los datos
            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
