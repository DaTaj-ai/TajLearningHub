package chatroomserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatRoomServer {

    ServerSocket serverSocket;

    Socket s;
    DataInputStream dis;
    PrintStream ps;
    
     public ChatRoomServer() {
        try {
            serverSocket = new ServerSocket(5005);
            while (true) {
                System.out.println("this is the ");
                Socket s = serverSocket.accept();
                System.out.println(s.getInetAddress());
                System.out.println(s.getInetAddress());
                System.out.println("this is the 22");
                new ChatHandler(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatRoomServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        ChatRoomServer crs =  new ChatRoomServer();
        
    }

   
}

class ChatHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    static LinkedHashSet<ChatHandler> clientsSet = new LinkedHashSet<ChatHandler>();

    public ChatHandler(Socket cs) {
        try {
            System.out.println("new connection" +cs.getInputStream() );
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            ChatHandler.clientsSet.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (true) {
            String str = null;
            try {
                str = dis.readLine();
                sendMessageToAll(str);
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void sendMessageToAll(String msg) {
        //for (int i = 0; i < clientsSet.size(); i++) 
        for(ChatHandler lHS :clientsSet)
        {
            lHS.ps.println(msg);
            //clientsSet.get(i).ps.println(msg);
           System.out.println("sent new message");
       // }
    }
}
}