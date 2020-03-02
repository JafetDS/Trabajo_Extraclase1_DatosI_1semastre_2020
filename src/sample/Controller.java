package sample;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.*;
import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;


/**
 *
 * @author User
 */

public class Controller implements Initializable,Runnable{

    @FXML
    public VBox vbox;
    public TextField puerto_in;
    public TextField ip_in;
    public TextArea Caja_de_texto;
    public String mensaje;
    public ServerSocket server1;

    //192.168.100.27

    @FXML
    public void enviar(ActionEvent event) throws Exception {
        Sockets.newSocket(ip_in.getText(),Integer.parseInt(puerto_in.getText()),Caja_de_texto.getText());
        Button label=new Button ();
        label.setText(Caja_de_texto.getText());
        label.setStyle("-fx-background-color:#ffa750");
        label.setWrapText(true);
        VBox pane= new VBox();
        pane.setAlignment(Pos.TOP_RIGHT);
        pane.setPadding(new Insets(0,0,0,40));
        pane.getChildren().add(label);
        vbox.getChildren().add(pane);
        Caja_de_texto.setText("");
      //  vbox.setAlignment(Pos.BASELINE_LEFT);



    }



    @FXML
    private void conectar(ActionEvent event) {
        try {
            server1=new ServerSocket(Integer.parseInt(puerto_in.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        mensaje = Sockets.newServerlistening(server1);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        thread2.start();


    }



    @Override
    public void run() {
        Runnable updater = new Runnable() {
            @Override
            public void run() {
                Button label = new Button(mensaje);
                label.setStyle("-fx-background-color:#ffd653 ");
                label.setWrapText(true);
                VBox pane= new VBox();
                pane.setAlignment(Pos.TOP_LEFT);
                pane.setPadding(new Insets(0,40,0,0));
                pane.getChildren().add(label);
                vbox.getChildren().add(pane);
                mensaje=" ";
            }
        };
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
            // UI update is run on the Application thread
            if (mensaje!=" ") {
                Platform.runLater(updater);
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mensaje=" ";
        Thread hilo=new Thread(this);
        hilo.start();
        vbox.setPadding(new Insets(5,10,0,10));
        vbox.setSpacing(5);
    }

}