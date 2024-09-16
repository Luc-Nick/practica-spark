package com.example;
import static spark.Spark.*;

public class CalculadoraMain {
    public static void main(String[] args) { 
        /* Ruta , Controlador */ 
        get("/sumar", CalculadoraControlador.sumar ); 
        get("/restar", CalculadoraControlador.restar);
        }
}
