import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8086;
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            boolean cont = true;
            while (cont) {
                System.out.println(in.readLine());
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("end")) {
                    cont = false;
                } else {
                    out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Сервер не отвечает.");
        }
    }
}
