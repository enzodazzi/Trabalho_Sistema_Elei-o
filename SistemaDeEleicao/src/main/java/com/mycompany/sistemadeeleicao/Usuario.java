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
    
    
    
    public boolean votar (Sistema sistema){
        if(!sistema.getEleicao().isEleicaoAtiva()) {
            System.out.println("A eleição não está ativa.");
            return false;
        }   

        if(jaVotou) {
            System.out.println("Usuário já realizou um voto.");
            return false;
        }

        for(Urna urna : sistema.getUrnas()) {

            if(!urna.isBloqueada()) {

                urna.registrarVoto(sistema.getEleicao());

                jaVotou = true;

                System.out.println("Voto realizado com sucesso.");
                return true;
            }
        }

        System.out.println("Nenhuma urna disponível.");
        return false;
        
        }
    
    public boolean validarSenha (String senha){
        if(senha.length() < 8) {
            return false;
        }

        boolean possuiMaiuscula = false;
        boolean possuiNumero = false;

        for(int i = 0; i < senha.length(); i++) {

            char c = senha.charAt(i);

            if(Character.isUpperCase(c)) {
                possuiMaiuscula = true;
            }

            if(Character.isDigit(c)) {
                possuiNumero = true;
            }   
        }

        if(!possuiMaiuscula) {
            return false;
        }

        if(!possuiNumero) {
            return false;
        }

        return true;
    }
    
    public boolean validarCpf(String cpf) {

        cpf = cpf.replace(".", "").replace("-", "");
        
        if(cpf.length() != 11) return false;
    
        boolean todosIguais = true;
        char c = cpf.charAt(0);
        if(!Character.isDigit(c)) return false;

        for(int i = 1; i < cpf.length(); i++) {

            c = cpf.charAt(i);

            if(!Character.isDigit(c)) return false;
            if(cpf.charAt(i) != cpf.charAt(0)) todosIguais = false;  
        }

        if(todosIguais) return false;
        
        return true;
    }
    
    public void candidatarSe(Eleicao eleicao, int numeroCandidato) {

        if(numeroCandidato < 1000 || numeroCandidato > 9999) {
            System.out.println("O número do candidato deve possuir 4 dígitos.");
            return;
        }

        for(Candidato c : eleicao.getCandidatos()) {

            if(c.getnCandidato() == numeroCandidato) {
                System.out.println("Número de candidato já utilizado.");
                return;
            }
        }

        Candidato novoCandidato = new Candidato();

        novoCandidato.setNome(this.nome);
        novoCandidato.setCpf(this.cpf);
        novoCandidato.setSenha(this.Senha);

        novoCandidato.setnCandidato(numeroCandidato);

        eleicao.adicionarCandidato(novoCandidato);

        System.out.println("Candidatura realizada com sucesso.");
    }
    
    public void criarUrna(Sistema sistema, int id, int tentativasInvalidas) {
        System.out.println("Usuário sem privilégio para criar urnas.");
    }
    
    public boolean resetarUrna(Urna urna) {

        System.out.println("Usuário sem privilégio para resetar urnas.");

        return false;
    }
    
    public boolean bloquearUrna(Urna urna) {

        System.out.println("Usuário sem privilégio para bloquear urnas.");

        return false;
    }
    public void criarEleicao(Sistema sistema, String nomeEleicao) {

        System.out.println("Usuário sem privilégio para criar eleições.");
    }
    public boolean encerrarEleicao(Eleicao eleicao) {

        System.out.println("Usuário sem privilégio para encerrar eleições.");

        return false;
    }
}
