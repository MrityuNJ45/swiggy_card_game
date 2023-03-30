package org.example.entity;

import org.example.enums.Suits;

public class Card {

    int number;

    Suits suit;

    public Card() {
    }

    public Card(int number, Suits suit) {
        this.number = number;
        this.suit = suit;
    }
}
