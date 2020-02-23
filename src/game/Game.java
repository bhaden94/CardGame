/**
 * Game.java
 * Implements a card game involving one deck of cards and
 * 2 players. Provides methods to play a card game
 *
 * Brady Haden
 */

package game;

import java.util.ArrayList;

// Implements a card game involving one deck of cards and 2 players
public class Game
{
  private ArrayList<Card> warCards = new ArrayList<>();;
  private Deck deck;    // The deck of cards to be played with
  private Hand player1Hand; // Hand of cards held by player 1
  private Hand player2Hand; // Hand of cards held by player 2
  private Discard player1Discard;   // Discard pile of player 1
  private Discard player2Discard;   // Discard pile of player 2
  private int score1 = 0;  // score of player 1
  private int score2 = 0;  // score of player 2
  

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
      printCardsPlayed(player1Card, player2Card);
      
      // this determines who wins a single set. if 0 is returned then it is a draw
      // and war is played
      if (player1Card.compareTo(player2Card) == 0)
      {
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
        System.out.println("It's War!");
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
    System.out.println(results());
  } // end PlayAGame
  
  //*******************************************

  /**
   * This method shuffles the players hand, adds 3 cards
   * from each hand to a list, then each player plays a card. 
   * the winner gets all the cards added to their discard pile.
   */
  private void itsWar()
  {
    Card player1Card;
    Card player2Card;
    int count = 0;

    // shuffle players hand
    player1Hand.shuffle();
    player2Hand.shuffle();
     
    while ((player1Hand.getCurrentSize() > 1 && player2Hand.getCurrentSize() > 1)
           && count <= 2)
    {
      warCards.add(player1Hand.removeCard(player1Hand.getCurrentSize() - 1));
      warCards.add(player2Hand.removeCard(player2Hand.getCurrentSize() - 1));
      count++;
    }
    
    player1Card = player1Hand.playACard();
    player2Card = player2Hand.playACard();
    printCardsPlayed(player1Card, player2Card);
    
    if (player1Card.compareTo(player2Card) == 0)
    {
      System.out.println("It's War again!");
      itsWar();
    }
    else if (player1Card.compareTo(player2Card) > 0)
    {
      // add cards to player1 discard
      player1Discard.addCard(player1Card, player2Card);
      for (Card c : warCards)
        player1Discard.addCard(c);
      warCards.clear();
      score1++;
    }
    else
    {
      // add cards to player2 discard
      player2Discard.addCard(player1Card, player2Card);
      for (Card c : warCards)
        player2Discard.addCard(c);
      warCards.clear();
      score2++;
    }
  } // end itsWar
  
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
  
  //***************************************************************************
  
  /*
   * Calculates winner and returns a printout of who won.
   */
  private String results()
  {
    String resultStr = "";
    if (score1 == score2)
      resultStr = "Tie";
    else if (score1 < score2)
      resultStr = "Player2 won";
    else // 1 > 2
      resultStr = "Player1 won";
    return resultStr;
  }
  
  //***************************************************************************
  
  /*
   * Prints out to screen the played cards
   */
  private void printCardsPlayed(Card p1Card, Card p2Card)
  {
    System.out.print("Player 1: " + p1Card + " vs. ");
    System.out.print("player 2: " + p2Card + " -> ");
  }
} // end class Game
