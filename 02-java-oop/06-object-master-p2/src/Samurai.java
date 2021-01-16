
public class Samurai extends Human{
	private static int defHealth = 200;
	private static int count = 0;

	public Samurai(String name) {
		this.name = name;
		this.health = defHealth;
		count += 1;
	}
	public void deathBlow(Human victim) {
		victim.health = 0;
		int myHealth = this.health;
		this.health = myHealth/2;
	}
	public void meditate() {
		this.health = defHealth;
	}
	public static void howMany() {
		System.out.println("Total Samurai: "+count);
	}
	public void displayStats() {
		int health = this.health;
		int strength = this.strength;
		int intelect = this.intelligence;
		int stealth = this.stealth;
		System.out.println(this.name+"'s Reamaining-> Health: "+health+" Strength: "+strength+" Intelect: "+intelect+" Stealth: "+stealth);
	}
}
