package com.example;

import static spark.Spark.get;

public class UsuariosMain {
    
    public static void main(String[] args){
        get("/agregarUsuario",UsuariosControlador.agregarUsuario);
        get("/eliminarUsuario", UsuariosControlador.eliminarUsuario);
        get("/modificarUsuario", UsuariosControlador.modificarUsuario);
    }
}
