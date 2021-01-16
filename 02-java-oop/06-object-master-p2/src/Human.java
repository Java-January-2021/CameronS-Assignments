
public class Human {
	protected String name;
	protected int health;
	protected int strength;
	protected int intelligence;
	protected int stealth;
	private static int defHealth = 100;
	private static int defStrength = 3;
	private static int defIntelligence = 3;
	private static int defStealth = 3;
	
	public Human() {
		this.health = defHealth;
		this.intelligence = defIntelligence;
		this.stealth = defStealth;
		this.strength = defStrength;
	}
	public void attack(Human victim) {
		victim.health -= this.strength;
	}
	public int displayHealth() {
		int health = this.health;
		System.out.println("Reamaining Health: "+health);
		return health;
	}
	public int displayStrength() {
		int strength = this.strength;
		System.out.println("Reamaining Strength: "+strength);
		return strength;
	}
	public int displayIntelligence() {
		int intelect = this.intelligence;
		System.out.println("Reamaining Intelect: "+intelect);
		return intelect;
	}
	public int displayStealth() {
		int stealth = this.stealth;
		System.out.println("Reamaining Stealth: "+stealth);
		return stealth;
	}
	
}
