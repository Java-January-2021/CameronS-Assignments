
public class Ninja extends Human{
	private static int defStealth = 10;
	private static int count = 0;

	public Ninja() {
		this.stealth = defStealth;
		this.count += 1;
	}
	public void steal(Human victim) {
		victim.health -= this.stealth;
		this.health += this.stealth;
	}
	public void avoid() {
		//a way to run away that decreases their health by 10
	}
	public static void howMany() {
		System.out.println("Total Ninjas: "+count);
		//return count;
	}

}
