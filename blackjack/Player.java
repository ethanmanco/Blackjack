package blackjack;

import java.util.Scanner;

/**
 * Ethan Manco
 * Praeses Technical Sample
 * 7/13/2022
 */

public class Player extends Person {
    
    Scanner input = new Scanner(System.in);
    String name;
    //int balance = 100;
    //int bet = 0;
    
    // Class constructor for Player
    public Player(String n) {
        this.name = n;
        super.setName(n);
    }
    
    /*public int getBalance() {
        return balance;
    }
    
    public void bet(int b) {
        balance = balance - b;
        bet = b;
    }*/
    
    // Decision method for "The Play"
    public void decide(Deck deck) {

        int decision = 0;
        boolean getNum = true;

        while (getNum) {
            try {
                System.out.println("1) Hit or 2) Stand");
                decision = input.nextInt();
                getNum = false;

            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                input.next();
            }
        }

        // Hit
        if (decision == 1) {
            this.hit(deck);
            // Decide again if total is below 21
            if (this.getHand().calculate() < 21) {
                this.decide(deck);
            }
        } else {    // Stand
            System.out.println("You stand.");
            System.out.println(System.lineSeparator());
        }

    }
}
