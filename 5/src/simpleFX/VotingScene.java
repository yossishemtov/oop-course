package simpleFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class VotingScene extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private int voteCount; // Variable to store the vote count

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new scene with the configured VBox layout
        Scene scene = new Scene(initVBox(), 225, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Voting Machine");
        primaryStage.show();
    }

    /**
     * Initializes the VBox layout containing the voting buttons and vote count label.
     *
     * @return the configured VBox layout
     */
    private VBox initVBox() {
        VBox vbox = new VBox();
        Label label = new Label("0"); // Create a label to display the vote count
        label.setFont(Font.font(null, FontWeight.BOLD, 18)); // Set the font and weight for the label
        Button ofraButton = new Button("Ofra Haza"); // Create a button for voting for Ofra Haza
        Button yardenaButton = new Button("Yardena Arazi"); // Create a button for voting for Yardena Arazi
        GridPane buttonGrid = new GridPane(); // Create a grid pane to arrange the voting buttons

        // Event handler to increment the vote count and update the label
        class VoteIncrementer implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                voteCount++; // Increment the vote count
                label.setText(Integer.toString(voteCount)); // Update the label with the new vote count
            }
        }

        // Event handler to decrement the vote count and update the label
        class VoteDecrementer implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                voteCount--; // Decrement the vote count
                label.setText(Integer.toString(voteCount)); // Update the label with the new vote count
            }
        }

        ofraButton.setOnAction(new VoteIncrementer()); // Assign the VoteIncrementer event handler to the Ofra Haza button
        yardenaButton.setOnAction(new VoteDecrementer()); // Assign the VoteDecrementer event handler to the Yardena Arazi button

        label.setPrefHeight(40); // Set the preferred height of the label
        label.setStyle("-fx-background-color:red"); // Set the background color of the label
        label.setAlignment(Pos.CENTER); // Center align the text in the label
        label.setPrefWidth(Double.MAX_VALUE); // Set the preferred width of the label to occupy the entire width
        ofraButton.setMaxWidth(Double.MAX_VALUE); // Set the maximum width of the Ofra Haza button to occupy the available width
        yardenaButton.setMaxWidth(Double.MAX_VALUE); // Set the maximum width of the Yardena Arazi button to occupy the available width
        yardenaButton.setPadding(new Insets(5, 10, 5, 20)); // Set padding for the Yardena Arazi button
        ofraButton.setPadding(new Insets(5, 10, 5, 15)); // Set padding for the Ofra Haza button
        buttonGrid.add(ofraButton, 0, 0); // Add the Ofra Haza button to the grid pane
        buttonGrid.add(yardenaButton, 2, 0); // Add the Yardena Arazi button to the grid pane
        buttonGrid.setPadding(new Insets(0, 1, 20, 1)); // Set padding for the grid pane
        buttonGrid.setHgap(10); // Set the horizontal gap between the buttons in the grid pane
        vbox.setAlignment(Pos.CENTER); // Center align the VBox layout

        vbox.setPadding(new Insets(10)); // Set padding for the VBox layout
        vbox.getChildren().addAll(buttonGrid, label); // Add the button grid and label to the VBox layout
        return vbox; // Return the configured VBox layout
    }
}
