import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TvShowHandler extends Thread{
  private Socket socketForClient;
  private String tvShowName;
  private BufferedReader fromClient;
  private PrintWriter toClient;


  TvShowHandler(Socket socketForClient, String tvShowName) {
    this.socketForClient = socketForClient;
    this.tvShowName = tvShowName;
  }

  @Override
  public void run() {
    try {
      fromClient = new BufferedReader(new InputStreamReader(socketForClient.getInputStream()));
      toClient = new PrintWriter(socketForClient.getOutputStream(), true);

      String message;

      while ((message = fromClient.readLine()) != null) {
        if (tvShowName.equals(message)) {
          toClient.println("Start watching " + tvShowName);
        } else if ("turn off".equals(message)){
          toClient.println("turning off");
          break;
        } else {
          toClient.println("Don't have that");
        }
      }

      socketForClient.close();

    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}
