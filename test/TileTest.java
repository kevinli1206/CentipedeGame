import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;
import tester.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import java.awt.Color;

/**
 * To test the Tile class.
 */
public class TileTest {

  Tile nullTile = new Tile();
  Tile dandTile = new Tile();
  IObstacle dandelion = new Dandelion();
  Tile ppTile = new Tile();
  IObstacle pebblePile = new PebblePile();

  @Test
  public void testGetObstacle() {
    assertEquals(nullTile.getObstacle(), null);

    dandTile.setObstacle(dandelion);
    assertEquals(dandTile.getObstacle(), dandelion);

    ppTile.setObstacle(pebblePile);
    assertEquals(ppTile.getObstacle(), pebblePile);
  }

  @Test
  public void testSetObstacle() {
    assertEquals(dandTile.getObstacle(), null);
    assertEquals(ppTile.getObstacle(), null);

    dandTile.setObstacle(dandelion);
    ppTile.setObstacle(pebblePile);

    assertEquals(dandTile.getObstacle(), dandelion);
    assertEquals(ppTile.getObstacle(), pebblePile);
  }

  @Test
  public void testDrawTile() {
    WorldImage dandelionImage = new RectangleImage(20, 20, OutlineMode.SOLID, Color.YELLOW);
    WorldImage pebblesImage = new RectangleImage(20, 20,OutlineMode.SOLID, Color.gray);
    WorldImage base =  new RectangleImage(40, 40, OutlineMode.SOLID, Color.WHITE);
    WorldImage background = new RectangleImage(50, 50, OutlineMode.SOLID, Color.BLACK);
    WorldImage entireVertex = new OverlayImage(base, background);
    assertEquals(nullTile.drawTile(), entireVertex);

    dandTile.setObstacle(dandelion);
    ppTile.setObstacle(pebblePile);

    WorldImage dandelionTile = new OverlayImage(dandelionImage, entireVertex);
    WorldImage pebblesTile = new OverlayImage(pebblesImage, entireVertex);
    assertEquals(dandTile.drawTile(), dandelionTile);
    assertEquals(ppTile.drawTile(), pebblesTile);

  }
}
