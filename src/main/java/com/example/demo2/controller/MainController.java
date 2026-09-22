package com.example.demo2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MainController {
    @FXML private TextField localField;
    @FXML private Button btnSearch;
    @FXML private TextArea informationArea;

    public String getDataLocalField(){
        return localField.getText();
    }

    public void searchInformation() {
        try {
            String city = getDataLocalField();

            String json = getInformation(city);

            JSONObject jsonObject = new JSONObject(json);

            if (jsonObject.has("error")) {
                String message = jsonObject
                        .getJSONObject("error")
                        .getString("message");

                System.out.println("Erro: " + message);
                informationArea.setText("Localização não encontrada.");
                return;
            }

            printClimateData(json);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static String getInformation(String getDate) throws Exception{
        String apiKey = Files.readString(Paths.get("src/main/resources/api/api.txt")).trim(); //Tira os espaços do texto, se tiver.

        String formatCityName = URLEncoder.encode(getDate, StandardCharsets.UTF_8);
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formatCityName + "&lang=pt";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build(); // Nova requisição HTTP
        HttpClient client = HttpClient.newHttpClient(); // Enviar solicitações HTTP e receber respostas da WeatherAPI
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //Comunicação com o site da api

        return response.body();
    }

    public void printClimateData(String date){
        System.out.println("Dados originais (JSON) obtidos no site meteorológico: " + date);

        JSONObject jsonDate = new JSONObject(date);
        JSONObject weatherinformation = jsonDate.getJSONObject("current");

        // Dados da localização
        String city = jsonDate.getJSONObject("location").getString("name");
        String country = jsonDate.getJSONObject("location").getString("country");

        // Infomações adicionais
        String timeCondition = weatherinformation.getJSONObject("condition").getString("text");
        int humidity = weatherinformation.getInt("humidity");
        float windVelocity = weatherinformation.getFloat("wind_kph");
        float atmosphericPressure = weatherinformation.getFloat("pressure_mb");
        float feelsLikeTemperature = weatherinformation.getFloat("feelslike_c");
        float currentTemperature = weatherinformation.getFloat("temp_c");

        //Data e hora atual
        String dateTime = weatherinformation.getString("last_updated");

        //Texto das informações
        String information =
                "Informações Meteorológicas para " + city + ", " + country + "\n\n"
                        + "Data e Hora: " + dateTime + "\n"
                        + "Temperatura Atual: " + currentTemperature + "°C\n"
                        + "Sensação Térmica: " + feelsLikeTemperature + "°C\n"
                        + "Condição do Tempo: " + timeCondition + "\n"
                        + "Umidade: " + humidity + "%\n"
                        + "Velocidade do Vento: " + windVelocity + " km/h\n"
                        + "Pressão Atmosférica: " + atmosphericPressure + " mb";

        informationArea.setText(information);
    }
}
