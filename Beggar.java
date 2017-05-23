//Cicero's Jesters(James Smith, Joelle Lum)
//APCS1 pd5
//HW34 -- Ye Olde Role Playing Game, Unleashed
//2016-11-22

public class Beggar extends Character{

    public Beggar(String strName){
	name = strName;
	hp = 30;
	strength = 10;
	defense = 10;
	attackRating = 0.5;
    }

    public void specialize(){
	normalize();
	strength +=1;
	defense -= 10;
	isSpec = true;
	
    }

    public void normalize(){
	if(isSpec){
	    strength -= 1;
	    defense += 10;
	    isSpec = false;
	}
    }

    public String about(){
	return  "Beggar: The weak and pitiful class";
    }
	
}
