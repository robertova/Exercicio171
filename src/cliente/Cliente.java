package cliente;

import java.io.*;
import java.net.*;

public class Cliente {
    public static String client(String frase,String servidor) throws Exception {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        Socket clientSocket = new Socket(servidor, 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        sentence = frase;
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();      
        clientSocket.close();
        return modifiedSentence;
    }
}

