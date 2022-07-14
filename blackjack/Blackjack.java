package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ethan Manco
 * Praeses Technical Sample
 * 7/13/2022
 */

public class Blackjack {
    
    public static void main(String[] args) {
        System.out.println("~~~Console Blackjack~~~");
        startBlackjack();
    }
    
    private static void startBlackjack() {
        // Define scanner for keyboard input
        Scanner input = new Scanner(System.in);

        // Create a deck
        Deck deck = new Deck(true);

        // Create a dealer
        Dealer dealer = new Dealer();
        
        int playerCount = 0;
        
        boolean awaitInput = true;
        
        // Get number of players
        while (awaitInput) {
            try {
                System.out.println("Enter the number of players (up to 7): ");
                playerCount = input.nextInt();
                
                if (playerCount > 7)
                    System.out.println("Too many players.");
                else {
                    System.out.println(System.lineSeparator());
                    awaitInput = false;
                }
            }
            catch (Exception e) {
                System.out.println("Please enter a valid number.");
                input.next();
            }
        }
        
        // Create list of players
        ArrayList<Player> playerList = new ArrayList<>();
        
        // Name players
        for (int i=1; i<playerCount+1; i++) {
            Player p = new Player("Player_" + i);
            playerList.add(p);
        }
        
        // Display player names
        /*(for(int i=0; i<playerCount; i++) {
            playerList.get(i).getName();
        }*/

        // Print deck
        //System.out.println(deck.toString());

        // Shuffle deck
        deck.shuffle();
        
        // Print shuffled deck
        //System.out.println(deck.toString());
        
        // The Deal for the players
        for (int i=0; i<playerCount; i++) {
            playerList.get(i).getHand().takeCardFromDeck(deck);
            playerList.get(i).getHand().takeCardFromDeck(deck);
        }
        
        // The Deal for the dealer
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        
        
        // BETTING HERE
        
        
        // Check for Naturals
        if(dealer.hasBlackjack()) {
            // Reveal both dealer cards
            dealer.printHand();

            // Check for push
            for(int i=0; i<playerCount; i++) {
                if (playerList.get(i).hasBlackjack()) {
                    System.out.println("Push for " + playerList.get(i).getName());
                } else {
                    System.out.println(playerList.get(i).getName() + " loses to dealer blackjack.");
                }
            }
        }
        else {
            // If the dealer doesn't have a natural, check the players
            for (int i = 0; i < playerCount; i++) {
                if (playerList.get(i).hasBlackjack()) {
                    System.out.println(playerList.get(i).getName() + " has Blackjack!");
                }
            }
            
            // The Play begins here for players
            for (int i = 0; i < playerCount; i++) {
                // Players with blackjack have already finished the round
                if (!playerList.get(i).hasBlackjack()) {
                    // Display dealers hand with face down card
                    dealer.showHand();
                    // Display players hand
                    playerList.get(i).printHand();
                    
                    System.out.println(playerList.get(i).getName() + ":");
                    // Pass the deck to allow player to decide their choice (hit or stand)
                    playerList.get(i).decide(deck);
                    
                    // Check for blackjack again
                    if (playerList.get(i).hasBlackjack()) {
                        System.out.println(playerList.get(i).getName() + " has Blackjack!");
                        System.out.println(System.lineSeparator());
                    }
                }
                // Check if player busted
                if (playerList.get(i).getHand().calculate() > 21) {
                    System.out.println(playerList.get(i).getName() + " busts.");
                    System.out.println(System.lineSeparator());
                }
            }

            // The Play begins here for the dealer
            dealer.printHand();     // Reveal both dealer cards
            // Dealer must hit until at least a total of 17 is made
            while (dealer.getHand().calculate() < 17) {
                dealer.hit(deck);
            }

            // Check if dealer busts, then the players who haven't busted win
            if (dealer.getHand().calculate() > 21) {
                System.out.println("Dealer busts.");
                for (int i = 0; i < playerCount; i++) {
                    if (playerList.get(i).getHand().calculate() > 21){
                        System.out.println(playerList.get(i).getName() + " loses.");
                    }
                    else {
                        System.out.println(playerList.get(i).getName() + " wins.");
                    }
                }
            // If the dealer or player haven't busted, compare hands
            } else {
                for (int i = 0; i < playerCount; i++) {
                    if (playerList.get(i).getHand().calculate() > 21){
                        System.out.println(playerList.get(i).getName() + " loses.");
                    } else if (dealer.getHand().calculate() > playerList.get(i).getHand().calculate()) {
                        System.out.println(playerList.get(i).getName() + " loses.");
                    } else if (playerList.get(i).getHand().calculate() > dealer.getHand().calculate()) {
                        System.out.println(playerList.get(i).getName() + " wins.");
                    } else {
                        System.out.println("Push for " + playerList.get(i).getName() + ".");
                    }
                }
            }
        }

        // Prompt user to continue
        System.out.println("Would you like to play another round? (Y/N) ");
        String cont = input.next();
        if (cont.toLowerCase().equals("y")) {
            System.out.println(System.lineSeparator());
            startBlackjack();
        }
        else {
            System.out.println("~~~Goodbye!~~~");
        }
    }
}
