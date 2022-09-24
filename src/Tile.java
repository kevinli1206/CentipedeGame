import java.util.ArrayList;
import tester.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import java.awt.Color;

/**
 * To represent a single block in the Centipede game.
 */
public class Tile {

  private IObstacle obstacle;

  /**
   * Tile constructor.
   * @param obstacle
   */
  public Tile(IObstacle obstacle) {
    this.obstacle = obstacle;
  }

  /**
   * Default Tile constructor.
   */
  public Tile() {
    this.obstacle =  null;
  }

  /**
   * Set this tile's obstacle to the given obstacle.
   * @param obstacle the obstacle to set this tile's obstacle to
   */
  public void setObstacle(IObstacle obstacle) {
    this.obstacle = obstacle;
  }

  /**
   * Draw the Tile.
   * @return An image of the given Tile.
   */
  public WorldImage drawTile() {
    WorldImage dandelion = new RectangleImage(20, 20 ,OutlineMode.SOLID, Color.YELLOW);
    WorldImage pebbles = new RectangleImage(20, 20, OutlineMode.SOLID, Color.gray);
    WorldImage base = new RectangleImage(40, 40, OutlineMode.SOLID, Color.WHITE);
    WorldImage background = new RectangleImage(50, 50, OutlineMode.SOLID, Color.BLACK);
    WorldImage entireVertex = new OverlayImage(base, background);

    if (obstacle == null) {
      return entireVertex;
    }
    else if (obstacle.isPebblePile()) {
      return new OverlayImage(pebbles, entireVertex);
    }
    else {
      return new OverlayImage(dandelion, entireVertex);
    }
  }

  /**
   *
   * @return
   */
  public IObstacle getObstacle() {
    return this.obstacle;
  }
}
