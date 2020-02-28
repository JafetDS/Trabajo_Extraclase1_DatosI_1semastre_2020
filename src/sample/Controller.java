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
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.AccessibleAction;

import static javafx.scene.input.KeyCode.T;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;


/**
 *
 * @author User
 */

public class Controller implements Initializable {
    @FXML
    private VBox vbox;
    public TextField puerto_in;
    public int Puerto;
    public TextField ip_in;
    public TextArea Caja_de_texto;
    public Button Conectar;
    public Button ENVIAR;

    @FXML
    public void enviar(ActionEvent event) throws Exception {
        String IP=ip_in.getText();
        int port=Integer.parseInt(puerto_in.getText());
        String mensaje=Caja_de_texto.getText();
        Sockets.newSocket(IP, port,mensaje);
        Button label=new Button ();
        label.setText(Caja_de_texto.getText());


        label.setStyle("-fx-background-color:#ffd653");;
        vbox.getChildren().add(label);

    }

    private String conectar2() throws Exception{
        String mensaje=Sockets.newServer(Integer.parseInt(puerto_in.getText()));
        Button label=new Button (mensaje);


        label.setStyle("-fx-background-color:#30ff74");;
        vbox.getChildren().add(label);
        return "palo";

    }
    @FXML
    private void conectar(ActionEvent event)throws Exception{

        conectar2();

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Puerto=Integer.parseInt(puerto_in.getText());
       // recibido();

     /**   for (int i = 0; i < 15; i++) {
            Button button1 = new Button("Button Number 1");
            Button button2 = new Button("Button Number 2");

            HBox hbox = new HBox(button1, button2);


            vbox.getChildren().add(hbox);

        }
        */


    }
}