
public class Wizard extends Human{
	private static int defIntelligence = 8;
	private static int defHealth = 50;

	public Wizard() {
		this.health = defHealth;
		this.intelligence = defIntelligence;
	}
	public void heal(Human target) {
		target.health += this.intelligence;
	}
	public void fireball(Human victim) {
		victim.health -= this.intelligence*3;
	}
	
	

}
