import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TV {
  Socket socket;
  private BufferedReader fromServer;
  private PrintWriter toServer;

  public void turnOn(String ip, int port) throws IOException {
    socket = new Socket(ip, port);
    fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    toServer = new PrintWriter(socket.getOutputStream(), true);
  }

  public String watchTvShow(String tvShow) throws IOException {
    toServer.println(tvShow);
    return fromServer.readLine();
  }

  public void turnOff() throws IOException {
    toServer.close();
    fromServer.close();
    socket.close();
  }
}
