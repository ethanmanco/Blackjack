package blackjack;

/**
 * Ethan Manco
 * Praeses Technical Sample
 * 7/13/2022
 */

public abstract class Person {
    
    private Hand hand;
    private String name;

    // Class constructor for Person
    public Person() {
        this.hand = new Hand();
        this.name = "";
    }

    // Getters and setters for abstract class
    public Hand getHand() {
        return this.hand;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setHand(Hand hand) {
        this.hand = hand;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // Method that prints the person's hand
    public void printHand() {
        System.out.println(this.name + "'s hand:");
        System.out.println(this.hand + " Total: " + this.hand.calculate());
    }

    // Method that takes a card from the deck and puts it in the person's hand
    public void hit(Deck deck) {
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();
    }

    // Method that checks person's hand total is 21
    public boolean hasBlackjack() {
        return this.getHand().calculate() == 21;
    }
}
