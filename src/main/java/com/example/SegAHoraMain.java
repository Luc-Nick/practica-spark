package com.example;

import static spark.Spark.get;

public class SegAHoraMain {
    public static void main(String[] args){
        get("/hora/:segundos",SegAHoraControlador.segundosAHoras);
        
    }
}
