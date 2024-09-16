package com.example;

import spark.Request;
import spark.Response;
import spark.Route;

public class SegAHoraControlador {
    public static Route segundosAHoras = (Request req, Response res) -> {
        SegAHora sah = new SegAHora();
        int segundos = Integer.parseInt(req.params("segundos"));
        return sah.segundosAHoras(segundos);
    };
}
