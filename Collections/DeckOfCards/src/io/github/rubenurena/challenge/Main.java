package io.github.rubenurena.challenge;

public class Main {
    public static void main(String[] args) {
        Card card = new Card();
        var s = Card.getStandardDeck();
        Card.printDeck(s);
    }
}