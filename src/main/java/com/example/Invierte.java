package com.example;

public class Invierte {
    public String reversePalabra(String s){
        //StringBuilder (java.lang) es otra clase de Java para trabajar con String, que agrega funcionalidad. Ya que la clase String no permite modificar. 
        String sInvertida = new StringBuilder(s).reverse().toString(); 
        return sInvertida;
    }
}
