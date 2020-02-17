/**
 * GroupOfCards.java
 * Implements a group of cards and provides methods
 * to add a card and remove a card
 *
 * Brady Haden
 */

package game;

import java.util.ArrayList;

// Implements a group of cards
public class GroupOfCards
{
  private ArrayList<Card> cards; // list of cards in the group

  //*******************************************

  /**
   * Create an object which is capable of
   * holding multiple cards. Doesn't actually
   * create and add card objects. That's up
   * to individual child class
   */
  public GroupOfCards() 
  {
    cards = new ArrayList<Card>();
  }

  //*******************************************

  public int getCurrentSize() 
  {
    return cards.size();
  }

  //*******************************************

  public void display() 
  {
    System.out.println("This is your hand:");
    System.out.println();
    for (int i=0; i<cards.size(); i++)
    {
      System.out.println((i+1) + ": " + cards.get(i));
    }
  }  

  //*******************************************

  /**
   * Add a card to high end of list: append
   *
   * @param card
   */
  public void addCard(Card card) 
  {
    cards.add(card);
  }
  
  // add winning cards to discard pile
  public void addCard(Card card1, Card card2) 
  {
    cards.add(card1);
    cards.add(card2);
  }

  //*******************************************
  /**
   * Remove and return a card object at a specified location
   *
   * @param index  the index of the element to be removed
   * @return  the card object just removed.
   */
  public Card removeCard(int index) 
  {
    return cards.remove(index);
  }

} // end class GroupOfCards