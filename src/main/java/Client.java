import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        //сокет для подключения к серверу
        Socket clientSocket = new Socket("127.0.0.1", 8000);

        //создаем поток записи, чтобы клиент отправлял запрос серверу
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        //создаем поток чтения, чтобы клиент получал данные от сервера
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        writer.write("Get me some information");
        writer.newLine();
        writer.flush();

        String response = reader.readLine();
        System.out.println(response);

        writer.close();
        reader.close();
        clientSocket.close();
    }
}
