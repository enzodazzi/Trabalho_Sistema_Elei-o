/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeeleicao;

/**
 *
 * @author enzod
 */
public class Usuario {
    protected String cpf;
    protected String Senha;
    protected String nome;
    protected boolean jaVotou;

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return Senha;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    public boolean Votar (){
        if (jaVotou) return false;
        
    }
    
    public boolean ValidarSenha (String senha){
        
    }
    
    public void candidatar_se(Eleicao eleicao){
        
    }
    public void criarUrna(){
        
    }
    public boolean resetarUrna (Urna urna){
        return false;
    }
    
    public boolean bloquearUrna(Urna urna){
        
    }
    public void CriarEleicao (){
        
    }
    public boolean EncerrarEleicao(Eleicao eleicao){
        return false;
    }
}
