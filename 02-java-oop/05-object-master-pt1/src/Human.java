
public class Human {
	protected int health;
	protected int strength;
	protected int intelligence;
	protected int stelth;
	private static int defHealth = 100;
	private static int defStrength = 3;
	private static int defIntelligence = 3;
	private static int defStealth = 3;
	
	public Human() {
		this.health = defHealth;
		this.intelligence = defIntelligence;
		this.stelth = defStealth;
		this.strength = defStrength;
	}
	public void attack(Human victim) {
		victim.health -= this.strength;
	}
	public int displayHealth() {
		int hlth = this.health;
		System.out.println("Reamaining Health: "+hlth);
		return hlth;
	}

}
