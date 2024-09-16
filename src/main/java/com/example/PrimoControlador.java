package com.example;

import spark.Request;
import spark.Response;
import spark.Route;

public class PrimoControlador {
    public static Route checkPrimo = (Request req, Response res) -> {
        Primo primo = new Primo();
        int num = Integer.parseInt(req.params("numero"));
        if (primo.isPrimo(num)) {
            return  num + " es Primo.";
        } else {
            return num + " no es primo.";
        }
    };
}
