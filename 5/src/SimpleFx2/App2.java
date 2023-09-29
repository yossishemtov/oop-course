package SimpleFx2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VBox root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("myfile.fxml")); // Specify the FXML file location
            root = loader.load(); // Load the FXML file and obtain the root node
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        Scene scene = new Scene(root); // Create a scene with the root node as the content
        stage.setScene(scene); // Set the created scene as the scene of the stage
        stage.show(); // Display the stage with the loaded FXML content

    }
}
