package week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
    private int value;
    private String name;

    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void describe() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Player 1");

        deck.shuffle();
        player.draw(deck);
        player.describe();
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] names = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                String name = names[i - 2] + " of " + suit;
                cards.add(new Card(i, name));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card draw() {
        if (cards.isEmpty())
            return null;
        return cards.remove(0);
    }
}

class Player {
    private List<Card> hand;
    private int score;
    private String name;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        score = 0;
    }

    public void describe() {
        System.out.println("Player: " + name);
        System.out.println("Hand:");
        for (Card card : hand) {
            card.describe();
        }
        System.out.println("Score: " + score);
    }

    public Card flip() {
        if (hand.isEmpty())
            return null;
        return hand.remove(0);
    }

    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card != null)
            hand.add(card);
    }

    public void incrementScore() {
        score++;
    }
}