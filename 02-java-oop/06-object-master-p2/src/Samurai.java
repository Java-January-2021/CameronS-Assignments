
public class Samurai extends Human{
	private static int defHealth = 200;

	public Samurai() {
		this.health = defHealth;
	}
	public void deathBlow(Human victim) {
		victim.health = 0;
		int myHealth = this.health;
		this.health = myHealth/2;
	}
	public void meditate() {
		this.health = defHealth;
	}
	public int howMany() {
		int count = 0;
		//iterate through samurai instances
		return count;
		//returns the current number of Samurai.
	}

}
