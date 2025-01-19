/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleclintserverapp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Taj
 */
public class SimpleClintServerApp {

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public static void main(String[] args) {
        new SimpleClintServerApp();
    }

    public SimpleClintServerApp() {
        try {
            mySocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println("I am the clint");
            String replyMsg = dis.readLine();

            System.out.println(replyMsg);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                dis.close();
                mySocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
