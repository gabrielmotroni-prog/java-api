package desafio03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDivideNumero {
    public static void main(String[] args) {

            while (true){
                try{

                    // desafio 01
                    Scanner leitura = new Scanner(System.in);

                    System.out.println("Digite numero 01 ");
                    var number1 = leitura.nextInt();

                    System.out.println("Digite numero 02 ");
                    var number2 = leitura.nextInt();

                    int resultado =  number1 / number2;
                    System.out.println("Resultado da divisão é " +  resultado);

                    System.out.println("Continuar? 0 sim 1 não  ");
                    var entradaContinuar = leitura.nextInt();
                    if(entradaContinuar == 1 ){
                        break;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Entrada deve ser somente de números inteiros");

                }catch (ArithmeticException e){
                    System.out.println("Não é possível realizar divisão por zero");

                }


            }


        }


    }
