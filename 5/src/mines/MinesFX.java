package mines;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MinesFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox hbox; // Container for the game screen
        MinesController controller; // Reference to the controller for handling game logic
        stage.setTitle("The Amazing Minesweeper"); // Set the title of the stage

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Screen.fxml")); // Specify the FXML file location
            hbox = loader.load(); // Load the FXML file and obtain the root node (HBox)
            controller = loader.getController(); // Get the controller instance from the loader
            GridPane grindPane = new GridPane(); // Grid pane for the game grid
            controller.setHbox(hbox); // Pass the hbox to the controller
            /*
             * When the user opens the game, the default values for width, height, and mines
             * are set to 10. The user can change these parameters by inserting new values
             * and clicking on the reset button.
             */
            TextField textFieldWidth = controller.getTextFieldWidth(); // Get the width TextField from the controller
            TextField textFieldHeight = controller.getTextFieldHeight(); // Get the height TextField from the controller
            TextField textFieldMines = controller.getTextFieldMines(); // Get the mines TextField from the controller
            textFieldWidth.setText("10"); // Set default width value
            textFieldHeight.setText("10"); // Set default height value
            textFieldMines.setText("10"); // Set default mines value
            controller.setStage(stage); // Pass the stage to the controller
            /* Setting the background for the side panel of the game (hbox) */
            BackgroundSize backgroundSize = new BackgroundSize(140, 200, true, true, true, false); // Specify the background size
            BackgroundImage image = new BackgroundImage(new Image("mines/images1.png"), // Create the background image
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize);
            hbox.setBackground(new Background(image)); // Set the background image for the hbox
            hbox.getChildren().add(grindPane); // Add the grid pane to the hbox
            controller.initGame(); // Initialize the game
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(hbox); // Create a scene with the hbox as the content
        stage.setScene(scene); // Set the created scene as the scene of the stage
        stage.show(); // Display the stage
    }

}
