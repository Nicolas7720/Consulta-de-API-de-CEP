package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Endereco;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void GerarArquivoJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }
}
