package com.example;

public class SegAHora {
    public String segundosAHoras(int s){
        int horas = s / 3600; // Hora = 3600 seg.
        int minutos = (s % 3600 ) / 60; //al resto de 3600 lo divido para obtener la cantidad de minutos
        int segundos = s % 60; // el resto son los segundos que me sobran

        //return s + " segundos, son " + horas + ":" + minutos + ":" + segundos + " (HH:MM:SS)"; 
        return s + " segundos, son " + String.format("%02d:%02d:%02d", horas, minutos, segundos) + " (HH:MM:SS)";
        //String.format: %d (indica que es un entero), 02 asegura que se muestren al menos dos dígitos. Si el número tiene un solo dígito, se rellenará con un 0 al inicio.
    }
}
