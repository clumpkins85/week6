package week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        deck.shuffle();

        for (int i = 0; i < 52; i++) {
            player2.draw(deck);
            player1.draw(deck);
        }

        for (int i = 0; i < 26; i++) {
            Card card1 = player1.flip();
            Card card2 = player2.flip();

            System.out.println("Player 1 flips: " + card1.getName());
            System.out.println("Player 2 flips: " + card2.getName());

            if (card1.getValue() > card2.getValue()) {
                player1.incrementScore();
                System.out.println("Player 1 wins this turn!");
            } else if (card2.getValue() > card1.getValue()) {
                player2.incrementScore();
                System.out.println("Player 2 wins this turn!");
            } else {
                System.out.println("It's a draw!");
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Player 1's");
    }
}

