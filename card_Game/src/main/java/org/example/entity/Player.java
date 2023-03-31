package org.example.entity;

import java.util.ArrayList;

public class Player {


    private int id;
    // cards which players will be having in their hand.
    private ArrayList<Card> cards = new ArrayList<>();

    // Player constructor with passing as his id in parameter.
    public Player(int id)
    {
        this.id = id;
    }
    /*
       this is for adding card to the player's
       hand after if the card is not matched with the top of
       discard pile or after any action card (Q,J) played by the
       previous player.
     */

    public void addCard(Card card) {

        cards.add(card);
    }

    /*
       This is to remove the card from the player's hand
       when any of the player's card matches with the
       top of the discard pile.
     */

    public void removeCard(Card card) {
        cards.remove(card);
        return;
    }
    // to get the id of the player
    public int giveId() {
        return id;
    }
    // to get the player's hands cards.
    public ArrayList<Card> giveCards() {
        return cards;
    }
    public String toString() {
        return id + " " + cards.toString();
    }


}
