package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sockets {
    public static int newSocket (String Ip, int port,String mensaje)  {
        try {
            Socket soket=new Socket(Ip,port);
            DataOutputStream salida = new DataOutputStream(soket.getOutputStream());
            salida.writeUTF(mensaje);
            salida.close();
            return port;

        } catch (IOException e) {
            newSocket(Ip,port+1,mensaje);
        }
        return 0;
    }
    public static void newServer(int port){
        String mensaje=null;
        try {
            ServerSocket server = new ServerSocket(port);
            while (mensaje==null) {

                Socket servert = server.accept();
                DataInputStream entrada = new DataInputStream(servert.getInputStream());
                mensaje = entrada.readUTF();

                entrada.close();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
