
public class Ninja extends Human{
	private int defStealth = 10;
	private static int count = 0;

	public Ninja(String name) {
		this.name = name;
		this.stealth = defStealth;
		count += 1;
	}
	public void steal(Human victim) {
		victim.health -= this.stealth;
		this.health += this.stealth;
	}
	public void avoid() {
		this.health -= 10;
	}
	public static void howMany() {
		System.out.println("Total Ninjas: "+count);
	}
	public void displayStats() {
		int health = this.health;
		int strength = this.strength;
		int intelect = this.intelligence;
		int stealth = this.stealth;
		System.out.println(this.name+"'s Reamaining-> Health: "+health+" Strength: "+strength+" Intelect: "+intelect+" Stealth: "+stealth);
	}
}
