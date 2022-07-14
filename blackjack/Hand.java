package blackjack;

import java.util.ArrayList;

/**
 * Ethan Manco
 * Praeses Technical Sample
 * 7/13/2022
 */

public class Hand {
    
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    // Method to add card to hand
    public void takeCardFromDeck(Deck deck) {
        hand.add(deck.takeCard());
    }

    // Method that prints every card in hand
    @Override
    public String toString() {
        String output = "";
        for (Card card: hand) {
            output += card + " ~ ";
        }
        return output;
    }

    // Method that calculates the total number and handles ace values
    public int calculate() {
        int num = 0;
        int aceCount = 0;

        // Iterate through the cards in hand and total the numbers
        for (Card card: hand) {
            num += card.getNum();
            // Count the number of aces in hand
            if (card.getNum() == 11) {
                aceCount ++;
            }
        }
        
        // Count aces as ones until the total num is less than 21
        if (num > 21 && aceCount > 0) {
            while(aceCount > 0 && num > 21) {
                aceCount --;
                // Aces are counted as 11 by default, so subtracting 10 makes it 1
                num -= 10;
            }
        }
        return num;
    }

    // Method for retrieving one card at a time
    public Card getCard(int i) {
        return hand.get(i);
    }
}
