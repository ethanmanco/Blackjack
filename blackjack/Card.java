package blackjack;

/**
 * Ethan Manco
 * Praeses Technical Sample
 * 7/13/2022
 */

public class Card {
    
    public enum Suit {
        HEART, DIAMOND, CLUB, SPADE;
    }
    
    public enum Value {
        ACE(11),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10);
        
        int valueNum;

        // Enum value constructor that gives each value a number
        Value(int valueNum) {
            this.valueNum = valueNum;
        }
    }
    
    private Suit suit;
    private Value value;

    // Card constructor for creation
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    // Card constructor for copying
    public Card(Card card) {
        this.suit = card.getSuit();
        this.value = card.getValue();
    }
    
    // Get numerical card value
    public int getNum() {
        return value.valueNum;
    }

    // Get suit (HEART, DIAMOND, etc.)
    public Suit getSuit() {
        return this.suit;
    }
    
    // Get value (ACE, TWO, etc.)
    public Value getValue() {
        return this.value;
    }

    // Returns card pip values
    @Override
    public String toString() {
        return ("|" + value + " of " + suit + "| = |" + this.getNum() + "|");
    }
}
