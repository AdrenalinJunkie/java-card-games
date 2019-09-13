package com.cards.game;

import java.util.ArrayList;
import java.util.List;

//start off with ones that are clearly similar, like black maria, whist, rummy, etc
public class Game {
//    I guess generates all the other things, but kinda need user input somewhere for player number
    public static void main(String[] args) {

    }
}

class Player {
    Hand hand;

    public Player(List<Card> cardList) {
        this.hand = new Hand(cardList);
    }

    //    this should probably be a string
    public void play(Card card) {
        this.hand.play(card)
    }

}

// I guess this is the main class that changes from game to game. So it would be nice to have different implementations
//of isLegal and play
class Board {
    public boolean isLegal(Card card, Hand hand){
        return true;
    }
    public void play(Card card){

    }
}

class CardList {
    // Hopefully something that deck, hand and columns can utilise
    List<Card> cardList = new ArrayList<Card>();

//    constructor doesn't need void, etc as output because we already know the output
    public CardList(List<Card> cardList){
        this.cardList = cardList;
    }
//    run a for loop across deck - at every card, pick a random other card and switch them
    public void shuffle(){

    }
    public void valueSort(){

    }
    public void suitSort(){

    }
    public List<Card> deal(int length){
        List<Card> newList = new ArrayList<Card>();
        for(int i=0; i<length; i++){
            Card newCard = cardList.get(i);
            cardList.remove(i);
            newList.add(newCard);
        }
        return newList;
    }
//
    public boolean play(Card card){
//        if card in cardList, discard it, and return true. Else, return false
        if(cardList.contains(card)){
            cardList.remove(card);
            return true;
        }
        else{
            return false;
        }
    }
}

class Hand {
    CardList hand;
    public Hand(List<Card> cardList){
        this.hand = new CardList(cardList);
    }
    public void play(Card card){
        this.hand.play(card);
    }
}

class Deck {
    CardList deck;
    public Deck(){
        List<Card> cardList = new ArrayList<Card>();
        for(int suit = 0; suit<4;suit++){
            for(int value = 1;value<14;value++){
                Card newCard = new Card(suit, value);
                cardList.add(newCard);
            }
        }
        this.deck = new CardList(cardList);
        this.deck.shuffle();
    }

}

class Card {
    int suit;
    int value;
//    method gets given a 3 digit string, first digit is suit, last two digits are value
//    don't need to bother test for valid cards as all actual cards created by deck
    public Card(String string){
        int number = Integer.parseInt(string);
        this.value = number % 100;
        this.suit = (number - this.value)/100;
    }
    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
    }
}