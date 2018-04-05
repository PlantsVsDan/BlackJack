/*
// File:             SinglePlayer.java
// Created:          2018/04/05
// Author:           danIv
// Description:      The single player game.
*/
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
 
public class SinglePlayer {
  public static void main (String[] args){
    Scanner reader = new Scanner(System.in);
 
    String name = getName(reader);
    double money = getMoney(reader);
    
    double currentWager = 10.00; //Defaults to 10 per play
    
    Dealer.initDeck(Dealer.deck); //Init the deck
    Dealer.shuffleDeck(Dealer.deck);
 
    Hand playerHand = new Hand(Dealer.dealStartingCards(Dealer.deck));
    
    System.out.println("Dealing cards...");
    
    try
    {
      TimeUnit.SECONDS.sleep(2);
    }catch(InterruptedException ie)
    {
      
    }
    
    System.out.println("You have recieved a " + playerHand.hand.get(0).suit.symbol);
    
    
    //tell the player what cards they have
 
    System.out.println("(H)it, (St)and, (Sp)lit, (D)ouble, (Su)rrender");
    String choice = reader.nextLine();
 
//    if(choice.equals("H"))
//      //Deal one card to player
//    else if(choice.equals("D"))
//      //Deal one card to player and double their wager
//    else if(choice.equals("St"))
//      //End the turn of the player
//    else if(choice.equals("Sp"))
//      //Split the player's hand into two hands
//    else
  }
  
  public static String getName(Scanner reader){
    String name = "";
    
    while(!false){
      System.out.println("Welcome to the table, what is your name?");
      name = reader.nextLine();
      
      if(name.length() >= 3){
        break;
      }
      
      System.out.println("Sorry, but '" + name + "' is not a valid name.");
    }
    
    return name;
  }
  
  public static double getWager(Scanner reader, double currentWager){
    double wager = 0;
    while(!false){
      System.out.println("What would you like to wager?");
      wager = reader.nextDouble();
      reader.nextLine();
      
      if(wager >= currentWager){
        break;
      }
      
      System.out.println("Sorry, but $" + wager + " is not a valid wager.\nPlease either match or raise $" + currentWager + ".");
    }
    
    return wager;
    
  }
  
  public static double getMoney(Scanner reader){
    double money = 0.00;
    while(true){
      System.out.println("How much money do you have? You must have at least 10 dollars to begin.");
      money = reader.nextDouble();
      reader.nextLine();
        
      if(money >= 10.00)
        break;
      
      System.out.println("Sorry, but that's not a valid amount of money!");
    }
      
  return money;
  }
}