//Cicero's Jesters(James Smith, Joelle Lum)
//APCS1 pd5
//HW34 -- Ye Olde Role Playing Game, Unleashed
//2016-11-22

public class Warrior extends Character{

    public Warrior(String strName){
	name = strName;
	hp = 125;
	strength = 100;
	defense = 40;
	attackRating = 0.4;
    }

    public void specialize(){
	normalize();
	strength +=10;
	defense -= 20;
	attackRating *= 1.5;
	isSpec = true;
    }

    public void normalize(){
	if(isSpec){
	    strength -= 10;
	    defense += 20;
	    attackRating /= 1.5;
	    isSpec = false;
	}
    }

    public String about(){
	return "Warrior: The most balanced class with a large amount of health and defense, while also being able to deal a respectable amount of damage";
    }
}
