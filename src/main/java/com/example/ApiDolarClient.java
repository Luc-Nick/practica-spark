package com.example;

//referencia: https://www.espai.es/blog/2022/08/apis-en-java/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ApiDolarClient {
    public String consultar(){
        String apiUrl =  "https://dolarapi.com/v1/dolares";
        String output;

        try{
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
            connection.setRequestMethod("GET"); 
            connection.setRequestProperty(
                "Accept", "application/json"); 

            if(connection.getResponseCode() == 200){ 
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
                
                StringBuilder response = new StringBuilder();  
                String line;
                while ((line = br.readLine()) != null) { 
                    response.append(line); 
                }
                output = response.toString(); 

                connection.disconnect(); 
            }
            else{
                output = "Error al consultar la API: " + connection.getResponseCode(); 
            }
        } catch (IOException e) { 
            output = "Error al consultar la API";
        }

        return output; 
    }


    public double obtenerTasaDeCambio(boolean esCompra) {
        String jsonResponse = consultar();
        JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();
        for (JsonElement elemento : jsonArray) {
            JsonObject jsonObject = elemento.getAsJsonObject();
            if (jsonObject.get("casa").getAsString().equalsIgnoreCase("oficial")) {
                if (esCompra) {
                    return jsonObject.get("venta").getAsDouble();
                } else {
                    return jsonObject.get("compra").getAsDouble();
                }
            }
        }
        
        throw new IllegalArgumentException("No se pudo encontrar el tipo de cambio oficial.");
    }
}

