package com.example;

import static spark.Spark.get;

public class InvierteMain {
    
    public static void main(String[]args){
        get("/invertir/:cadena",InvierteControlador.invertirPalabra);
    }
}
