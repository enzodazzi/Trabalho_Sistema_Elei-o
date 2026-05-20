/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeeleicao;

/**
 *
 * @author enzod
 */
import java.util.ArrayList;


public class Eleicao {
    
    private String nome;
    private boolean eleicaoAtiva;
    private ArrayList<Candidato> candidatos ;
    private VotoNulo votoNulo;
    private VotoBranco votoBranco;
    
    
    public Eleicao(String nome) {
        this.nome = nome;
        
        candidatos = new ArrayList<>(); 
        votoBranco = new VotoBranco();
        votoNulo = new VotoNulo();
    }
    
    public boolean isEleicaoAtiva() {
        return eleicaoAtiva;
    }

    public VotoNulo getVotoNulo() {
        return votoNulo;
    }

    public VotoBranco getVotoBranco() {
        return votoBranco;
    }

    
    
    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }
    
    public void adicionarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }
    
    
    public void inciarEleicao (){
        eleicaoAtiva = true;
    }
    public void finalizarEleicao (){
        eleicaoAtiva = false;
        candidatos.clear();

    

        votoBranco = new VotoBranco();

        votoNulo = new VotoNulo();

        
    }
    
    
    public void mostrarMenuVotos() {

        System.out.println("===== CANDIDATOS =====");

        for(Candidato c : candidatos) {

            System.out.println(
                c.getnCandidato()
                + " - "
                + c.getNome()
            );
        }

        System.out.println("1 - Voto Branco");
        System.out.println("2 - Voto Nulo");
    }
    
    public Candidato buscarCandidato(int numero) {

        for(Candidato c : candidatos) {

            if(c.getnCandidato() == numero) {
                return c;
            }
        }

        return null;
    }
    
    public void mostrarResultado() {

        System.out.println("\n===== RESULTADO DA ELEIÇÃO =====");

        int maiorQuantidade = candidatos.get(0).getQtdVotos();
        Candidato vencedor = candidatos.get(0);

        for(Candidato c : candidatos) {

            System.out.println(
                c.getNome()
                + " | Número: "
                + c.getnCandidato()
                + " | Votos: "
                + c.getQtdVotos()
            );

            if(c.getQtdVotos() > maiorQuantidade) {

                maiorQuantidade = c.getQtdVotos();

                vencedor = c;
            }
        }

        System.out.println(
            "\nVotos Brancos: "
            + votoBranco.getQtdVotos()
        );

        System.out.println(
            "Votos Nulos: "
            + votoNulo.getQtdVotos()
        );

        if(vencedor != null) {

            System.out.println(
                "\nVencedor: "
                + vencedor.getNome()
            );
        }

        else {

            System.out.println("\nNenhum vencedor.");
        }
        
        
    }
}
