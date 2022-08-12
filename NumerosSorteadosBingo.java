/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package NumerosBingo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Gustavo F. Vetter 10/08/2022
 */
public class NumerosSorteadosBingo {
    
    public static void main(String[] args) {
        // Construindo um ArrayList para Números Sorteados
        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
        int maior = 0;
        int menor = Integer.MAX_VALUE;
        int numeros = 0;
                
        // Criando um leitor para entrada de dados
        Scanner leitor = new Scanner (System.in);
        
        //Adicionar números sorteados ao ArrayList 
        System.out.print("Informe o nr. sorteado. Para encerrar, digite"
                    + " -1: ");
        
        while(numeros != -1){
            numeros=(leitor.nextInt());
            // A procura do maior numero
            if (numeros>maior){
                maior = numeros;
            }
            if (numeros!=-1){
                // A procura do menor numero
                if (numeros<menor){
                     menor = numeros;
                }
                listaNumeros.add(numeros);
                System.out.print("Informe o nr. sorteado. Para encerrar, "
                        + "digite -1: ");
            }
            // Encerrando a entrada de numeros sorteados
            if (numeros == -1){
                break;
            }
        }
        
        leitor.close();
        System.out.println("Os numeros sorteados foram: " + listaNumeros);
        System.out.println("Menor numero: " + menor);
        System.out.println("Maior numero: " + maior);
        System.out.println("Total de numeros sorteados: " 
                + listaNumeros.size());
}
}




    


