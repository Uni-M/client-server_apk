import java.io.OutputStreamWriter;
import java.net.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


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
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream()); //труба для связи. Клиент получает ответ
//            writer.write("HTTP/1.0 200 OK\r\n" +                //получаем поток
//                             "Content-type: text/html\r\n" +
//                             "\r\n" +
//                             "<h1>Hello <h1>" + clientCount + "\r\n");
            writer.write("You are client #" + clientCount + "\r\n");
            writer.flush();
            writer.close();

            clientSocket.close();
        }
        //serverSocket.close();
    }
}
