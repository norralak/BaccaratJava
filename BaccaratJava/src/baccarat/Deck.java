/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baccarat;

/**
 * This class is a deck which contains an array of 52 cards and four suits.
 * This class constructs four suits which in turn constructs 52 cards to be put in an array.
 * @author SM Murad, Tenzin Kalden
 */
public class Deck {
    
    protected final Card[] cards;
    private final Suit [] suits;
    private final Suit diamonds;
    private final Suit clubs; 
    private final Suit hearts;
    private final Suit spades;
    protected int count = 0; //counts the cards left in the deck
    
    /**
     * Creates an array of 52 cards, 13 from each suit.
     * Constructs the suits by passing a string of the suit name.
     */
    protected Deck(){
                 this.cards = new Card[52];
                 this.diamonds = new Suit("DIAMONDS");
                 this.clubs = new Suit("CLUBS");
                 this.hearts = new Suit("HEARTS");
                 this.spades = new Suit("SPADES");
                 this.suits = new Suit[]{diamonds, clubs, hearts, spades};
        
                 //stores each card from each suit in the Card[] array
                 int v = 0;
                 for (int i = 0; i < 4; i++){
                     for (int x = 0; x < 13; x++){
                         cards[v] = suits[i].getCard(x);
                         v++;
                     }
                 }
        

    
    }
    /**
     * Draws a card and calls showCard method.
     * Increment the deck's card count.
     */
    protected void drawCard(){
         cards[count].showCard(cards[count]);
         this.count += 1;
    }

}    

        
    

