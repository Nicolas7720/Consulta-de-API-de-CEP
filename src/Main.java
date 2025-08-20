import dto.Endereco;
import service.ConsultaCEP;
import service.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um CEP que deseja consultar");
        String cep = leitura.nextLine();
        ConsultaCEP consultaCEP = new ConsultaCEP();
        try{

            Endereco novoEndereco = consultaCEP.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.GerarArquivoJson(novoEndereco);
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}