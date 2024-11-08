package co.edu.uniquindio.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import co.edu.uniquindio.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ChatBotController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_enviarPregunta;

    @FXML
    private Text btn_regresar;

    @FXML
    private Label txt_respuesta;

    @FXML
    private TextField txt_pregunta;

    @FXML
    void btn_enviarPregunta(ActionEvent event) {
        String preguntaUsuario = txt_pregunta.getText();

        // Aquí va la lógica para buscar la respuesta
        String respuesta = buscarRespuesta(preguntaUsuario);
        
        // Mostrar la respuesta en la interfaz
        txt_respuesta.setText(respuesta);
    }
                                   
    private String buscarRespuesta(String pregunta) {
        return preguntasRespuestas.getOrDefault(pregunta, "Lo siento, no encontré una respuesta a esa pregunta.");
    }

    private Map<String, String> preguntasRespuestas = new HashMap<>();{
        preguntasRespuestas.put("¿Cómo creo una billetera?", "Ya lo hiciste! de no ser así no podrías estar hablando con nosotros");
        preguntasRespuestas.put("¿Cómo recupero mi contraseña?", "Dirigete al apartado de actualizar datos desde tu perfil, allí podrás modificar lo que quieras");
        preguntasRespuestas.put("¿Cómo puedo ver mi historial de transacciones?", "Para ver tu historial de transacciones, simplemente haz clic en el botón \"Ver transacciones\". Ten en cuenta que estamos trabajando para solucionar un problema que ocasiona duplicados en la visualización.");
        preguntasRespuestas.put("¿Cómo puedo registrarme en LuxoraWallet?", "Para registrarte, dirígete a la sección de registro y completa el formulario con tus datos. Tu información se almacenará de forma segura en nuestros servidores y en archivos locales.");
        preguntasRespuestas.put("¿Qué tipo de archivos utilizan para almacenar la información de los usuarios?", "Utilizamos archivos binarios y XML para almacenar la información de los usuarios. Estos archivos se encuentran en la carpeta C:/td/persistencia.");
        preguntasRespuestas.put("¿Cómo puedo actualizar mis datos personales?", "Actualmente estamos trabajando en mejorar la funcionalidad para actualizar los datos de los usuarios. Pronto podrás modificar tus datos directamente desde la aplicación.");
        preguntasRespuestas.put("¿Cómo funciona el chatbot financiero?", "El chatbot financiero utiliza tecnología de procesamiento de lenguaje natural para entender tus preguntas y proporcionarte respuestas relevantes.");
        preguntasRespuestas.put("¿Qué pasa si olvido mi contraseña?", "Estamos trabajando en implementar una función para recuperar contraseñas olvidadas. Pronto podrás solicitar un restablecimiento de contraseña a través de tu correo electrónico.");
        preguntasRespuestas.put("¿Es segura mi información en LuxoraWallet?", "La seguridad de tus datos es nuestra prioridad. Utilizamos medidas de seguridad avanzadas para proteger tu información personal.");
        preguntasRespuestas.put("¿Qué tipo de transacciones puedo realizar con LuxoraWallet?", "Con LuxoraWallet puedes realizar una variedad de transacciones, como transferencias, pagos y compras en línea.");
        preguntasRespuestas.put("¿Puedo acceder a mi billetera desde mi teléfono móvil?", "Actualmente, LuxoraWallet está diseñada para ser utilizada desde una computadora. Sin embargo, estamos explorando la posibilidad de desarrollar una aplicación móvil en el futuro.");
    }
        
    @FXML
    void btn_regresar(MouseEvent event) throws IOException {
        App.setRoot("usuarioView", "Luxora Wallet - Pagina principal");
    }

    @FXML
    void initialize() {
        assert btn_enviarPregunta != null : "fx:id=\"btn_enviarPregunta\" was not injected: check your FXML file 'chatbot.fxml'.";
        assert btn_regresar != null : "fx:id=\"btn_regresar\" was not injected: check your FXML file 'chatbot.fxml'.";
        assert txt_respuesta != null : "fx:id=\"txt_transacciones\" was not injected: check your FXML file 'chatbot.fxml'.";

    }

}
