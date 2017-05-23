//Cicero's Jesters(James Smith, Joelle Lum)
//APCS1 pd5
//HW34 -- Ye Olde Role Playing Game, Unleashed
//2016-11-22

public class Mage extends Character{

    public Mage(String strName){
	name = strName;
	hp = 60;
	strength = 40;
	defense = 15;
	attackRating = 2.0;
    }

    public void specialize(){
	normalize();
	strength +=10;
	defense -= 5;
	attackRating *= 3.5;
	isSpec = true;
    }

    public void normalize(){
	if(isSpec){
	    strength -= 10;
	    defense += 5;
	    attackRating /= 3.5;
	    isSpec = false;
	}
    }

    public String about(){
	return "Mage: Very weak and squishy, but it's special ability channels the power stored in runes and releases a devestating magic attack";
    }
}
