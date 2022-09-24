Section 1:

In Centipede.java: 

added 4 new variables

double speed is for manipulating the speed of the centipede.
boolean isMovingUp is for checking to see if the centipede is currently moving up as the centipede
now starts moving up after hitting the bottom corner.
int moveSpeed is just a constant to set how far a centipede moves at a time.
Direction vertical is to see if the centipede is currently on a downward track or upwards.

moveUp method added to move the centipede upwards.

In Player.java:

added 2 new variables
int score keeps track of the player's current score.
int hitStreak keeps track of how many times a player has fired a dart that has hit something up to a max of 3.

added WaterBalloon.java
Posn posn keeps track of the water balloon's current posn.

In Game.java:

added 3 new variables

double timer keeps track of how many times the clock has ticked
int level keeps track of how many times the player has cleared all the centipedes.
WaterBalloon wb keeps track of the possible water balloon that has been fired.

void setSpillOver method sets the bordering tiles of those that have a pebble pile to have a spill over tile.

void hitCorner checks to see if the given centipede has hit a corner and then sets its vertical direction to the opposite one.

void centipedeMovingUp changes the centipede's vertical direction if it has hit a new tile.

void waterBalloonEdgeOfBoard sets the water balloon to null if it has reached the edge of the board.

void centipedeHitPebblePile slows the centipede's speed down if it has hit a pebble pile.

void finishLevel adds a new centipede with one longer segment than before if the player has completed the previous level.

void waterBalloonHitCentipede checks to see if the water balloon has hit a centipede and explodes it to hit everything in the surrounding 8 tiles.

void waterBalloonHitDandelion checks to see if the water balloon has hit a dandelion and explodes it to hit everything in the surrdoungin 8 tiles.

void removeParts takes in a list of heads and a list of segments to remove and removes them.

void waterDandelion waters the dandelion at the given indices.

Section 2:

I chose to use impworld because I have a lot of variables in my game so instead of creating a new game with many of the same variables,
each method would just modify the variables I want it to and return void.

Section 3:

I used arraylists to represent both the body of the centipedes and all the centipedes in the game. Because many actions taken by the user
affected the segments and centipedes respectively in the lists, an arraylist helped me iterate through the lists. Additionally, the board of tiles was
created using an arraylist of an arraylist so that the height and width of the board could be manipulated separately.

Section 4: 

My approach to testing was all about testing the edge cases. With many methods like move and dart hit centipede, there are edge cases like what if
the centipede is in the corner or the dart hits the first body segment or the head or the last body segment. My testing was centered around those.

Section 5:
If I had known that the centipede was supposed to move back up, I wouldn't have centered my move methods around moving down.
Because of that, I added more variables than was probably necessary to finish the move methods.
