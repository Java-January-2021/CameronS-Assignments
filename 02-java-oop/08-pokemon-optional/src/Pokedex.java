

public class Pokedex extends AbstractPokemon {

	public void listPokemon() {
		for(Pokemon i : pokeList) {
			System.out.println(i.getName());
		}
	}
	public String pokemonInfo(Pokemon Pokemon) {
		return String.format("%s is %s and has %d health", Pokemon.getName(), Pokemon.getType(), Pokemon.getHealth());
	}
	public Pokemon createPokemon(String name, String type, int health) {
		super.createPokemon(name, type, health);
		return Pokemon;
	}

}
