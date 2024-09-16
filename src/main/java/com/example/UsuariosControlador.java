package com.example;

import spark.Request;
import spark.Response;
import spark.Route;

public class UsuariosControlador {

    private static Usuarios listaUsuarios = new Usuarios();
    // se crea una instancia static para que cada vez que llegue una peticion no se
    // cree una lista nueva de usuarios y mantener en memoria la lista de usaurios.

    public static Route agregarUsuario = (Request req,Response res) -> {
        String nombre = req.queryParams("nombre");
        
        if (listaUsuarios.addUser(nombre)){ 
            return "El usuario " + nombre + " fue agregado con éxito";
        }
        return "Error: No se pudo agregar el nombre";
    };

    public static Route eliminarUsuario = (Request req,Response res) -> {
        String nombre = req.queryParams("nombre");

        if (listaUsuarios.deleteUser(nombre)){ 
            return "El usuario " + nombre + " fue eliminado con éxito";
        }
        return "Error: No se pudo eliminar el nombre";
    }; 

    public static Route modificarUsuario = (Request req, Response res) -> { 
        String viejoNombre = req.queryParams("viejoNombre");
        String nuevoNombre = req.queryParams("nuevoNombre");

        listaUsuarios.updateUser(viejoNombre, nuevoNombre);

        return "El usuario fue modificado con exito";

    };
}
