package com.example;
import static spark.Spark.get;

public class PrimoMain {
    
    public static void main(String[] args){
        get("/esPrimo/:numero",PrimoControlador.checkPrimo);
    }
}
