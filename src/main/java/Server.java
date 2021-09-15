import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        //проверяем что он работает в браузере http://127.0.0.1:8000/ или telnet 127.0.0.1 8000
        //создаем простейший сервер
        ServerSocket serverSocket = new ServerSocket(8000);  //этот сокет используется, чтобы серверное подключение и на сервере создать ожидание клиентов

        int clientCount = 0;

        while (true){
            //accept - чтобы начать слушать порт 8000, получаем подключение клиента. После создается сокет клиента
            Socket clientSocket = serverSocket.accept();        //Клиент подключился
            System.out.println("Client accepted " + ++clientCount);

            //создаем поток записи, чтобы сервер отправлял ответ
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            //создаем поток чтения, чтобы сервер читал запрос клиента
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String request = reader.readLine();
            String response = "#" + clientCount + ", your message length is " + request.length();

            writer.write(response);
            writer.newLine();
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }
        //serverSocket.close();
    }
}