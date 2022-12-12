package com.ae2dms.bubblebobble.controller;

import com.ae2dms.bubblebobble.GamePanel;
import com.ae2dms.bubblebobble.Main;
import com.ae2dms.bubblebobble.marks.Marks;
import com.ae2dms.bubblebobble.model.removable.fruit.Fruit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The overController controls the actions in game end interface.
 * This is the controller of over.fxml file.
 *
 * @author Ke Liu
 */

public class overController {
    Fruit fruit;

    @FXML
    private Button back;

    @FXML
    private Button play_again;

    @FXML
    private Label score;

    @FXML
    private Label one;

    @FXML
    private Label two;

    @FXML
    private Label three;

    @FXML
    private Label four;

    @FXML
    private Label five;

    @FXML
    private Label record;


    /**
     * Initialize the game end List interface and list the top five score.
     *
     * @throws IOException If the target score list file does not exist, then throws exception.
     */


    @FXML
    private void initialize() throws IOException {
        Marks marks = new Marks();
        marks.readMarks();
        marks.order();
        if (fruit.score >= marks.ranklist.get(4)) {
            record.setText("New Record!");
        }
        score.setText("Your score:  " + String.valueOf(fruit.score));
        one.setText("1st: " + marks.ranklist.get(0));
        two.setText("2nd: " + marks.ranklist.get(1));
        three.setText("3rd: " + marks.ranklist.get(2));
        four.setText("4th: " + marks.ranklist.get(3));
        five.setText("5th: " + marks.ranklist.get(4));
    }

    /**
     * If click back button, return to the homepage.
     *
     * @param event MouseEvent type, here means mouse click the button.
     * @throws IOException If the target fxml file does not exist, then throw IOException.
     */
    @FXML
    void onMouseClickedback(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Main.getSCENE_WIDTH(), Main.getSCENE_HEIGHT());
        Stage stage = Main.stage;
        stage.setTitle("BubbleBobble HomePage");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * If click play again button, return to the game interface and play.
     *
     * @param event MouseEvent type, here means mouse click the button.
     * @throws IOException If the target fxml file does not exist, then return exception.
     */

    @FXML
    void onMouseClickedplay(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Main.getSCENE_WIDTH(), Main.getSCENE_HEIGHT());
        Stage stage = Main.stage;
        stage.setTitle("BubbleBobble");
        stage.setScene(scene);
        stage.show();
        new GamePanel();
    }

    /**
     * If move the mouse over the help button, then change the color of button to yellow.
     *
     * @param event MouseEvent type, here means mouse moves over the button.
     */

    @FXML
    void onMouseEnteredback(MouseEvent event) {
        back.setTextFill(Color.YELLOW);
    }

    /**
     * If move the mouse over the help button, then change the color of button to yellow.
     *
     * @param event MouseEvent type, here means mouse moves over the button.
     */

    @FXML
    void onMouseEnteredplay(MouseEvent event) {
        play_again.setTextFill(Color.YELLOW);
    }

    /**
     * If the mouse moves away from the button, then changes the color of the button to white.
     *
     * @param event MouseEvent type, here means mouse moves away from the button.
     */

    @FXML
    void onMouseExitedback(MouseEvent event) {
        back.setTextFill(Color.WHITE);
    }

    /**
     * If the mouse moves away from the button, then changes the color of the button to white.
     *
     * @param event MouseEvent type, here means mouse moves away from the button.
     */

    @FXML
    void onMouseExitedplay(MouseEvent event) {
        play_again.setTextFill(Color.WHITE);
    }

}




