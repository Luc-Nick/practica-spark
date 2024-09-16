package com.example;

//import java.util.*;
import spark.Request;
import spark.Response;
import spark.Route;

public class CelAFahControlador {
    public static Route celAFah = (Request req, Response res) -> {
        CelAFah t = new CelAFah();
        int temp = Integer.parseInt(req.params("celsius"));
        double resCAF = t.celsiusAfahrenheit(temp);
        return "Conversión: C = \"" + temp + "\" º es F = \"" + resCAF + "\" º. ";
    };
}
