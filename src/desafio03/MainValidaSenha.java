package desafio03;

import desafio03.modelos.SenhaInvalidaException;
import desafio03.modelos.Usuario;

import java.util.Scanner;

public class MainValidaSenha {
    public static void main(String[] args) {

        try{
            Scanner leitura = new Scanner(System.in);

            System.out.println("Digite email do usuario: ");
            String email = leitura.nextLine();

            System.out.println("Digite uma senha: ");
            String senha = leitura.nextLine();

            Usuario usuario = new Usuario(email,senha);
        }catch (SenhaInvalidaException e ){
            System.out.println(e.getMessage());

        }
    }
}
