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
//    @SuppressWarnings("resource")
//    Scanner stdIn = new Scanner(System.in);
//    int choice;
    
    //display();
//    System.out.print("\nChoose what card you would like to play by using"
//        + " the corresponding index numbers: ");
//    choice = stdIn.nextInt();
    int randomNum = ThreadLocalRandom.current().nextInt(getCurrentSize());
//    return removeCard(choice - 1);
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