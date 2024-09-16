package com.example;

public class Primo {
    public boolean isPrimo(int n){
        if(n<= 1) return false;
        for(int i = 2; i <= Math.sqrt(n) ; i++){
            if (n % i == 0) return false;
        }
        return true;
    }
}
