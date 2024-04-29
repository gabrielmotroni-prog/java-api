package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        List<Titulo> listaTitulos = new ArrayList();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();


        while (true){

            System.out.println("digite nome do filme ");
            var busca = leitura.nextLine();



            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=350394ae";

            try{
                if(busca.equals("sair")){
                    break;
                }

                //cliente
                HttpClient client = HttpClient.newHttpClient();

                //requisicao
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                //resposta
                HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                //        usando serialize
                //        Gson gson = new Gson();
                //        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
                //        System.out.println("Titulo: " + meuTitulo.getNome() + "Ano: " + meuTitulo.getAnoDeLancamento());


                //classe Record para auxiliar na conversa para Titulo
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);


                Titulo tituloConvertido = new Titulo(meuTituloOmdb);
                System.out.println(tituloConvertido);

                // adicioona na listagem de filmes
                listaTitulos.add(tituloConvertido);


            }catch (NumberFormatException e ){
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());

            }
            catch (IllegalArgumentException e ){
                System.out.println("Argumento insirido de forma errada");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                //throw new RuntimeException(e);
                System.out.println(e.getMessage());
            }
            catch (NullPointerException e){
                System.out.println("Filme não encontrado");
            }



        }

        // salva lista json de filmes em arquivo
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(listaTitulos));
        escrita.close();

        System.out.println("lista: ");
        System.out.println(listaTitulos);

    }
}
