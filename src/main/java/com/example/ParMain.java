package com.example;

import static spark.Spark.get;

public class ParMain {
    
    public static void main(String[] args){
        get("/esPar/:numero",ParControlador.checkPariedad);
    }

}
