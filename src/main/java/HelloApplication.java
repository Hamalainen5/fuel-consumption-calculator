import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale defaultLocale = new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", defaultLocale);

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("/hello-view.fxml"),
                bundle
        );

        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Fuel Consumption Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}