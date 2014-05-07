package servidor;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void server() throws Exception {
        String clientSentence;
        String capitalizedSentence = "";
        ServerSocket welcomeSocket = new ServerSocket(6789);

        
        while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            String[] frase = clientSentence.split(";");
            if (frase[1].equals("A")) {
                capitalizedSentence = String.valueOf(frase[0].length()) + '\n';
            } else if (frase[1].equals("B")) {
                String cortada = frase[0].trim();
                int cuenta = cortada.split("\\s+").length;
                System.out.println(cuenta);
                capitalizedSentence = String.valueOf(cuenta) + '\n';              
            } else if (frase[1].equals("C")) {
                capitalizedSentence = frase[0].replaceAll("\\s+","") + '\n';
            }
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
