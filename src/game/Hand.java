/**
 * Hand.java
 * Implements a hand of cards and provides methods
 * to work with cards such as play a card and sort
 * all cards currently in hand
 *
 * Brady Haden
 */

package game;

import java.util.concurrent.ThreadLocalRandom;

/*Implements a hand of cards and provides methods
 * to work with cards such as play a card and sort
 * all cards currently in hand
*/
public class Hand extends GroupOfCards
{
  /**
   * Play a random card in the players hand.
   * Will remove and return that card
   *
   * @return the card being played
   */
  public Card playACard() 
  {
    // random number between 0 and the current size of the players hand
    int randomNum = ThreadLocalRandom.current().nextInt(0, this.getCurrentSize());
    return removeCard(randomNum);
  }

  /**
   * Sort all cards in hand following some strategy
   */
  public void sort() 
  {
    // Can add code here to sort players hand if desired
  }

} // end class Hand