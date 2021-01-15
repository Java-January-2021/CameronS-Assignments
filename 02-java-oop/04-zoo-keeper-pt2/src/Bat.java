
public class Bat extends Mammal {
	private static int defaultEnergyLevel = 300;
	
	public Bat() {
		this.energyLevel = defaultEnergyLevel;
	}
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("Flap-Flap-Flap");
	}
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("Snap-Crackle-Pop");
	}
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("AHHHH-'Snap-Crack-Pop'");
	}
}