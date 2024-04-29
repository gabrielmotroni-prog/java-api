package desafio02;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        // exercicio 01 e 02
        String jsonPessoa = "{nome:Rodrigo,idade:20,cidade:Brasília,pais:brasil}";
        String jsonPessoaDAdosAusentes = "{nome:Rodrigo,idade:20}";

        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa =  gson.fromJson(jsonPessoaDAdosAusentes, Pessoa.class);

        //System.out.println(pessoa.nome() + " " + pessoa.idade() + " " + pessoa.cidade());
        System.out.println(pessoa);

        //exercicio 03
        String jsonLivro = "{titulo:Bridgeton,autor:maria,editora:{nome:brilha}}";

        //Gson gson2 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        Gson gson2 = new Gson();

        Livro livro = gson2.fromJson(jsonLivro, Livro.class);

        System.out.println(livro);
    }
}
