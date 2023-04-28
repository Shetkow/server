import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String localhost = "netology.homework";
        int port = 8809;

        try (Socket clientSocket = new Socket(localhost, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            out.println("Pavel");
            String resp = in.readLine();
            System.out.println(resp);
            String y = in.readLine();
            System.out.println(y);
            String answer = scanner.nextLine();
            out.println(answer);
            String serverAn = in.readLine();
            System.out.println(serverAn);
            String resp3 = in.readLine();
            System.out.println(resp3);
            String adult = scanner.nextLine();
            out.println(adult);
            String resp4 = in.readLine();
            System.out.println(resp4);


        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }
}