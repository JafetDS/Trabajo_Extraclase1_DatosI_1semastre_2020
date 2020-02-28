package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sockets {
    public static void newSocket (String Ip, int port,String mensaje)  throws Exception {
        try {
            Socket soket = new Socket(Ip, port);
            DataOutputStream salida = new DataOutputStream(soket.getOutputStream());
            salida.writeUTF(mensaje);
            salida.close();

        }
        catch (UnknownHostException e){
                System.out.println("jua2");
                System.out.println(e.getMessage());

        }
        catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
    public static String newServer(int port){
        String mensaje;
        try {
            ServerSocket server = new ServerSocket(port);
            Socket servert = server.accept();
            DataInputStream entrada = new DataInputStream(servert.getInputStream());
            mensaje = entrada.readUTF();

            entrada.close();
            return mensaje;


        }
        catch (UnknownHostException e) {
            System.out.println(e.getMessage());
            return "null";
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
            return "null";
        }

    }
}
