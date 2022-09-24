import java.util.ArrayList;
import java.util.List;
import tester.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import java.awt.Color;

/**
 * To run the Centipede game.
 */
public class Main {
  public static void main(String[] args) {
    Game g1 = new Game(10, 10);
    g1.bigBang(1000, 1000);
  }
}
