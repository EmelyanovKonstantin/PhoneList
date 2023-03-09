package ru.emelyanovkonstantin.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Implementation of {@link QueryService} interface
 *
 * @version 1.0
 */
public class QueryServiceImpl implements QueryService{

    @Override
    public StringBuilder query(String string) {
        StringBuilder content = null;
        try {
            URL url = new URL(string);
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
