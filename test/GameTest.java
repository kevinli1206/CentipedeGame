import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import tester.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import java.awt.Color;

/**
 * To test the Game class.
 */
public class GameTest {

  @Test(expected = IllegalArgumentException.class)
  public void testGameConstructorInvalidWidth() {
    new Game(1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameConstructorInvalidHeight() {
    new Game(2, 1);
  }

  @Test
  public void testDrawRow() {
    Game g1 = new Game(2, 2);
    Game g2 = new Game(3, 3);
    WorldImage tile1 = new Tile().drawTile();
    assertEquals(new BesideImage(tile1, new BesideImage(tile1, new EmptyImage())), g1.drawRow(0, 0));
    assertEquals(new BesideImage(tile1, new BesideImage(tile1, new BesideImage(tile1, new EmptyImage()))), g2.drawRow(2, 0));
  }

  @Test
  public void testDrawGrid() {
    Game g1 = new Game(2, 2);
    Game g2 = new Game(3, 3);
    WorldScene w1 = new WorldScene(100, 100);
    WorldScene w2 = new WorldScene(150, 150);
    WorldImage row1 = g1.drawRow(0, 0);
    WorldImage row2 = g2.drawRow(0, 0);
    WorldImage grid1 = new AboveImage(new EmptyImage(), new AboveImage(row1, row1));
    WorldImage grid2 = new AboveImage(new EmptyImage(), new AboveImage(row2, new AboveImage(row2, row2)));
    w1.placeImageXY(grid1, 50, 50);
    w2.placeImageXY(grid2, 75, 75);
    assertEquals(g2.drawGrid(), w2);
  }

  @Test
  public void testOnMousePressed() {
    Game g1 = new Game(2, 2);
    assertEquals(g1.getBoard().get(0).get(0).getObstacle(), null);
    g1.onMousePressed(new Posn(25, 25), "LeftButton");
    assertTrue(g1.getBoard().get(0).get(0).getObstacle().isDandelion());
    g1.onMousePressed(new Posn(49, 49), "LeftButton");
    assertEquals(g1.getBoard().get(0).get(0).getObstacle(), null);
    g1.onMousePressed(new Posn(1, 1), "RightButton");
    assertEquals(g1.getBoard().get(0).get(0).getObstacle().isPebblePile(), true);
  }

  @Test
  public void testOnKeyEvent() {
    Game g1 = new Game(5, 5);
    for (List<Tile> lt: g1.getBoard()) {
      for (Tile t: lt) {
        assertEquals(t.getObstacle(), null);
      }
    }
    assertEquals(g1.getPlayer().getPosn(), new Posn(25, 225));
    g1.onKeyEvent("left");
    g1.onKeyEvent("left");
    assertEquals(g1.getPlayer().getPosn(), new Posn(15, 225));
    g1.onKeyEvent("left");
    assertEquals(g1.getPlayer().getPosn(), new Posn(15, 225));
    g1.onKeyEvent("right");
    assertEquals(g1.getPlayer().getPosn(), new Posn(20, 225));
  }
}
