
public class Pokemon {
	public String name;
	public String type;
	public int health;
	static int totalPokemon = 0;
	
	public Pokemon(String name, String type, int health) {
		this.name = name;
		this.type = type;
		this.health = health;
		Pokemon.totalPokemon += 1;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public int getHealth() {
		return this.health;
	}

	public static int getTotalPokemon() {
		return totalPokemon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void attack(Pokemon target) {
		target.health -= 10;
	}
}
