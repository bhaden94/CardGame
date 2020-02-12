/**
 * Card.java
 * Describes a card with a suit value and a num value
 * 
 * Brady Haden
 */

package game;

// Describes a card with a suit value and a num value
public class Card
{
  //Used for display suit value such as Club instead of 0
  private static final String[] SUIT_STR = {"Club", "Diamond", "Heart", "Spade"};
  private int num;  // number value of a card: 2-14, use 11-14 for J, Q, K, A
  private int suit; // suit value of a card: 0-3 for "Club"<"Diamond"<"Heart"<"Spade"

  //*******************************************

  public Card() 
  {
    // default constructor, intentionally empty
  }

  /**
   * Create a Card object with specified num and suit
   *
   * @param num  num value. 2-14, use 11-14 for J, Q, K, A
   * @param suit  suit value. 0-3 for "Club"<"Diamond"<"Heart"<"Spade"
   */
  public Card(int num, int suit) 
  {
    this.num = num;
    this.suit = suit;
  }

  //*******************************************

  public int getNum() 
  {
    return num;
  }

  public int getSuit() 
  {
    return suit;
  }

  //*******************************************

  /**
   * Displays a card in format of suit and num
   * for example: Club 10
   */
  public void display() 
  {
    System.out.print(toString());
  }

  //*******************************************

  /**
   * Compare two cards. The comparison is based on first num
   * and then suit. The result is a negative integer if this
   * Card object is smaller than the argument Card. The result
   * is a positive integer if this Card object is larger. The
   * result is zero if they are equal i.e. when equals() would
   * return true.
   *
   * @param anotherCard
   * @return  a negative value means
   */
  public int compareTo(Card anotherCard) 
  {
    if (suit == anotherCard.suit)
      return num - anotherCard.num;

    return suit - anotherCard.suit;
  }

  //*******************************************
  /**
   * Returns a string representation of
   * a card object in format of "Club 10".
   */
  public String toString() 
  {
    return (SUIT_STR[suit]+" "+num);
  }

  //*******************************************
  /**
   * Compare this object with the specified obj. The
   * result is true if and only if the argument is a Card
   * and has the same num and suit values.
   */
  public boolean equals(Object anotherObj) 
  {
    if (this == anotherObj)
      return true;

    if (anotherObj instanceof Card) 
    {
      Card tmp = (Card) anotherObj;
      return num == tmp.num && suit == tmp.suit;
    }
    return false;
  }
} // end class Card
