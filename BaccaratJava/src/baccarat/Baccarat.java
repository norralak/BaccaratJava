/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baccarat;
import java.util.Random;
import java.util.Scanner;

/**
 * This program simulates a baccarat game
 * @author Norralak
 */
public class Baccarat {

    /**
     * This program is a baccarat simulator
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Scanner read = new Scanner(System.in);        
        System.out.println("DEPOSIT FUNDS: ");        
        double bankroll = read.nextDouble();
        Deck d1 = new Deck();
        shuffle(d1);
        String loop = "";
        while (!(loop.equals("STOP")) && bankroll > 0){
            System.out.println("ENTER BET: ");
            double bet = read.nextDouble();
            bankroll = bankroll - bet;
            System.out.println("P FOR PLAYER, B FOR BANKER, T FOR TIE: ");
            String z = read.nextLine();
            z = read.nextLine();
            char x = baccarat(d1);
            
            if (x == z.charAt(0)){
                System.out.println("YOU WIN!");
                bankroll += payout(bet, x);
                System.out.println("BANKROLL: "+bankroll);
            } 
            
            else if (x == 'T' && z.charAt(0) != 'T'){
                System.out.println("YOU WIN!");
                bankroll = bankroll + bet;
                System.out.println("BANKROLL: "+bankroll);
            }
            
            else {
                System.out.println("YOU LOSE!");
                System.out.println("BANKROLL: "+bankroll);
            }
            
            if (d1.count > 46){
                shuffle(d1);
            }
            
            System.out.println("PRESS ANY KEY TO CONTINUE, TYPE STOP TO QUIT: ");
            loop = read.nextLine();
        }
        
        System.out.println("YOU'RE LEAVING THE TABLE WITH $"+bankroll);
    }

    protected static char baccarat(Deck ofCards){
        
        char result = ' ';
        int banker = 0; 
        int player = 0;
        for(int i = 0; i < 6; i++){
            if (i%2==1){
            System.out.print("BANKER");
            ofCards.drawCard();
            banker = (addCard(banker, ofCards.cards[(ofCards.count)-1]))%10;
            System.out.println("BANKER: "+banker);
            Continue();
            }
            if (i%2==0){
            System.out.print("PLAYER");
            ofCards.drawCard();
            player = (addCard(player, ofCards.cards[(ofCards.count)-1]))%10;
            System.out.println("PLAYER: "+player);
            Continue();
            }
            
            if( i == 3 && (player == 8 || player == 9 || banker == 8 || banker == 9 )){
                break; //natural
            }
            else if ( i == 3 && player >= 6 && banker >= 6 ){
                break;
            }
            else if ( i == 3 && player >= 6 && banker < player ){
                i += 1;
            }
            else if ( i == 4 && banker == 3 && cardVal(ofCards.cards[(ofCards.count)-1]) == 8){
                break;
            }
            else if ( i == 4 && banker == 4 && !( 1 < cardVal(ofCards.cards[(ofCards.count)-1]) && cardVal(ofCards.cards[(ofCards.count)-1]) < 8 ) ){
                break;
            }
            else if ( i == 4 && banker == 5 && !( 3 < cardVal(ofCards.cards[(ofCards.count)-1]) && cardVal(ofCards.cards[(ofCards.count)-1]) < 8 ) ){
                break;
            }
            else if ( i == 4 && banker == 6 && !( 5 < cardVal(ofCards.cards[(ofCards.count)-1]) && cardVal(ofCards.cards[(ofCards.count)-1]) < 8 ) ){
                break;
            }
            else if ( i == 4 && banker == 7 ){
                break;
            }

        }
        if (banker > player){
            result = 'B';
        }
        
        if (banker < player){
            result = 'P';
        }
        
        if (banker == player){
            result ='T';
        }
    
        return result;
    }
    
    /**
     * This function rearranges the array of cards in a deck
     * @param ofCards The card deck to be shuffled
     */
    protected static void shuffle(Deck ofCards){
            System.out.println("SHUFFLING...");
            Random chance = new Random();
            ofCards.count = 0;
            Card temp = new Card(null,13,null,null);
            for ( int i = 0; i < 52; i++){
                int index = chance.nextInt(51); 
                temp = ofCards.cards[i];
                ofCards.cards[i] = ofCards.cards[index];
                ofCards.cards[index] = temp;
            
            } 
    }
    /**
     * 
     * @param bet User input bet
     * @param result Baccarat result
     * @return Payout
     */
    protected static double payout(double bet, char result){
        double payout = 0.0;
        switch (result) {
            case 'P':
                payout = bet * 2;
                break;
            case 'B':
                payout = bet * 1.95;
                break;
            case 'T':
                payout = bet * 8;
                break;
            default:
                break;
        }
                
        return payout;
    }
    /**
     * This function adds two card values together
     * @param x First Card
     * @param y Second Card
     * @return Integer value sum
     */
    public static int addCard (Card x, Card y){
        int sum = x.getVal(x) + y.getVal(y);
        return sum;
    }
    /**
     * Overload of addCard with an integer and Card value
     * @param x Integer parameter
     * @param y Card parameter
     * @return  Sum of an integer and a card value
     */
    public static int addCard (int x, Card y){
        int sum = x + y.getVal(y);
        return sum;
    }
    /**
     * Getter for Card value
     * @param x Card parameter
     * @return Returns card's integer 
     */
    public static int cardVal (Card x){
        int y = x.getVal(x);
        return y;
    }
    /**
     * Press Enter to continue
     */
    public static void Continue() { 
        System.out.println("----------");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
 }
}
