package co.edu.uniquindio.sockets.productor.config;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Channel;

public class RabbitFactory {

    private static final String HOST = "localhost";
    private static final int PORT = 3123;
    private static final String USERNAME = "Forest";
    private static final String PASSWORD = "hola_unu";

    private ConnectionFactory connectionFactory;

    public RabbitFactory() {
        this.connectionFactory = new ConnectionFactory();
        this.connectionFactory.setHost(HOST);
        this.connectionFactory.setPort(PORT);
        this.connectionFactory.setUsername(USERNAME);
        this.connectionFactory.setPassword(PASSWORD);
    }

    public Connection createConnection() throws IOException, TimeoutException {
        return this.connectionFactory.newConnection();
    }
    
    public Channel createChannel() throws IOException, TimeoutException {
        Connection connection = createConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("luxora-transaction-queue", true, false, false, null);
        return channel;
    }
    
}
