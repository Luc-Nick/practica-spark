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

/* Para hacer el get request de esta url debemos importar las librerías URL y HttpURLConnection 
y escribir el código dentro de un try catch block, ya que la conexión puede fallar */

public class ApiDolarClient {
    public String consultar(){
        String apiUrl =  "https://dolarapi.com/v1/dolares";
        String output;

        try{
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Se abre una conexión con la API usando la URL.
            connection.setRequestMethod("GET"); //Se establece el método de la petición HTTP como GET
            connection.setRequestProperty(
                "Accept", "application/json"); //Indica que esperas recibir una respuesta en formato JSON.

            if(connection.getResponseCode() == 200){ // 200==OK
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())); //Se utiliza un BufferedReader para leer la respuesta línea por línea.
                
                StringBuilder response = new StringBuilder();  //  El StringBuilder se usa para concatenar las líneas de la respuesta en una cadena.
                String line;
                while ((line = br.readLine()) != null) { //El bucle lee cada línea de la respuesta hasta que no haya más.
                    response.append(line); //Cada línea se agrega a la variable response.
                }
                output = response.toString();  // La respuesta completa se convierte en una cadena y se almacena

                connection.disconnect(); //Después de leer la respuesta, la conexión se cierra.
            }
            else{
                output = "Error al consultar la API: " + connection.getResponseCode(); //Si el código de respuesta no es 200, se guarda un mensaje de error en output con el código de error.
            }
        } catch (IOException e) { //Si ocurre una excepción de entrada/salida, se asigna un mensaje de error genérico.
            output = "Error al consultar la API";
        }

        return output; 
    }


    public double obtenerTasaDeCambio(boolean esCompra) {
        String jsonResponse = consultar();
        
        // Parsear el JSON
        JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();

        //Buscar el tipo de cambio oficial
        for (JsonElement elemento : jsonArray) {
            JsonObject jsonObject = elemento.getAsJsonObject();

            // Verificar si es el tipo "oficial"
            if (jsonObject.get("casa").getAsString().equalsIgnoreCase("oficial")) {
                // Si es compra o venta
                if (esCompra) {
                    return jsonObject.get("venta").getAsDouble();
                } else {
                    return jsonObject.get("compra").getAsDouble();
                }
            }
        }
        // Si no se encuentra el tipo, devolver un valor por defecto o lanzar una excepción
        throw new IllegalArgumentException("No se pudo encontrar el tipo de cambio oficial.");
    }
}

