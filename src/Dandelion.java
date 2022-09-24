/**
 * To represent the Dandelion obstacle in the centipede game.
 */
public class Dandelion implements IObstacle {

  @Override
  public boolean isDandelion() {
    return true;
  }

  @Override
  public boolean isPebblePile() {
    return false;
  }
}
