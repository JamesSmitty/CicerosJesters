//Cicero's Jesters(James Smith, Joelle Lum)
//APCS1 pd5
//HW34 -- Ye Olde Role Playing Game, Unleashed
//2016-11-22

public class Rogue extends Character{

    public Rogue(String strName){
	name = strName;
	hp = 90;
	strength = 130;
	defense = 30;
	attackRating = 0.8;
    }

    public void specialize(){
	normalize();
	strength +=40;
	defense -= 25;
	attackRating *= 1.8;
	isSpec = true;
    }

    public void normalize(){
	if(isSpec){
	    strength -= 1;
	    defense += 25;
	    attackRating /= 1.8;
	    isSpec = false;
	}
    }

    public String about(){
	return "Rogue: A squishy class with the ability to deal massive amounts of damage through specialized, critical strikes";
    }
}
