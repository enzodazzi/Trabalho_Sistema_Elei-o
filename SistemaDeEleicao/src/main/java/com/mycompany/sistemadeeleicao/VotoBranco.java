    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.mycompany.sistemadeeleicao;

    /**
     *
     * @author enzod
     */
    public class VotoBranco implements Votavel {
        private int qtdvotos = 0;


        public void receberVoto(){
            qtdvotos += 1;
        }
        public int getQtdVotos (){
            return qtdvotos;
        }
    }
