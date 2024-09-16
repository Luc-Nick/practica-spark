package com.example;
import static spark.Spark.get;

public class CelAFahMain {
    public static void main(String[] args){
        get("/celsiusAfahrenheit/:celsius",CelAFahControlador.celAFah);
    }
}
