//Cicero's Jesters(James Smith, Joelle Lum)
//APCS1 pd5
//HW34 -- Ye Olde Role Playing Game, Unleashed
//2016-11-22

public class Monster extends Character{
    public Monster(){	
	hp = 150;
	defense = 20;
	attackRating = 1.0;
	strength = (int)(Math.random()*45 + 20);
    }
	
    public String about(){
	return "The ugly beast";
    }

    public void specialize(){
	normalize();
	defense -= 10;
	attackRating += 0.4;
	strength += 10;
	isSpec = true;
    }

    public void normalize(){
	if (isSpec){
	    defense += 10;
	    attackRating -= 0.4;
	    strength -=10;
	    isSpec = false;
	}
    }

    public void monsterAI(Character enemy){//gives monster a chance to do more damage if they can execute the player, are about to die, or randomly with a 5% chance
	if ((enemy.hp <= ((int)((strength + 10) * (attackRating + 0.4) - enemy.getDefense())))||  hp < 15 || Math.random() <= .05){
	    specialize();
	}
    }
	
}
