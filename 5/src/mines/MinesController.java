package mines;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MinesController {
	private Mines field;
	private FieldButtons[][] fieldButtons;
	private int width, height, numOfMines;
	private HBox hbox;
	private Stage stage;
    private Label popUpLabel;
	
    @FXML
    private TextField textFieldWidth;

    @FXML
    private TextField textFieldHeight;

    @FXML
    private TextField textFieldMines;
    
    @FXML
    void pressReset(ActionEvent event) {
    	initGame();
    }
    
    /**
     * Initialize the game by creating the game field and setting up the UI.
     */
    public void initGame() {
    	GridPane gridPane = new GridPane();
    	List<ColumnConstraints> column = new ArrayList<>();
    	List<RowConstraints> row = new ArrayList<>();
    	getValuesFromUser();
    	// Check input from user and throw an exception if necessary
    	
    	field = new Mines(height, width, numOfMines);
    	fieldButtons = new FieldButtons[height][width];
    	
    	initSizeFieldButtons(column, row);
    	startGame(gridPane);
    	
    	gridPane.getColumnConstraints().addAll(column);
    	gridPane.getRowConstraints().addAll(row);
    	
    	hbox.getChildren().remove(hbox.getChildren().size()-1);
    	hbox.getChildren().add(gridPane);
    	hbox.autosize();
    	stage.sizeToScene();
    }
    
    /**
     * Get the values for width, height, and number of mines from the user input fields.
     */
    private void getValuesFromUser() {
    	width = Integer.valueOf(textFieldWidth.getText());
    	height = Integer.valueOf(textFieldHeight.getText());
    	numOfMines = Integer.valueOf(textFieldMines.getText());
    }
    
    /**
     * Initialize the size of the field buttons based on the width and height of the game field.
     */
    private void initSizeFieldButtons(List<ColumnConstraints> column, List<RowConstraints> row) {
    	for(int i=0; i<width; i++)
    		column.add(new ColumnConstraints(35));
    	for(int i=0; i<height; i++)
    		row.add(new RowConstraints(35));
    }
    
    /**
     * Start the game by creating the field buttons, setting their properties,
     * and adding them to the grid pane.
     */
    private void startGame(GridPane gridPane) {
    	for(int i=0; i<height; i++) {
    		for(int j=0; j<width; j++) {
    			fieldButtons[i][j] = new FieldButtons(i, j);
    			fieldButtons[i][j].setText(field.get(i, j));
    			fieldButtons[i][j].setStyle("-fx-background-color: \r\n"
    					+ "#000000,\r\n"
    					+ "linear-gradient(#7ebcea, #2f4b8f),\r\n"
    					+ "linear-gradient(#426ab7, #263e75),\r\n"
    					+ "linear-gradient(#395cab, #223768); -fx-text-fill: #ffffff");
    			fieldButtons[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if(event.getButton() == MouseButton.PRIMARY) { // Left click - open the block that the user wants.
							boolean isReset = field.open(((FieldButtons) event.getSource()).getX(),
									((FieldButtons) event.getSource()).getY());
							updateFieldButtons();
							if(!isReset) {
								field.setShowAll(true);
								updateFieldButtons();
								popUpWindow(true, false);
							}
							if(field.isDone()) {
								popUpWindow(false, true);
							}
						}
						if (event.getButton() == MouseButton.SECONDARY) { // Right click - put a flag.
							int x = ((FieldButtons) event.getSource()).getX();
							int y = ((FieldButtons) event.getSource()).getY();
							field.toggleFlag(x, y);
						}
					}
    			});
    			fieldButtons[i][j].setMaxWidth(Double.MAX_VALUE);
    			fieldButtons[i][j].setMaxHeight(Double.MAX_VALUE);
    			gridPane.add(fieldButtons[i][j], j, i);
    		}
    	}
    }
    
    /**
     * Update the field buttons based on the game field state.
     */
    private void updateFieldButtons() {
    	for(int i=0; i<height; i++)
    		for(int j=0; j<width; j++) {
    			fieldButtons[i][j].setText(field.get(i, j));
    			if(!fieldButtons[i][j].getText().equals(".") && !fieldButtons[i][j].getText().equals(" ") && !fieldButtons[i][j].getText().equals("X")) {
    				fieldButtons[i][j].setGraphic(null);
    				fieldButtons[i][j].setStyle("-fx-background-color: \r\n"
    							+ "linear-gradient(#ffd65b, #e68400),\r\n"
    							+ "linear-gradient(#ffef84, #f2ba44),\r\n"
    							+ "linear-gradient(#ffea6a, #efaa22),\r\n"
    							+ "linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\r\n"
    							+ "linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\r\n"
    							+ "-fx-background-insets: 0,1,2,3,0;\r\n"
    							+ "-fx-text-fill: #654b00;\r\n"
    							+ "-fx-font-weight: bold;\r\n"
    							+ "-fx-font-size: 15px;\r\n;");
    			}
    			if(fieldButtons[i][j].getText().equals("X")) {
    				fieldButtons[i][j].setText("");
    				fieldButtons[i][j].setStyle("-fx-background-color:red");
    				Image xImage = new Image("mines/bomb.png");
    				ImageView view = new ImageView(xImage);
    				view.setFitHeight(15);
    				view.setPreserveRatio(true);
    				fieldButtons[i][j].setGraphic(view);
    			}
    			if(fieldButtons[i][j].getText().equals("F")) {
    				fieldButtons[i][j].setText("");
    				fieldButtons[i][j].setStyle("-fx-background-color: \r\n"
    						+ "rgba(0,0,0,0.08),\r\n"
    						+ "linear-gradient(#9a9a9a, #909090),\r\n"
    						+ "linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\r\n"
    						+ "-fx-background-insets: 0 0 -1 0,0,1;");
    				Image flagImage = new Image("mines/flag.png");
    				ImageView view = new ImageView(flagImage);
    				view.setFitHeight(25);
    				view.setPreserveRatio(true);
    				fieldButtons[i][j].setGraphic(view);
    			}
    		}
    }


    /**
     * Sets the HBox container for the MinesController.
     *
     * @param hbox The HBox container to set.
     */
    public void setHbox(HBox hbox) {
        this.hbox = hbox;
    }

    /**
     * Sets the Stage for the MinesController.
     *
     * @param stage The Stage to set.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Displays a pop-up window indicating the game status.
     *
     * @param isOver Indicates if the game is over.
     * @param isDone Indicates if the game is completed.
     */
    private void popUpWindow(boolean isOver, boolean isDone) {
        Scene popUp = new Scene(initHBox(isOver, isDone), 300, 100);
        Stage popUpStage = new Stage();
        popUpStage.setScene(popUp);
        popUpStage.show();
    }

    /**
     * Initializes and returns an HBox for the pop-up window.
     *
     * @param isOver Indicates if the game is over.
     * @param isDone Indicates if the game is completed.
     * @return The initialized HBox.
     */
    private HBox initHBox(boolean isOver, boolean isDone) {
        HBox hbox = new HBox();
        if (isOver)
            popUpLabel = new Label("You just lost!");
        else if (isDone)
            popUpLabel = new Label("You Won!");
        popUpLabel.setFont(Font.font(null, FontWeight.BOLD, 20));
        hbox.setPadding(new Insets(30, 20, 20, 80));
        hbox.getChildren().addAll(popUpLabel);
        return hbox;
    }

    /**
     * Retrieves the TextField representing the width value.
     *
     * @return The TextField for the width.
     */
    public TextField getTextFieldWidth() {
        return textFieldWidth;
    }

    /**
     * Retrieves the TextField representing the height value.
     *
     * @return The TextField for the height.
     */
    public TextField getTextFieldHeight() {
        return textFieldHeight;
    }

    /**
     * Retrieves the TextField representing the number of mines value.
     *
     * @return The TextField for the number of mines.
     */
    public TextField getTextFieldMines() {
        return textFieldMines;
        }
}