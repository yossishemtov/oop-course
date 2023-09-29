package SimpleFx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MtController 
{
    private int counter = 0; // Counter variable initialized to 0

    @FXML
    private Button b1; // Reference to Button b1 in the FXML file

    @FXML
    private Button b2; // Reference to Button b2 in the FXML file

    @FXML
    private Label result; // Reference to Label result in the FXML file

    @FXML
    void decreaser(ActionEvent event) // Event handler for b2 button's action
    {
        counter--; // Decrease the value of counter by 1
        result.setText(String.format("%d", counter)); // Update the label's text with the current counter value
    }

    @FXML
    void increaser(ActionEvent event) // Event handler for b1 button's action
    {
        counter++; // Increase the value of counter by 1
        result.setText(String.format("%d", counter)); // Update the label's text with the current counter value
    }
}
