package sample;

import javafx.fxml.Initializable;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.AccessibleAction;

import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;


/**
 *
 * @author User
 */

public class Controller implements Initializable {
    @FXML
    public VBox vbox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (int i = 0; i < 15; i++) {
            Button button1 = new Button("Button Number 1");
            Button button2 = new Button("Button Number 2");

            HBox hbox = new HBox(button1, button2);


            vbox.getChildren().add(hbox);
        }



    }
}