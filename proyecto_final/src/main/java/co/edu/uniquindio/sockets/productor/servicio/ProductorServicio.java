package co.edu.uniquindio.sockets.productor.servicio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import co.edu.uniquindio.sockets.productor.config.RabbitFactory;

public class ProductorServicio {
    private static final String QUEUE_NAME = "transacciones_queue";

    public static void main(String[] args) {
        RabbitFactory rabbitFactory = new RabbitFactory();

        Connection connection = null;
        Channel channel = null;
        try {
            connection = rabbitFactory.createConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            String mensaje = "Transacción importante";
            channel.basicPublish("", QUEUE_NAME, null, mensaje.getBytes(StandardCharsets.UTF_8));

            System.out.println("Mensaje enviado: " + mensaje);

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException | TimeoutException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
