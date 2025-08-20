package service;

import com.google.gson.Gson;
import dto.Endereco;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

    public Endereco buscaEndereco(String cep) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+ cep +"/json/"))
                .build();
        HttpResponse<String> response = null;
        try{
            response = HttpClient
                .newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (Exception e){
            throw new RuntimeException("Não foi possivel obter esse endereço por esse CEP");
        }

    }
}
