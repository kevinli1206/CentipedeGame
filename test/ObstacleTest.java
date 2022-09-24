import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * To test the Obstacle interface.
 */
public class ObstacleTest {

  IObstacle dandelion = new Dandelion();
  IObstacle pebblePile = new PebblePile();

  @Test
  public void testIsDandelion() {

    assertTrue(dandelion.isDandelion());
    assertFalse(pebblePile.isDandelion());
  }

  @Test
  public void testIsPebblePile() {

    assertTrue(pebblePile.isPebblePile());
    assertFalse(dandelion.isPebblePile());
  }

}
