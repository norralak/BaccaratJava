/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baccarat;

/**
 * This class is a suit which constructs thirteen cards put into an array.
 * @author SM Murad, Tenzin Kalden
 */
public class Suit {
    
    private final Card ace;
    private final Card two;
    private final Card three;
    private final Card four; 
    private final Card five;
    private final Card six;
    private final Card seven;
    private final Card eight;
    private final Card nine;
    private final Card ten;
    private final Card jack;
    private final Card queen;
    private final Card king;
    private final Card [] card ;
    /**
     * Constructs thirteen cards and puts them into an array.
     * @param x The suit of the thirteen cards.
     */
    protected Suit(String x) {
        
                 this.ace = new Card("A",1,"ACE",x);
                 this.two = new Card("2",2,"TWO",x);
                 this.three = new Card("3",3,"THREE",x);
                 this.four = new Card("4",4,"FOUR",x);
                 this.five = new Card("5",5,"FIVE",x);
                 this.six = new Card("6",6,"SIX",x);
                 this.seven = new Card("7",7,"SEVEN",x);
                 this.eight = new Card("8",8,"EIGHT",x);
                 this.nine = new Card("9",9,"NINE",x);
                 this.ten = new Card("10",10,"TEN",x);
                 this.jack = new Card("J",10,"JACK",x);
                 this.queen = new Card("Q",10,"QUEEN",x);
                 this.king = new Card("K",10,"KING",x);
                 this.card = new Card[]{ace,two,three,four,five,six,seven,eight,nine,ten,jack,queen,king};
             }
    /**
     * Retrieves a card from a suit.
     * @param o The index of the Card array
     * @return The card with the index o in array Card[].
     */
    protected Card getCard(int o){
                return card[o];
            }
}
