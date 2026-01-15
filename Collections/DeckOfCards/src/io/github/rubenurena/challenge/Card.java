package io.github.rubenurena.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {
    private Suit suit;
    private String face;
    private int rank;

    public Card(String face, Suit suit) {
        this.suit = suit;
        //This code is util because it only allows the numbers and letters that exist in cards.
        //Also assigns its rank to each face.
        if ((int)face.toCharArray()[0] >= 49 && (int)face.toCharArray()[0] <= 57){//12
            this.face = face;
            this.rank = Integer.parseInt(face)-2;
            if (Integer.parseInt(face) > 10 || Integer.parseInt(face) < 2){
                this.face = "2";
                this.rank = 0;
            }
        } else {
            switch ((int)face.toCharArray()[0]){
                case 65,97 -> {
                    this.face = face;
                    this.rank = 12;
                }
                case 74,106 -> {
                    this.face = face;
                    this.rank = 9;
                }
                case 75,107 ->{
                    this.face = face;
                    this.rank = 11;
                }
                case 81,113 -> {
                    this.face = face;
                    this.rank = 10;
                }
                default -> {
                    this.face = "2";
                    this.rank = 0;
                }
            }
        }

    }
    public Card(){

    }

    @Override
    public String toString() {
        return this.face+(char)this.suit.getASCII()+"("+this.rank+")"+" ";
    }

    public static Card getNumericCard(String face, Suit suit){
        if ((int)face.toCharArray()[0] >= 49 && (int)face.toCharArray()[0] <= 57){
            return new Card(face, suit);
        }else {
            return null;
        }
    }
    public static Card getFaceCard(String face, Suit suit){
        switch ((int)face.toCharArray()[0]){
            case 65,97,74,106,75,107,81,113 -> {
                return new Card(face, suit );
            }
            default -> {
                return null;
            }
        }
    }

    public static List<Card> getStandardDeck(){
        List<Card> cards = new ArrayList<>();
        for (var b : Suit.values()){
            for (int a = 2; a <= 10; a++){
                cards.add(new Card(String.valueOf(a),b));

            }
            Card[] faceCards = {new Card("J",b),new Card("Q",b),new Card("K",b),new Card("A",b)};
            cards.addAll(Arrays.asList(faceCards));
        }
        return cards;
    }

    public static void printDeck(List<Card> cards, int row, String description){
        if (row < 1){
            return;
        }
        if(description != null){
            System.out.println("------------------------"+description+"------------------------");
        }
        var cardsSize = cards.size();
        int counter = 0;
        for (var a : cards){
            System.out.print(a);
            counter++;
            if(counter == cards.size()/row){
                System.out.println(" ");
                counter = 0;
            }
        }

    }
    public static void printDeck(List<Card> cards){
        printDeck(cards,4,"Standard deck");
    }



}
