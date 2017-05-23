//Cicero's Jesters(James Smith, Joelle Lum)
//APCS1 pd5
//HW34 -- Ye Olde Role Playing Game, Unleashed
//2016-11-22

public class Paladin extends Character {
    public Paladin(String strName){
	name = strName;
	hp = 250;
	strength = 40;
	defense = 70;
	attackRating = 0.7;
    }

    public void specialize(){
	normalize();
	strength += 30;
	defense -= 30;
	attackRating += 0.6;
	isSpec = true;
    }

    public void normalize(){
	if(isSpec){
	    strength -= 30;
	    defense += 30;
	    attackRating -= 0.6;
	    isSpec = false;
	}
    }

    public String about(){
	return "Paladin: The tankiest class with a focus on long fought battles with large amounts of armor and health";
    }	
}
