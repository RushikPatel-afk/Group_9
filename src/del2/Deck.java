package del2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author vbvir
 */
/**
 * Represents a deck of cards.
 * Follows SRP: Handles deck operations like building, shuffling, and dealing cards.
 */
public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        buildDeck();
        shuffleDeck();
    }

    private void buildDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(CardFactory.createCard(suit, rank));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("The deck is empty!");
        }
        return cards.remove(cards.size() - 1);
    }
}
