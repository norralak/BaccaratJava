/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baccarat;

/**
 * This class is a template for a card.
 * @author SM Murad, Tenzin Kalden
 */
public class Card {
    private final String x; //Symbol
    private final int value; //Points
    private final String name; //Name
    private final String suit; //Suit
    
    /**
     * Constructs card's attribute.
     * @param x The card's symbol.
     * @param value The point value of the card.
     * @param name The name of the card.
     * @param suit Suit which the card belongs to.
     */
    protected Card(String x, int value, String name, String suit){
                 this.x = x;
                 this.value = value;
                 this.name = name;
                 this.suit = suit;
             }
    /**
     * This method is to display a card to the user.
     * @param t The card to be displayed.
     */
    protected void showCard(Card t){
                 System.out.println(" DREW THE "+name+" OF "+suit);
             }
    /**
     * Card value getter
     * @param x The card parameter
     * @return The card's value
     */
    protected int getVal(Card x){
                 int cardVal = x.value;
                 return cardVal;
             }

}
