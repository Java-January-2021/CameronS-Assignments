
public class Wizard extends Human{
	private static int defIntelligence = 8;
	private static int defHealth = 50;
	private static int count = 0;

	public Wizard(String name) {
		this.name = name;
		this.health = defHealth;
		this.intelligence = defIntelligence;
		count += 1;
	}
	public void heal(Human target) {
		target.health += this.intelligence;
	}
	public void fireball(Human victim) {
		victim.health -= this.intelligence*3;
	}
	public static void howMany() {
		System.out.println("Total Wizards: "+count);
	}
	public void displayStats() {
		int health = this.health;
		int strength = this.strength;
		int intelect = this.intelligence;
		int stealth = this.stealth;
		System.out.println(this.name+"'s Reamaining-> Health: "+health+" Strength: "+strength+" Intelect: "+intelect+" Stealth: "+stealth);
	}
}
