import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tester.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import java.awt.Color;

/**
 * To represent the state of the centipede game.
 */
public class Game extends World {

  private int width;
  private int height;
  private Player player;
  private Centipede centipede;
  private List<List<Tile>> board;
  private boolean gameStart;

  /**
   * Default game constructor.
   *
   * @param width  the width of the board
   * @param height the height of the board
   */
  public Game(int width, int height) {
    if (width < 2 || height < 2) {
      throw new IllegalArgumentException("Width and/or height less than 2");
    }
    this.width = width;
    this.height = height;
    this.centipede = new Centipede();
    this.board = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      this.board.add(new ArrayList<Tile>());
    }
    for (int i = 0; i < height; i++) {
      for (int h = 0; h < width; h++) {
        this.board.get(i).add(new Tile());
      }
    }
    this.player = new Player(new Posn(25, this.height * 50 - 25));
    this.gameStart = false;
  }

  /**
   * Get the board of this game.
   * @return the list of list of tiles representing the board.
   */
  public List<List<Tile>> getBoard() {
    return this.board;
  }

  /**
   * Get the player of this game.
   * @return the player.
   */
  public Player getPlayer() {
    return this.player;
  }

  /**
   * Draw a row of tiles.
   *
   * @param rowNumber  the integer representing the row to be drawn.
   * @param tileNumber the integer representing the tile in the row to be drawn
   * @return the image of the row of tiles.
   */
  WorldImage drawRow(int rowNumber, int tileNumber) {
    if (tileNumber == this.width) {
      return new EmptyImage();
    } else {
      return new BesideImage(this.board.get(rowNumber).get(tileNumber).drawTile(),
          this.drawRow(rowNumber, tileNumber + 1));
    }
  }

  /**
   * Draw the whole grid of tiles.
   *
   * @return the WorldImage of the board
   */
  WorldScene drawGrid() {
    WorldScene currentScene = new WorldScene(this.width * 50, this.height * 50);
    WorldImage imageSoFar = new EmptyImage();

    for (int i = 0; i < this.height; i++) {
      WorldImage currentRow = this.drawRow(i, 0);
      imageSoFar = new AboveImage(imageSoFar, currentRow);
    }

    currentScene.placeImageXY(imageSoFar, this.width * 25, this.height * 25);
    return currentScene;
  }

  /**
   * Randomly cover 5% of the board with the given obstacle
   * @param obstacle the obstacle to cover the board with.
   */
  private void randomCover(IObstacle obstacle) {
    int fivePercent = ((this.height * this.width) - this.width) / 20;
    Random rand = new Random();
    for (int i = 0; i < fivePercent; i++) {
      Tile randTile = this.board.get(rand.nextInt(height - 1)).get(rand.nextInt(width));
      randTile.setObstacle(obstacle);
    }
  }

  @Override
  public void onMousePressed(Posn pos, String buttonName) {
    Tile clicked;
    if (gameStart) {
      return;
    } else {
      if (pos.x < width * 50 && pos.y < (height * 50 - 50)) {
        clicked = board.get((pos.y / 50)).get((pos.x / 50));
        if (buttonName.equals("RightButton")) {
          if (clicked.getObstacle() == null) {
            clicked.setObstacle(new PebblePile());
          }
        } else if (buttonName.equals("LeftButton")) {
          if (clicked.getObstacle() == null) {
            clicked.setObstacle(new Dandelion());
          } else {
            clicked.setObstacle(null);
          }
        }
      }
    }
  }

  @Override
  public void onKeyEvent(String key) {
    // if game has not started, randomly cover 5% of the game board with dandelions.
    if (key.equals("D")) {
      if (gameStart) {
        return;
      }
      else {
        this.randomCover(new Dandelion());
      }
    }
    // if game has not started, randomly cover 5% of the game board with pebble piles.
    else if (key.equals("P")) {
      if (gameStart) {
        return;
      }
      else {
        this.randomCover(new PebblePile());
      }
    }
    // if game has not started, remove all obstacles from tiles on the board.
    else if (key.equals("R")) {
      if (gameStart) {
        return;
      } else {
        for (int i = 0; i < height; i++) {
          for (Tile t : board.get(i)) {
            t.setObstacle(null);
          }
        }
      }
    }
    // move the player to the right if not already on the rightmost part of the board.
    else if (key.equals("right")) {
      if (player.getPosn().x < width * 50 - 15) {
        player.setPosn(new Posn(player.getPosn().x + 5, player.getPosn().y));
      }
    }
    // move the player to the left if not already on the leftmost part of the board.
    else if (key.equals("left")) {
      if (player.getPosn().x > 15) {
        player.setPosn(new Posn(player.getPosn().x - 5, player.getPosn().y));
      }
    }
    // start the game
    else if (key.equals("S")) {
      this.gameStart = true;
    }
    else {
      return;
    }
  }

  @Override
  public void onTick() {

  }

  @Override
  public WorldScene makeScene() {
    WorldScene scene = this.drawGrid();
    scene.placeImageXY(player.drawPlayer(), player.getPosn().x, player.getPosn().y);
    return scene;
  }
}