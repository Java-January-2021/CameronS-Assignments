
public abstract class AbstractPokemon extends Pokemon implements Pokemoninterface{

	public AbstractPokemon(String name, String type, int health) {
		super(name, type, health);
	}

	@Override
	public Pokemon createPokemon(String name, String type, int health) {
		return this.createPokemon(name, type, health);
	}

	@Override
	public String pokemonInfo(Pokemon Pokemon) {
		return null;
	}

	
}
