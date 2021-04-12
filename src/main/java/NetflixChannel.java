import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetflixChannel extends Thread {
  public static String IP = "127.0.0.1";
  public static int PORT = 50;


  public void run()  {

    ServerSocket GotChannel =  new ServerSocket(50);
    while (true)
    {
        Socket socketForClient = GotChannel.accept();
        new TvShowHandler(socketForClient, "Game of Thrones").start();

    }

  }

  public static void main(String[] args) throws IOException {
    NetflixChannel netflixServer = new NetflixChannel();
    netflixServer.start();
  }
}
