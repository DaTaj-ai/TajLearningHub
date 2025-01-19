package simpleserverclintapp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerClintApp {

    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;

    public static void main(String[] args) {
        new SimpleServerClintApp();
    }

    public SimpleServerClintApp() {
        try {
            myServerSocket = new ServerSocket(5005);
            s = myServerSocket.accept();
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            String msg = dis.readLine();
            System.out.println(msg);
            ps.println("from server side");
        
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                dis.close();
                s.close();
                myServerSocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
