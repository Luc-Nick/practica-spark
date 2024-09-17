package com.example;

import spark.Request;
import spark.Response;
import spark.Route;

public class DolarControlador {
    
    public static Route obtenerConversion = (Request req, Response res) -> {
        ApiDolarClient dolarHoy = new ApiDolarClient();
        double monto = Double.parseDouble(req.params("monto"));
        String moneda = req.queryParams("moneda");
        boolean esPeso = moneda.equals("ARS");
        double tasaDeCambio = dolarHoy.obtenerTasaDeCambio(esPeso);
        if(esPeso){
            return monto / tasaDeCambio;
        } else {
            return monto * tasaDeCambio;
        }
    };
}
