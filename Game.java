package com.cards.game;

import java.util.ArrayList;
import java.util.List;

//start off with ones that are clearly similar, like black maria, whist, rummy, etc
public class Game {
    public static void main(String[] args) {

    }
}

class Player {
    List<Card> hand = new ArrayList<Card>();
}

class Board {

}

class CardList {
    // Hopefully something that deck, hand and columns can utilise

    List<Card> cardList = new ArrayList<Card>();

//    constructor doesn't need void, etc as output because we already know the output
    public CardList(List<Card> cardList){
        this.cardList = cardList;
    }
    public void shuffle(){

    }
    public void valueSort(){

    }
    public void suitSort(){

    }
//
    public Card play(String card){

    }
}

class Deck {

}

class Card {
    int suit;
    int value;
//    method gets given a 3 digit string, first digit is suit, last two digits are value
//    not going to bother chucking out cards here, hopefully build a cardTester somewhere else, or just have a null card
    public Card(String string){
        int number = Integer.parseInt(string);
        this.value = number % 100;
        this.suit = (number - this.value)/100;
    }
    public Card(int value, int suit){
        this.suit = suit;
        this.value = value;
    }
}