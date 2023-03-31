package org.example.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class GamePlay {

    private ArrayList<Card> deck;

    private ArrayList<Player> players;

    private ArrayList<Card> drawPile;

    private ArrayList<Card> discardPile;


    public void playGame() throws Exception{
        System.out.println("Enter the number of players : ");
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

        // game starts now

        int playerTurn = 0;

        while (true) {
            if (drawPile.size() == 0) {
                System.out.println("Game drawn !! ... No cards left");
                break;
            }
            playerTurn %= numOfPlayers;
            if (playerTurn < 0) playerTurn += numOfPlayers;
            playerTurn %= numOfPlayers;

            // current player will atleast have 1 card ... it is guranteed

            boolean matched = false;
            Card topDiscardCard = discardPile.get(discardPile.size() - 1);
            for (Card currentPlayerCard : players.get(playerTurn).giveCards()) {
                if (currentPlayerCard.getNumber() == topDiscardCard.getNumber() || currentPlayerCard.getSuit() == topDiscardCard.getSuit()) {
                    System.out.println("Cards matched for player " + players.get(playerTurn).giveId() + " Card = " + currentPlayerCard);
                    System.out.println(discardPile.get(discardPile.size() - 1));
                    players.get(playerTurn).removeCard(currentPlayerCard);
                    discardPile.add(currentPlayerCard);
                    matched = true;
                    break;
                }
            }

            if (matched == false) {
                System.out.println("No cards match for player " + players.get(playerTurn).giveId() + " Taking topmost card " + drawPile.get(drawPile.size() - 1));
                System.out.println(discardPile.get(discardPile.size() - 1));
                players.get(playerTurn).addCard(drawPile.get(drawPile.size() - 1));
                drawPile.remove(drawPile.size() - 1);
            }

            if (matched == true && players.get(playerTurn).giveCards().size() == 0) {
                System.out.println("Congratulations player " + players.get(playerTurn).giveId() + " won the match !!!");
                System.exit(0);
            }

            playerTurn += 1;
        }




    }




}
