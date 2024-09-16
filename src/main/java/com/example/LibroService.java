package com.example;

import java.util.ArrayList;
import java.util.List;

public class LibroService {
    
    private List<Libro> listaLibros = new ArrayList<>();


    //creo el constructor, instanciando una lista de 5 libros con sus datos. 
    public LibroService(){
        listaLibros.add(new Libro(1, "El Quijote", "Miguel de Cervantes"));
        listaLibros.add(new Libro(2, "Cien años de soledad", "Gabriel García Márquez"));
        listaLibros.add(new Libro(3, "Harry Potter y la piedra filosofal","J. K. Rowling"));
        listaLibros.add(new Libro(4, "La Odisea", "Homero"));
        listaLibros.add(new Libro(5, "Don Juan Tenorio", "Jose Zorrilla"));
    }

    //consultar los libros
    public List<Libro> getLibros(){
        return listaLibros;
    }

    // Método para obtener un libro por ID
    public Libro getLibroPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null; // Si no encuentra el libro, retorna null
    }
}
