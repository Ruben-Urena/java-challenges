Deck of Cards – Java
Description

This project is about creating a simple representation of a deck of playing cards using Java.
The main goal is to use this setup to practice different methods from java.util.Collections.

Assignment

Implement a Card class that represents a standard playing card.
The cards will be stored in a List<Card> and used to perform common collection operations.

Implementation details

The Card class can be implemented as a record.

Each card must include:

A suit (Suit) represented by an enum (CLUB, DIAMOND, HEART, SPADE)

A face value (face), which can be a number or a face card (J, Q, K, A)

A numeric rank (rank)

Override the toString() method to display:

The card value

The suit symbol

The rank in parentheses
Example: Q♠(10)

Required methods

Static methods to create cards:

getNumericCard(...)

getFaceCard(...)

A method to generate a standard deck:

getStandardDeck()

Methods to print the deck:

printDeck(String description, List<Card> deck, int rows)

printDeck(List<Card> deck) (uses default values)

Notes

No separate Deck class is required; the deck is handled using List<Card>.

ASCII symbols are used to display the card suits.

The design focuses on simplicity and reusability for future exercises.
