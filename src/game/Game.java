/**
 * Game.java
 * Implements a card game involving one deck of cards and
 * 2 players. Provides methods to play a card game
 *
 * Brady Haden
 */

package game;

// Implements a card game involving one deck of cards and 2 players
public class Game
{
  private Deck deck;    // The deck of cards to be played with
  private Hand player1Hand; // Hand of cards held by player 1
  private Hand player2Hand; // Hand of cards held by player 2
  private Discard player1Discard;   // Discard pile of player 1
  private Discard player2Discard;   // Discard pile of player 2

  //*******************************************

  /**
   * Create a new game with a default deck of
   * cards and two default hands
   */
  public Game() 
  {
    deck = new Deck();
    player1Hand = new Hand();
    player2Hand = new Hand();
    player1Discard = new Discard();
    player2Discard = new Discard();
  }

  //*******************************************

  public void playAGame() 
  {
    // 0. prepare the deck of cards
    deck.shuffle();

    // 1. deal all the cards to the two players
    while (deck.getCurrentSize() > 0)
    {
      player1Hand.addCard(deck.dealCard());
      player2Hand.addCard(deck.dealCard());
    }

    // 2. play
    int score1 = 0;  // score of player 1
    int score2 = 0;  // score of player 2
    
    while (player1Hand.getCurrentSize() >= 0 || player2Hand.getCurrentSize() >= 0)
    {
      // break the loop if both hand and discard are empty
      // the player that breaks it ends up being the loser
      if (player1Hand.getCurrentSize() == 0 &&
          discardToHand(player1Hand, player1Discard) == -1)
      {
          break;
      }
      if (player2Hand.getCurrentSize() == 0 &&
          discardToHand(player2Hand, player2Discard) == -1)
      {
          break;
      } 
      
      // player 1 plays a card, display the card
      // create a local Card object to store the played cards
      Card player1Card = player1Hand.playACard();
      Card player2Card = player2Hand.playACard();
      System.out.print("Player 1: " + player1Card + " vs. ");

      // player 2 plays a card, display the card
      System.out.print("player 2: " + player2Card + " -> ");
      // this determines who wins a single set. if 0 is returned then it is a draw
      // and war is played
      if (player1Card.compareTo(player2Card) == 0)
      {
        itsWar();
      }
      else if (player1Card.compareTo(player2Card) > 0)
      {
        score1++;
        // add cards to player1 discard
        player1Discard.addCard(player1Card, player2Card);
      }
      else
      {
        score2++;
        // add cards to player2 discard
        player2Discard.addCard(player1Card, player2Card);
      }
      // print result of this round: print two cards played and current scores
      System.out.println("scores: " + score1 + " vs. " + score2);
    } // end while
    

    // 3. result of the game
    String resultStr = "";
    if (score1 == score2)
      resultStr = "Tie";
    else if (score1 < score2)
      resultStr = "Player2 won";
    else // 1 > 2
      resultStr = "Player1 won";
    System.out.println(resultStr);
  } // end PlayAGame
  
  /**
   * This method 
   */
  private void itsWar()
  {
    System.out.println("It's War!");
  }
  
  //***************************************************************************
  
  /**
   * This method takes all the cards currently in the players
   * discard pile and adds them to their hand. If the players 
   * discard is empty then it will return -1 to signify that
   * the game should now end since one player is out of cards.
   * It returns 1 if the operation was successful.
   */
  private int discardToHand(Hand playerHand, Discard playerDiscard)
  {
    if (playerDiscard.getCurrentSize() == 0)
    {
      return -1;
    }
    else
    {
      while (playerDiscard.getCurrentSize() > 0)
      {
        playerHand.addCard(playerDiscard.removeCard(playerDiscard.getCurrentSize() - 1));
      }
      return 1;
    }
  } // end discardToHand
  
} // end class Game
