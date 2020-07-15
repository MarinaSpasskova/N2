package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  extends Thread {
    private Socket socket;
    private PrintWriter outgoingMessage;
    private BufferedReader incommingMessage;
    Prediction prediction = new Prediction();

    public Server (Socket socket) throws IOException {
        this.socket = socket;
        incommingMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outgoingMessage = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    public void run() {
        prediction.createPredictionList("Prediction.json");
        try {
            while (true) {
                System.out.println("Waiting for incomming Message...");
                String receivedZodiacSing = incommingMessage.readLine();
                String today = prediction.addActualDate();
                prediction.getZodiacSingsName(receivedZodiacSing);
                prediction.getDayOfWeek();
                String predictionForToday = prediction.getHoroscopeForToday(receivedZodiacSing);
                System.out.println("Nietzsche`s horoscope for " + receivedZodiacSing + " for today " + today
                        + " is " + predictionForToday);
                outgoingMessage.write("Nietzsche`s horoscope for " + receivedZodiacSing + " for today " + today
                        + " is " + predictionForToday);
                outgoingMessage.write("\n");
                outgoingMessage.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket isn`t closed!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (true) {
                System.out.println("The multithreaded server is started!");
                Socket socket = serverSocket.accept();
                try {
                    System.out.println("New connection is accepted from: " + socket.getRemoteSocketAddress());
                    new Server(socket);
                } catch (IOException e) {
                    System.err.println(e);
                    socket.close();
                }
            }
        }
    }

}
