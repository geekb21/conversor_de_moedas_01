package br.com.alura.conversordemoedas;

import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class ConversorDeMoedas {
    private final String apiKey;

    public ConversorDeMoedas() {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));
            this.apiKey = props.getProperty("api_key");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar chave da API: " + e.getMessage());
        }
    }

    public double converter(String de, String para, double valor) throws Exception {
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + de;

        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Erro ao conectar com a API: " + conn.getResponseCode());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        ExchangeRateResponse response = new Gson().fromJson(reader, ExchangeRateResponse.class);

        double taxa = response.getConversionRates().get(para);
        return valor * taxa;
    }
}