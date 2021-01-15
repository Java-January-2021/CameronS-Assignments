
public class Gorilla extends Mammal {
	
	public Gorilla() {
	}
	public void throwSomething() {
		energyLevel -= 5;
		System.out.println("Gorilla throws some poo.");
	}
	public void climb() {
		energyLevel -= 10;
		System.out.println("Gorilla climbs a tree.");
	}
	public void eatBananas() {
		energyLevel += 10;
		System.out.println("Gorilla eats a banana.");
	}
}
