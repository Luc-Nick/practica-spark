package com.example;

import static spark.Spark.get;

public class TpMain {
    
    public static void main(String[] args){
        get("/celsiusAfahrenheit/:celsius",CelAFahControlador.celAFah); //ej1
        get("/esPrimo/:numero",PrimoControlador.checkPrimo);//ej2
        get("/esPar/:numero",ParControlador.checkPariedad); //ej3
        get("/invertir/:cadena",InvierteControlador.invertirPalabra);//ej4
        get("/hora/:segundos",SegAHoraControlador.segundosAHoras); //ej5
        get("/agregarUsuario",UsuariosControlador.agregarUsuario); // ej6
        get("/eliminarUsuario", UsuariosControlador.eliminarUsuario); // ej6
        get("/modificarUsuario", UsuariosControlador.modificarUsuario); // ej6
        get("/libros",LibroControlador.obtenerLibros); //ej7
        get("/libros/:id",LibroControlador.obtenerLibroPorId); //ej7
        get("/convertir/:monto",DolarControlador.obtenerConversion); //ej8
        get("/coctel/:ing", CocktailControlador.coctelPorIngrediente);// Ej 9: http://localhost:4567/coctel/:ing , devuelve un json con tragos para ese ingrediente.
        get("/pokemonInicial/:num",PokemonControlador.pokemonInicial); //Ej 10: escribir en http://localhost:4567/pokemonInicial/:num y te devuelve los datos de tu pokemon inicial. Suerte
    }
}