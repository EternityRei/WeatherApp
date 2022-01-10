package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.json.JSONObject;

public class Controller {

    @FXML
    public ResourceBundle resources;

    @FXML
    public URL location;

    @FXML
    public AnchorPane getBg1;

    @FXML
    public AnchorPane getBg2;

    @FXML
    public Text getName;

    @FXML
    public TextField getCity;

    @FXML
    public Text getTemp;

    @FXML
    public Text getRF;

    @FXML
    public Text getCoR;

    @FXML
    public Text getWS;

    @FXML
    public Text getHum;

    @FXML
    public Text getPressure;

    @FXML
    public Text getAQI;

    @FXML
    public Button getFindButton;

    @FXML
    void initialize() {
        getFindButton.setOnAction(e -> {
            String getUserCity = getCity.getText().trim();
            String output = getURLInf("https://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=094f441c7787614890194110a0b15952&units=metric");

            if(!output.isEmpty()){

                //get data from the first URL
                JSONObject object = new JSONObject(output);
                getTemp.setText("Temperature: " + object.getJSONObject("main").getDouble("temp") + "℃");
                getRF.setText("Real feel: " + object.getJSONObject("main").getDouble("feels_like") + "℃");
                getCoR.setText("Clouds: " + object.getJSONObject("clouds").getDouble("all") + "%");
                getWS.setText("Wind speed: " + object.getJSONObject("wind").getDouble("speed") + "m/s");
                getHum.setText("Humidity: " + object.getJSONObject("main").getDouble("humidity") + "%");
                getPressure.setText("Pressure: " + object.getJSONObject("main").getDouble("pressure") + " mmHg");

                double lat,lon,aqi; //variables for air quality index
                lat = object.getJSONObject("coord").getDouble("lat"); //get latitude data from the first URL
                lon = object.getJSONObject("coord").getDouble("lon"); //get longitude data from the first URL

                //get data from the second URL
                String output_aqi = getURLInf("http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=094f441c7787614890194110a0b15952");
                JSONObject object_aqi = new JSONObject(output_aqi);
                aqi = object_aqi.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("aqi");
                switch ((int) aqi) {
                    case 1 -> getAQI.setText("Air Quality Index: " + (int) aqi + " (Good)");
                    case 2 -> getAQI.setText("Air Quality Index: " + (int) aqi + " (Fair)");
                    case 3 -> getAQI.setText("Air Quality Index: " + (int) aqi + " (Moderate)");
                    case 4 -> getAQI.setText("Air Quality Index: " + (int) aqi + " (Poor)");
                    case 5 -> getAQI.setText("Air Quality Index: " + (int) aqi + " (Very Poor)");
                }

            }
        });
    }
    //access URL
    private String getURLInf(String urlAddress){
        StringBuffer information = new StringBuffer();

        try{
            URL url = new URL(urlAddress);
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while((line = bufferedReader.readLine()) != null){
                information.append(line + "\n");
            }
            bufferedReader.close();

        } catch (Exception e){
            System.out.println("City was not found");

        }
        return information.toString();
    }
}
