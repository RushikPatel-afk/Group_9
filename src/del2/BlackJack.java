/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package del2;
import java.util.Scanner;

/**
 *
 * @author vbvir
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    
     private final Deck deck;
    private final Hand playerHand;
    private final Hand dealerHand;

    public BlackJack() {
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
    }

    private void dealInitialCards() {
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
    }

    private boolean isBusted(Hand hand) {
        return hand.getValue() > 21;
    }

    private void printHand(Hand hand, String owner) {
        System.out.println(owner + "'s Hand:");
        System.out.println(hand);
        System.out.println(owner + "'s Total Value: " + hand.getValue());
    }

    public void play() {
        dealInitialCards();
        Scanner scanner = new Scanner(System.in);

        // Player's turn
        while (true) {
            printHand(playerHand, "Player");

            if (isBusted(playerHand)) {
                System.out.println("Player busts! Dealer wins.");
                return;
            }

            System.out.println("Do you want to hit or stand? (hit/stand)");
            String decision = scanner.nextLine();

            if ("hit".equalsIgnoreCase(decision)) {
                playerHand.addCard(deck.dealCard());
            } 
            else if ("stand".equalsIgnoreCase(decision)) {
                break;
            } else {
                System.out.println("Invalid input. Please type 'hit' or 'stand'.");
            }
        }

        // Dealer's turn
        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.dealCard());
        }

        // Results
        printHand(playerHand, "Player");
        printHand(dealerHand, "Dealer");

        if (isBusted(dealerHand)) {
            System.out.println("Dealer busts! Player wins.");
        } 
        else if (playerHand.getValue() > dealerHand.getValue()) {
            System.out.println("Player wins!");
        }
        else if (playerHand.getValue() < dealerHand.getValue()) {
            System.out.println("Dealer wins!");
        }
        else {
            System.out.println("It's a push!");
        }
    }

    public static void main(String[] args) {
        new BlackJack().play();
    }
}