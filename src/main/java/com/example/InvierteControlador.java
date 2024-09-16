package com.example;

import spark.Request;
import spark.Response;
import spark.Route; 

public class InvierteControlador {
    public static Route invertirPalabra = (Request req, Response res) -> {
            Invierte palabra = new Invierte();
            String s = req.params("cadena");
            return palabra.reversePalabra(s);
    };
}
