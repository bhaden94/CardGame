/**
 * Hand.java
 * Implements a hand of cards and provides methods
 * to work with cards such as play a card and sort
 * all cards currently in hand
 *
 * Brady Haden
 */

package game;

/*Implements a hand of cards and provides methods
 * to work with cards such as play a card and sort
 * all cards currently in hand
*/
public class Hand extends GroupOfCards
{
  /**
   * Play a user chosen card in the players hand.
   * Will remove and return that card
   *
   * @return the card being played
   */
  public Card playACard() 
  {
//    boolean isValid = false;
//    int choice = 0;
//    do
//    {
//      isValid = true;
//      @SuppressWarnings("resource")
//      Scanner stdIn = new Scanner(System.in);
//      
//      display();
//      System.out.print("\nChoose what card you would like to play by using"
//          + " the corresponding index numbers: ");
//      try
//      {
//        choice = stdIn.nextInt();
//        return removeCard(choice - 1);
//      }
//      catch (InputMismatchException | IndexOutOfBoundsException e)
//      {
//        isValid = false;
//        System.out.println("Invalid choice, please try again");
//      }
//    } while (!isValid);
//    return removeCard(choice - 1);
    
    // uncomment this and comment all above to automate the game by playing
    // the top most card in the hand
    return removeCard(getCurrentSize() - 1);
    
  } // end playACard

  /**
   * Sort all cards in hand following some strategy
   */
  public void sort() 
  {
    // Can add code here to sort players hand if desired
  } // end sort

} // end class Hand