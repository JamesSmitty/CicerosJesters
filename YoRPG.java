//Cicero's Jesters(James Smith, Joelle Lum)
//APCS1 pd5
//HW34 -- Ye Olde Role Playing Game, Unleashed
//2016-11-22

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated...
    private Monster smaug; //Friendly generic monster name?
    private Character pat;
    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG()
    {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- gathers info to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame()
    {
	String s;
	String name = "";
	int chosenClass = 0;
	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }
	
	s = "\nChoose your class: \n";
	pat = new Warrior("");
	s += "\t1: " + pat.about() + "\n";
	pat = new Rogue("");
	s += "\t2: " + pat.about() + "\n";
	pat= new Mage("");
	s += "\t3: " + pat.about() + "\n";
	pat = new Paladin("");
	s += "\t4: " + pat.about() + "\n";
	pat = new Beggar("");
	s += "\t5: " + pat.about() + "\n";
	s += "Selection: ";
	System.out.print(s);

	try {
	    chosenClass = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "Intrepid hero, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	//instantiate the player's character
	if (chosenClass == 1){
	    pat = new Warrior( name );
	}
	else if (chosenClass == 2){
	    pat =  new Rogue( name );;
	}
	else if (chosenClass == 3){
	    pat = new Mage( name );
	}
	else if (chosenClass == 4){
	    pat = new Paladin( name );
	}
	else if(chosenClass == 5){
	    pat = new Beggar( name );
	}
	else{
	    pat = new Warrior ( name );
	}

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn()
    {
	int i = 1;
	int d1, d2;
	Double[] debuffStats = {.0,.0,.0};

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "\nChoose your attack:" );
		    System.out.println( "\t1: Normal Attack\n\t2: Special Attack!\n\t3: Debuff the enemy\nYour Choice: " );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
		
		boolean debuffChoice = false;
		
		if ( i == 2 ){
		    pat.specialize();
		}
		else if (i == 3){
		    debuffStats = pat.debuff(smaug);
		    debuffChoice = true;
		}
		else{
		    pat.normalize();
		}
		
		if (!debuffChoice){
		    d1 = pat.attack( smaug );
		    System.out.println( "\n" + pat.getName() + " dealt " + d1 +
					" points of damage.");
		}
		else {
		    System.out.println("\n" + pat.getName() + " decreased Ye Old Monster's attack rating by " +
				       debuffStats[0] + ", its strength by " + debuffStats[1] + ", and its defense by " + debuffStats[2]);
		}
		smaug.monsterAI(pat);//Method to give smaug some intelligence when fighting
		d2 = smaug.attack( pat );
		System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
				    " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args )
    {
	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	
	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
	/*================================================
	  ================================================*/
    }//end main

}//end class YoRPG


