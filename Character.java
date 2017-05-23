//Cicero's Jesters(James Smith, Joelle Lum)
//APCS1 pd5
//HW34 -- Ye Olde Role Playing Game, Unleashed
//2016-11-22

//General class for all living things

public abstract class Character{
    protected String name;
    protected int hp;
    protected int strength;
    protected int defense;
    protected double attackRating;
    protected boolean isSpec = false;
    
    public boolean isAlive(){
	return (hp > 0);
    }

    public int getDefense(){
	return defense;
    }

    public String getName(){
	return name;
    }

    public void lowerHP(int damage){
	hp-=damage;
    }

    public void lowerAttackRating(double rate){
	attackRating -= rate;
    }

    public void lowerStrength(int lowStren){
	strength -= lowStren;
    }

    public void lowerDefense(int lowDef){
	defense -= lowDef;
    }

    public int attack(Character creep){
	int damage = (int)(strength * attackRating) - creep.getDefense();
	if (damage < 0){
	    damage = 0;
	}
	creep.lowerHP(damage);
	return damage;
    }

    public Double[] debuff( Character creep){
	Double[] debuffStats = {0.2, 15., 8.};
	creep.lowerAttackRating(0.2);
	creep.lowerStrength(15);
	creep.lowerDefense(8);
	return debuffStats;
    }
    
    public abstract void specialize();

    public abstract void normalize();

    public abstract String about();
}
