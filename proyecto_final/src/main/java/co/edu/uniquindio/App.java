package co.edu.uniquindio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Luxora Wallet -Inicia sesión-");
        scene = new Scene(loadFXML("inicioSesion"), 800, 500);

        Image logo = new Image(getClass().getResourceAsStream("imagenes/LogoWallet.png"));
        stage.getIcons().add(logo);

        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml, String title) throws IOException {
        scene.setRoot(loadFXML(fxml));

        if (stage != null) {
            stage.setTitle(title);
        } 
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
