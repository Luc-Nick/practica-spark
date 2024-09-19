package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class CocktailCLient {
    public String consultar(String i) {
        String apiUrl = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + i; 
        String output;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
            connection.setRequestMethod("GET"); // Se establece el método de la petición HTTP como GET
            connection.setRequestProperty(
                    "Accept", "application/json");

            if (connection.getResponseCode() == 200) { // 200==OK
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())); 

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line); 
                }
                output = response.toString();

                connection.disconnect(); 
            } else {
                output = "Error al consultar la API: " + connection.getResponseCode();
            }
        } catch (IOException e) { 
            output = "Error al consultar la API";
        }

        return output;
    }

 public JsonArray obtenerRecetas(String ingrediente) {
    String jsonResponse = consultar(ingrediente);
    try {
        
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        
        
        if (jsonObject.has("drinks") && !jsonObject.get("drinks").isJsonNull()) {
            
            return jsonObject.getAsJsonArray("drinks");
        } else {
            System.out.println("No se encontraron recetas para el ingrediente.");
            return new JsonArray(); 
        }
    } catch (JsonSyntaxException e) {
        System.out.println("Error al parsear el JSON: " + e.getMessage());
        return new JsonArray();
    }
}

}
