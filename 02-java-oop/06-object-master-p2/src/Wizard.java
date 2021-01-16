
public class Wizard extends Human{
	private static int defIntelligence = 8;
	private static int defHealth = 50;
	private static int count = 0;

	public Wizard() {
		this.health = defHealth;
		this.intelligence = defIntelligence;
		this.count += 1;
	}
	public void heal(Human target) {
		target.health += this.intelligence;
	}
	public void fireball(Human victim) {
		victim.health -= this.intelligence*3;
	}
	public static void howMany() {
		System.out.println("Total Wizards: "+count);
		//return count;
	}
}
