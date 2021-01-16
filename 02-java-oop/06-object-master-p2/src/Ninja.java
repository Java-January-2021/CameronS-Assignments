
public class Ninja extends Human{
	private static int defStealth = 10;

	public Ninja() {
		this.stealth = defStealth;
	}
	public void steal(Human victim) {
		victim.health -= this.stealth;
		this.health += this.stealth;
	}
	public void avoid() {
		//a way to run away that decreases their health by 10
	}

}
