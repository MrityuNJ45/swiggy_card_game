package org.example.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class GamePlay {

    private ArrayList<Card> deck;

    private ArrayList<Player> players;

    private ArrayList<Card> drawPile;

    private ArrayList<Card> discardPile;


    public void playGame() throws Exception{

        Scanner sc = new Scanner(System.in);
        int numOfPlayers = sc.nextInt();

        if (numOfPlayers < 2 || numOfPlayers > 4) {
            throw new Exception("Invalid number of players ... Retry again....");
        }

        deck = new Deck().getDeck();

        players = new ArrayList<>();
        for (int i = 1; i <= numOfPlayers; i++) {
            Player p = new Player(i);

            // adding 5 - 5 cards in each player
            for (int j = 1; j <= 5; j++) {
                p.addCard(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
            players.add(p);
            //  System.out.println(p);
        }

        discardPile = new ArrayList<>();
        discardPile.add(deck.get(0));
        deck.remove(0);

        drawPile = new ArrayList<>();
        for (Card c : deck) {
            drawPile.add(c);
        }



    }




}
