import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class NetflixTest {

  @Test
  public void watchGameOfThrones() throws IOException {
    System.out.println("connecting to port 50");
    TV livingRoomTv = new TV();

    System.out.println("turn on and start watching");
    livingRoomTv.turnOn("127.0.0.1", 50);

    String response = livingRoomTv.watchTvShow("Game of Thrones");
    assertEquals("Start watching Game of Thrones", response);

    String response2 = livingRoomTv.watchTvShow("Game of Thrones");
    assertEquals("Start watching Game of Thrones", response2);

    String response3 = livingRoomTv.watchTvShow("Suits");
    assertEquals("Don't have that", response3);


    System.out.println("connecting to port 50");
    TV livingRoomTv2 = new TV();
    livingRoomTv2.turnOn("127.0.0.1", 50);
    assertEquals("Start watching Game of Thrones", livingRoomTv2.watchTvShow("Game of Thrones"));
    assertEquals("Start watching Game of Thrones", livingRoomTv2.watchTvShow("Game of Thrones"));
    assertEquals("Start watching Game of Thrones", livingRoomTv2.watchTvShow("Game of Thrones"));
    assertEquals("Don't have that", livingRoomTv2.watchTvShow("Games "));

//
//
//    System.out.println("connecting to port 60");
//
//    TV bedroomTv = new TV("127.0.0.1", 60);
//    System.out.println("connected to port 60 and start watching");
//    bedroomTv.turnOn();
//    String response2 = bedroomTv.watchTvShow("Game of Thrones");
//    assertEquals("Don't have that", response2);
  }
}
