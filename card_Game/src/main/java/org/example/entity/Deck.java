package org.example.entity;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    /*
       Deck creation and shuffling will
       be done simultaneously as we create the Deck
       Object.
     */


    public Deck() {
        // creating the deck.
        deck = new ArrayList<>();
        for(Suits suits : Suits.values()){

            for(int i = 1; i <= 13; i++){
                deck.add(new Card(i,suits));
            }

        }
        // shuffling the deck as well
        Collections.shuffle(deck);

    }

    /*
       For getting the ArrayList of Deck.
     */

    public ArrayList<Card> getDeck() {
        return deck;
    }



}
