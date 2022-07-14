package blackjack;

/**
 * Ethan Manco
 * Praeses Technical Sample
 * 7/13/2022
 */

public class Dealer extends Person {
    
    // Class constructor for Dealer
    public Dealer() {
        super.setName("Dealer");
    }
    
    // Method to show cards with one face down
    public void showHand() {
        System.out.println("Dealers hand: ");
        System.out.print(super.getHand().getCard(0));
        System.out.println(" ~ " + "???????????????????????" + " ~ " + "Total: " + super.getHand().getCard(0).getNum() + " + ?");
    }
}
