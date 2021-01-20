import java.util.ArrayList;

public class Pokedex extends AbstractPokemon implements Pokemoninterface{

	public void listPokemon() {
		ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();
		for(Pokemon i : pokeList) {
			System.out.println(i.getName());
		}
	}

}
