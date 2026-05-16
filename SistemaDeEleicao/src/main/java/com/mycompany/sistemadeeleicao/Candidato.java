/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeeleicao;

/**
 *
 * @author enzod
 */
public class Candidato extends Usuario implements Votavel{
    private int nCandidato;
    private int qtdVotos = 0;

    public int getnCandidato() {
        return nCandidato;
    }

    public int getQtdVotos (){
        return qtdVotos;
    }

    public String getNome() {
        return nome;
    }
    
    
    
    public void setnCandidato(int nCandidato) {
        this.nCandidato = nCandidato;
    }
    
    
    public void receberVoto(){
        qtdVotos += 1;
    }
    
}
