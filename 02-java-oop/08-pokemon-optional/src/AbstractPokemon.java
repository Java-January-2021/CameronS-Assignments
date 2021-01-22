import java.util.ArrayList;

public abstract class AbstractPokemon implements Pokemoninterface{
	protected ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();
	
	
	public Pokemon createPokemon(String name, String type, int health) {
		Pokemon pk = new Pokemon(name, type, health);
		this.pokeList.add(pk);
		return pk;
	}

	public abstract String pokemonInfo(Pokemon Pokemon);
	
}
