package org.example;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int port = 8809;
        int i = 0;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                i++;
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("Соединение номер " + i + " установлено");
                    final String name = in.readLine();
                    out.println("Hi " + name + " твой порт " + clientSocket.getPort());
                    out.println("Напиши сове имя");
                    final String answer = in.readLine();
                    if (answer.equals(name)) {
                        System.out.println("done");
                        out.println("Welcome");
                    } else {
                        System.out.println("Не верный пользователь ");
                        break;
                    }
                    out.println("Are you child? (yes/no)");
                    String yORn = in.readLine();
                    if (yORn.equals("y") || yORn.equals("yes")) {
                        out.println("Welcome to the kids area, " + name + " ! Let's play!");
                    } else if (yORn.equals("n") || yORn.equals("no")) {
                        out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                    }

                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();

        }

    }
}

