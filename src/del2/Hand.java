package del2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import del2.Card;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vbvir
 */
public class Hand {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    
    
    //Calculates the total value of the hand, considering Aces as 1 or 11.  
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += getCardValue(card);
            if ("Ace".equals(card.getRank())) {
                aceCount++;
            }
        }

        // Adjust Ace values if the total exceeds 21
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    private int getCardValue(Card card) {
        switch (card.getRank()) {
            case "Jack":
            case "Queen":
            case "King":
                return 10;
            case "Ace":
                return 11;
            default:
                return Integer.parseInt(card.getRank());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card).append("\n");
        }
        return sb.toString();
    }
}
