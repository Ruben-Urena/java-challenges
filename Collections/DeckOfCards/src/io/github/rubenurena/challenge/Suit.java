package io.github.rubenurena.challenge;

public enum Suit{
    CLUBS(9827),
    DIAMONDS(9830),
    HEARTS(9829),
    SPADES(9824);
    private final int ASCII;

    Suit(int ASCII){
        this.ASCII = ASCII;
    }
    public int getASCII() {
        return ASCII;
    }
}