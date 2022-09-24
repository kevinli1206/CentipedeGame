import java.util.ArrayList;
import tester.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import java.awt.Color;

/**
 * To represent the person the player controls in the centipede game.
 */
public class Player {
  private Posn posn;

  /**
   * Player constructor.
   * @param posn the position of the player.
   */
  public Player(Posn posn) {
    this.posn = posn;
  }

  /**
   * Get the position of the player.
   * @return the posn value of the player
   */
  public Posn getPosn() {
    return this.posn;
  }

  /**
   * Set the posn of the player to the given posn.
   * @param p the posn to set the player to.
   */
  public void setPosn(Posn p) {
    this.posn = p;
  }

  /**
   * Draw the image of the player.
   * @return a black rectangle representing the player.
   */
  public WorldImage drawPlayer() {
    return new RectangleImage(20, 20, OutlineMode.SOLID, Color.GREEN);
  }
}
