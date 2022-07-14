package blackjack;

import blackjack.Card.Suit;
import blackjack.Card.Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Ethan Manco
 * Praeses Technical Sample
 * 7/13/2022
 */

public class Deck {
    
    private ArrayList<Card> deck;

    // Class constructor for deck
    public Deck() {
        // Creates empty deck
        deck = new ArrayList<>();
    }

    
    public Deck(boolean makeDeck) {
        deck = new ArrayList<>();
        
        // Build deck
        if (makeDeck) {
            for (Suit suit : Suit.values()) {
                for (Value value : Value.values()) {
                    deck.add(new Card(suit, value));
                }
            }
        }
    }

    // Output entire deck as a string
    @Override
    public String toString() {
        String output = "";

        for (Card card: deck) {
            output += card;
            output += "\n";
        }
        return output;
    }

    // Method to shuffle deck
    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    // Method to take card from deck
    public Card takeCard() {
            // Copy card from deck
            Card cardTaken = new Card(deck.get(0));
            
            deck.remove(0);
            
            return cardTaken;
    }
}
