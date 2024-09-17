package com.example;

import spark.Request;
import spark.Response;
import spark.Route;

public class PokemonControlador {
    
    public static Route pokemonInicial = (Request req, Response res) -> {
        PokemonClient pokemon = new PokemonClient();
        int pokeIni = Integer.parseInt(req.params("num"));
        return pokemon.consultar(pokeIni);
    };
}
