/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeeleicao;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author enzod
 */
public class Verificador {
    private static Scanner scan = new Scanner(System.in);

    public static int lerInteiro(String mensagem) {

        while(true) {

            try {

                System.out.print(mensagem);

                int valor = scan.nextInt();
                scan.nextLine();

                return valor;
            }

            catch(InputMismatchException e) {

                System.out.println(
                    "Digite apenas números inteiros."
                );

                scan.nextLine();
            }
        }
    }            



    public static String lerTexto(String mensagem) {

        while(true) {

            try {

                System.out.print(mensagem);

                String texto = scan.nextLine();

                if(texto == null || texto.trim().isEmpty()) {

                    throw new NullPointerException();
                }

                return texto;
            }

            catch(NullPointerException e) {

                System.out.println(
                    "Entrada inválida."
                );
            }
        }
    }



    public static boolean verificarNull(Object obj,String mensagem) {

        try {

            if(obj == null) {

                throw new NullPointerException(mensagem);
            }

            return true;
        }

        catch(NullPointerException e) {

            System.out.println(mensagem);

            return false;
        }
    }
}
