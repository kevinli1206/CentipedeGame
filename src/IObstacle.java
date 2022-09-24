/**
 * Represents all the types of obstacles in the centipede game.
 */
public interface IObstacle {

  /**
   * Checks to see if the current obstacle is a dandelion
   * @return whether or not the obstacle is a dandelion
   */
  public boolean isDandelion();

  /**
   * Checks to see if the current obstacle is a pebble pile
   * @return whether or not the obstacle is a pebble pile
   */
  public boolean isPebblePile();
}

