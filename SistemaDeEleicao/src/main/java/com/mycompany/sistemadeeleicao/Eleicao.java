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
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Candidato> candidatos = new ArrayList<>();
    private ArrayList<Urna> urnas = new ArrayList<>();
    private VotoNulo votoNulo;
    private VotoBranco VotoBranco;
    public Eleicao(String nome) {
        this.nome = nome;
    }
    
    public void InciarEleicao (){
        eleicaoAtiva = true;
    }
    public void FinalizarEleicao (){
        eleicaoAtiva = false;
    }
    
    public void MostrarResult (){
        
    }
    public void adicinarUsuario (Usuario usuario){
        
    }
    
    public void adicionarCandidatos (Candidato candidato){
       
    }
     
    public void adicionarUrna (Urna urna){
       
    }
    
}
