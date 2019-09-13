package com.cards.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//start off with ones that are clearly similar, like black maria, whist, rummy, etc
public class Game {
//    I guess generates all the other things, but kinda need user input somewhere for player number
    public static void main(String[] args) {

        Board board = new Board();

    }
}

class Player {
    Hand hand;
    int score;
//    may change type of this at some point - makes sense as I guess it needs score
    Hand discardList;
    public Player(List<Card> cardList) {
//        not necessarily sure this code should be in here. I kinda want an empty hand to start
        this.hand = new Hand();
    }
    public void newHand(List<Card> hand){
        this.hand = new Hand(hand);
    }
    //    this should probably be a string
    public void play(Board board) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        Card card = new Card(s);
        this.hand.play(card, board);
    }

}

// I guess this is the main class that changes from game to game. So it would be nice to have different implementations
//of isLegal and play
class Board {
    public boolean isLegal(Card card, List<Card> hand){
        return true;
    }
    public void play(Card card){

    }
}

class Discards {
    List<Card> discards = new ArrayList<Card>();
    public Discards(){
        this.discards = new ArrayList<Card>();
    }
    public void add(Card card){
        this.discards.add(card);
    }
}


class Hand {
    List<Card> hand = new ArrayList<Card>();
    public Hand(List<Card> cardList){
        this.hand = cardList;
    }
    public Hand(){
        this.hand = new ArrayList<Card>();
    }
    public boolean play(Card card, Board board){
        if(!board.isLegal(card, this.hand)){
            return false;
        }
        if(this.hand.contains(card)){
            this.hand.remove(card);
            return true;
        }
        else{
            return false;
        }
    }
//    not really necessary at start - leave to do later
    public void valueSort(){
    }
    public void suitSort(){
    }
}

class Deck {
    List<Card> deck = new ArrayList<Card>();
    public Deck(){
        for(int suit = 0; suit<4;suit++){
            for(int value = 1;value<14;value++){
                deck.add(new Card(suit, value));
            }
        }
        this.shuffle();
    }
    public List<Card> deal(int length){
        List<Card> newList = new ArrayList<Card>();
        for(int i=0; i<length; i++){
            Card newCard = deck.get(i);
            deck.remove(i);
            newList.add(newCard);
    }
    return newList;
}
    //    run a for loop across deck - at every card, pick a random other card and switch them
    public void shuffle(){

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
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return Integer.compare(this.suit, card.suit) == 0
                && Integer.compare(this.value, card.value) == 0;
    }
}