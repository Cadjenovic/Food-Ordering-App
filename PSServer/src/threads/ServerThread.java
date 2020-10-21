/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luka
 */
public class ServerThread extends Thread{

    private ServerSocket serverSocket;
    List<ClientThread> clients;

    public ServerThread() throws IOException {
        serverSocket=new ServerSocket(9000);
        clients=new ArrayList<>();
    }

    @Override
    public void run() {
        while(!serverSocket.isClosed()){
            System.out.println("Cekanje klijenta...");
            try {
                Socket socket=serverSocket.accept();
                ClientThread client=new ClientThread(socket);
                client.start();
                clients.add(client);
                System.out.println("Klijent konektovan");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        stopClientHandlers();
    }
    
    public  void stopServerThread() throws IOException{
        serverSocket.close();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    private void stopClientHandlers(){
        for (ClientThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
