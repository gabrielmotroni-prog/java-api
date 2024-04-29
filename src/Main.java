import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Cep;
import modelos.CepViaCep;
import modelos.ValidaCepException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //campos serão convertidos para Upper Camel Case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        try {
            Scanner leitor = new Scanner(System.in);
            System.out.println("Escreva o CEP para pesquisar: ");
            String cepParaPesquisar = leitor.next();

            if(cepParaPesquisar.length()<8){
                throw new ValidaCepException("CEP deve conter 8 digitos");
            }


            String baseUrl = "https://viacep.com.br/ws";
            String url = String.format("%s/%s/json", baseUrl, cepParaPesquisar );
            System.out.println(url);

            //client
            HttpClient client = HttpClient.newHttpClient();

            //request
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            //response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println(response.body());


            CepViaCep cepViaCep = gson.fromJson(response.body(), CepViaCep.class);
            System.out.println(cepViaCep.cep());

            if(cepViaCep.cep() == ""){
                throw new ValidaCepException("CEP não encontrato");
            }

            Cep cep = new Cep(cepViaCep);

            File file = new File("cep.json");
            FileWriter writeHandle = new FileWriter(file);

            writeHandle.write(gson.toJson(cep));
            writeHandle.close();


            System.out.println(cep);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ValidaCepException e) {
            //throw  new ValidaCepException(e)
            System.out.println(e.getMessage());
        }
    }
}