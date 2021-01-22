
public class PokemonController {

	public static void main(String[] args) {
		Pokemon pikachu = new Pokemon("Pikachu", "yellow", 100);
		Pokemon charzard = new Pokemon("Charzard", "charmander", 100);
		pikachu.attack(charzard);
		System.out.println(charzard.getHealth());
		System.out.println(Pokemon.getTotalPokemon());
		Pokedex pL = new Pokedex();
		System.out.println(pL.pokemonInfo(charzard));
		pL.listPokemon();
	}

}
