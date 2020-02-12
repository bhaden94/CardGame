/**
 * GameDriver.java
 * Set up a game playing environment and simulate
 * playing a card game (currently it simulates War)
 *
 * Brady Haden
 */
package game;

import java.util.Scanner;

// Set up a game playing environment and simulate playing a card game
public class GameDriver
{
  public static void main(String[] args)
  {
    Scanner stdIn = new Scanner(System.in);
    String again;
    Game game;

    do // loop for game playing
    {
      // one game
      game = new Game();
      game.playAGame();

      // again?
      System.out.print("Play another game (y/n)?: ");
      again = stdIn.next();
    } while (again.equalsIgnoreCase("y"));
    stdIn.close();

    // good-bye msg
    System.out.println("Thanks for playing. Bye-bye.");

  }// end main

}// end GameDriver