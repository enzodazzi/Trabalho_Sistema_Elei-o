/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeeleicao;

/**
 *
 * @author enzod
 */
public class Administrador extends Usuario {
    
    
    
    public void criarUrna(Sistema sistema, int id, int tentativasInvalidas) {

        Urna novaUrna = new Urna(id, tentativasInvalidas);

        sistema.adicionarUrna(novaUrna);

        System.out.println("Urna criada com sucesso.");
    }

    
    public boolean resetarUrna(Urna urna) {

        urna.resetarUrna();

        System.out.println("Urna resetada com sucesso.");

        return true;
    }

    
    public boolean bloquearUrna(Urna urna) {

        urna.bloquearUrna();

        System.out.println("Urna bloqueada.");

        return true;
    }

    
    public void criarEleicao(Sistema sistema, String nomeEleicao) {

        Eleicao novaEleicao = new Eleicao(nomeEleicao);

        sistema.setEleicao(novaEleicao);
        novaEleicao.inciarEleicao();

        System.out.println("Eleição criada com sucesso.");
    }

    
    public boolean encerrarEleicao(Eleicao eleicao) {
        
        eleicao.mostrarResultado();

        eleicao.finalizarEleicao();

        System.out.println("Eleição encerrada.");

        return true;
    }

    
    public boolean validarSenha(String senha) {

        if(senha.length() < 10) {
            return false;
        }

        boolean possuiMaiuscula = false;
        boolean possuiMinuscula = false;
        boolean possuiNumero = false;
        boolean possuiEspecial = false;

        for(int i = 0; i < senha.length(); i++) {

            char c = senha.charAt(i);

            if(Character.isUpperCase(c)) {
                possuiMaiuscula = true;
            }

            else if(Character.isLowerCase(c)) {
                possuiMinuscula = true;
            }

            else if(Character.isDigit(c)) {
                possuiNumero = true;
            }

            else {
                possuiEspecial = true;
            }
        }

        if(!possuiMaiuscula) {
            return false;
        }

        if(!possuiMinuscula) {
            return false;
        }

        if(!possuiNumero) {
            return false;
        }

        if(!possuiEspecial) {
            return false;
        }

        return true;
    }
}

