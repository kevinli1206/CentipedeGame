import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;
import tester.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import java.awt.Color;

/**
 * To test the Player class.
 */
public class PlayerTest {
  Player p1 = new Player(new Posn(0, 0));
  Player p2 = new Player(new Posn(-1, -1));
  Player p3 = new Player(new Posn(1, 1));

  @Test
  public void testGetPosn() {
    assertEquals(new Posn(0, 0), p1.getPosn());
    assertEquals(new Posn(-1, -1), p2.getPosn());
    assertEquals(new Posn(1, 1), p3.getPosn());
  }

  @Test
  public void testSetPosn() {
    assertEquals(new Posn(0, 0), p1.getPosn());
    assertEquals(new Posn(-1, -1), p2.getPosn());
    assertEquals(new Posn(1, 1), p3.getPosn());

    p1.setPosn(new Posn(-1, 1));
    p2.setPosn(new Posn(2, 1));
    p3.setPosn(new Posn(-10, 5));

    assertEquals(new Posn(-1, 1), p1.getPosn());
    assertEquals(new Posn(2, 1), p2.getPosn());
    assertEquals(new Posn(-10, 5), p3.getPosn());
  }

  @Test
  public void testDrawPlayer() {
    assertEquals(p1.drawPlayer(), new RectangleImage(20, 20, OutlineMode.SOLID, Color.GREEN));
    assertEquals(p2.drawPlayer(), new RectangleImage(20, 20, OutlineMode.SOLID, Color.GREEN));
    assertEquals(p3.drawPlayer(), new RectangleImage(20, 20, OutlineMode.SOLID, Color.GREEN));
  }
}
