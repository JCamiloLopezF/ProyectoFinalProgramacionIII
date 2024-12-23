module co.edu.uniquindio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.graphics;
    requires java.desktop;
    requires jdk.jfr;
    requires java.xml;
    requires spring.beans;
    requires spring.amqp;
    requires spring.rabbit;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires com.rabbitmq.client;

    opens co.edu.uniquindio to javafx.fxml;
    exports co.edu.uniquindio;

    opens co.edu.uniquindio.Controller;
    exports co.edu.uniquindio.Controller;

    opens co.edu.uniquindio.Model;
    exports co.edu.uniquindio.Model;

    opens co.edu.uniquindio.Persistencia;
    exports co.edu.uniquindio.Persistencia;
}
