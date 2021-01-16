
public class Samurai extends Human{
	private static int defHealth = 200;
	private static int count = 0;

	public Samurai() {
		this.health = defHealth;
		this.count += 1;
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
		//return count;
	}

}
