package com.example;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class LibroControlador {

    private static LibroService listaLibros = new LibroService();
    private static Gson gson = new Gson();

    public static Route obtenerLibros = (Request req, Response res) -> {
        res.type("application/json"); // con esto establecemos el tipo de respuesta como JSON
        return gson.toJson(listaLibros.getLibros()); // Convertimos la lista de libros a JSON, ya que no podemos
                                                     // devolver la lista directamente como servicio
    };

    public static Route obtenerLibroPorId = (Request req, Response res) -> {
        int id = Integer.parseInt(req.params("id"));
        Libro libro = listaLibros.getLibroPorId(id); //me conviene instanciar con un libro para poder manejar errores mas facil

        if (libro != null) {
            res.type("application/json"); // con esto establecemos el tipo de respuesta como JSON
            return gson.toJson(libro); // Convertimos el libro a JSON
        } else {
            res.status(404); // Si no se encuentra el libro, devolvemos un 404
            return "Libro no encontrado";
        }
    };

}
