/**
 * To represent the PebblePile obstacle in the centipede game.
 */
public class PebblePile implements IObstacle {

  @Override
  public boolean isDandelion() {
    return false;
  }

  @Override
  public boolean isPebblePile() {
    return true;
  }
}
