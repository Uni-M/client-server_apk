import java.net.*;
import java.io.IOException;
//import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {

        //создаем простейший сервер
        ServerSocket serverSocket = new ServerSocket(8000);  //этот сокет используется, чтобы серверное подключение и на сервере создать ожидание клиентов

        //System.out.println("start");  //проверяем что он работает в браузере http://127.0.0.1:8000/
        serverSocket.accept(); //accept - чтобы начать слушать порт 8000, получаем подключение клиента. После создается сокет клиента
        //System.out.println("end");
        serverSocket.close();
    }
}
