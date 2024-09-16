package com.example;

import static spark.Spark.get;

public class LibroMain {
    
    public static void main(String[] args){
        get("/libros",LibroControlador.obtenerLibros);
        get("/libros/:id",LibroControlador.obtenerLibroPorId);
    }
}
