package desafio01;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite nome do livro: ");
        var nomeLivro = leitura.nextLine();


        //monta endereco
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + nomeLivro + "&key=";

        //cliente
        HttpClient client = HttpClient.newHttpClient();

        //requisicao
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

        //resposta
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());


    }
}
