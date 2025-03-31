package com.pokedex.pokedex.controller;

import com.pokedex.pokedex.model.Pokemon;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    // Lista estática de Pokémon para simular la "base de datos"
    private List<Pokemon> pokedex = Arrays.asList(
            new Pokemon(1, "Bulbasaur", Arrays.asList("Planta", "Veneno")),
            new Pokemon(2, "Ivysaur", Arrays.asList("Planta", "Veneno")),
            new Pokemon(3, "Venusaur", Arrays.asList("Planta", "Veneno")),
            new Pokemon(4, "Charmander", Arrays.asList("Fuego")),
            new Pokemon(5, "Charmeleon", Arrays.asList("Fuego")),
            new Pokemon(6, "Charizard", Arrays.asList("Fuego", "Volador")),
            new Pokemon(7, "Squirtle", Arrays.asList("Agua")),
            new Pokemon(8, "Wartortle", Arrays.asList("Agua")),
            new Pokemon(9, "Blastoise", Arrays.asList("Agua")),
            new Pokemon(25, "Pikachu", Arrays.asList("Eléctrico")),
            new Pokemon(39, "Jigglypuff", Arrays.asList("Normal", "Hada")),
            new Pokemon(52, "Meowth", Arrays.asList("Normal")),
            new Pokemon(150, "Mewtwo", Arrays.asList("Psíquico")),
            new Pokemon(151, "Mew", Arrays.asList("Psíquico"))
    );

    // Obtener todos los Pokémon
    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokedex;
    }

    // Obtener un Pokémon por su número
    @GetMapping("/{numero}")
    public Pokemon getPokemonByNumero(@PathVariable int numero) {
        return pokedex.stream()
                .filter(pokemon -> pokemon.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }
}
