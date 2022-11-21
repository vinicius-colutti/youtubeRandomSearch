package com.colutti.learningCucumber.requests;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RamdomWordRequest {

    /* GitHub repo: https://github.com/RazorSh4rk/random-word-api
    Thanks @RazorSh4rk !! */
    private static final String RAMDOM_WORD_API = "https://random-word-api.herokuapp.com/word";

    public static String getRamdomWord() {
        HttpResponse<String> response = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(RAMDOM_WORD_API))
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.body();
    }

}
