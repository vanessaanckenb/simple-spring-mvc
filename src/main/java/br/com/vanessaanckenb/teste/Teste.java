package br.com.vanessaanckenb.teste;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Teste {
    public static void main(String[] args) {


        URI endereco = URI.create("https://api.api-futebol.com.br/v1/times/65");

        extracted();

        String token = "";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .header("Authorization", "Bearer " + token)
                .build();


        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.body());
            System.out.println();

    }

    private static void extracted() {
        String a = null;

        System.out.println(a.equalsIgnoreCase("b"));
    }
}
