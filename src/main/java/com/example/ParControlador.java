package com.example;

import spark.Request;
import spark.Response;
import spark.Route;

public class ParControlador {
    public static Route checkPariedad = (Request req, Response res) -> {
        Par par = new Par();
        int num = Integer.parseInt(req.params("numero")); 
        return (par.isPar(num)) ? "El numero " + num + " es Par" : "El numero " + num + " es Impar"; 
    };
}
