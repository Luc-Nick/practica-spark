package com.example;

import spark.Request;
import spark.Response;
import spark.Route;

public class CocktailControlador {

        public static Route coctelPorIngrediente = (Request req, Response res) -> {
        CocktailCLient coctel = new CocktailCLient();
        String ingrediente = req.params("ing");
        return coctel.obtenerRecetas(ingrediente);
    };
}
