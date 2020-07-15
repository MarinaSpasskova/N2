package sample;

import java.io.*;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Client extends Thread {
    private Socket clientSocket;
    private BufferedReader incomingMessage;
    private BufferedWriter outcomingMessage;
    //private String recievedZodiacSing;
    private String dayHoroscope;

    public void contactToServer (String receivedZodiacSing) throws IOException {
        try {
            System.out.println("The client is started!");
            clientSocket = new Socket("localhost", 1234);
            outcomingMessage = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            outcomingMessage.write(receivedZodiacSing);
            outcomingMessage.write("\n");
            outcomingMessage.flush();
            incomingMessage = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
            dayHoroscope = incomingMessage.readLine();
            System.out.println("We received horoscope for " + receivedZodiacSing + " " + dayHoroscope);
        } catch (UnknownHostException e) {
            System.out.println("The host isn`t found!");
        } catch (NoRouteToHostException e) {
            System.out.println("The server isn`t available!");
        } catch (IOException e) {
            System.out.println("The connection request is rejected!");
        }
        incomingMessage.close();
        clientSocket.close();
        System.out.println("The client is disconnected!");
    }

    public String getDayHoroscope() {
        return dayHoroscope;
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.contactToServer("Crab");
    }
}
