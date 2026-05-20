/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeeleicao;
import java.util.Scanner;

/**
 *
 * @author enzod
 */
public class Urna {
    private int id;
    private int tentativasInvalidas;
    private boolean bloqueada = false;

    public Urna(int id, int tentativasInvalidas) {
        this.id = id;
        this.tentativasInvalidas = tentativasInvalidas;
    }

    public int getId() {
        return id;
    }
    

    
    
    public boolean registrarVoto (Eleicao eleicao){
       Scanner scan = new Scanner(System.in);
       int tentativasRestantes = tentativasInvalidas;
       
       while(!bloqueada){
            

            eleicao.mostrarMenuVotos();

            System.out.print("Digite o número do voto: ");

            int numero = scan.nextInt();

            if(numero == 1) {

                eleicao.getVotoBranco().receberVoto();

                System.out.println("Voto branco registrado.");
                return true;
            }

            else if(numero == 2) {

                eleicao.getVotoNulo().receberVoto();

                System.out.println("Voto nulo registrado.");
                return true;
            }

            else {

                Candidato candidato = eleicao.buscarCandidato(numero);

                if(candidato != null) {

                    candidato.receberVoto();

                    System.out.println("Voto registrado para " + candidato.getNome());
                    return true;
                    
                }

                else {

                    tentativasRestantes -= 1;

                    System.out.println("Número inválido.");

                    if(tentativasRestantes <= 0) {

                        bloquearUrna();

                        System.out.println( "Urna bloqueada por suspeita de fraude." );
                        return false;
                    
                    }
                }
            }
        }
       return false;
    }
    
    public void bloquearUrna (){
        bloqueada = true;
    }
    public void resetarUrna () {
        bloqueada = false;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }
    
}
