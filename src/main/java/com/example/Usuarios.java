package com.example;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    
    private List<String> listaUsuarios = new ArrayList<>(); 

    public boolean addUser(String nombre){
        boolean flag = listaUsuarios.add(nombre);
        imprimirUsuarios();
        return flag;
    }

    public boolean deleteUser(String nombre){
        boolean flag = listaUsuarios.remove(nombre);
        imprimirUsuarios();
        return flag;
    }

    public void updateUser(String oldnombre, String newnombre){
        int index = listaUsuarios.indexOf(oldnombre);
        if(index != -1){ //si encontro el indice, se devuelve el numero sino devuelve -1. Por eso nos aseguramos que el elemento este
            listaUsuarios.set(index,newnombre); //<lista>.set reemplaza el elemento en el index especificado, por el nuevo elemento
            imprimirUsuarios();
        }
        
    }

    // Método para imprimir la lista en consola y ver como se altera
    public void imprimirUsuarios() {
        System.out.println("Lista de usuarios:");
        for (String usuario : listaUsuarios) {
            System.out.println(usuario);
        }
    }
}
