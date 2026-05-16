/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeeleicao;

/**
 *
 * @author enzod
 */
public class Urna {
    private int id;
    private int tentativasInvalidas;
    private boolean bloqueada;

    public Urna(int id, int tentativasInvalidas, boolean bloqueada) {
        this.id = id;
        this.tentativasInvalidas = tentativasInvalidas;
        this.bloqueada = bloqueada;
    }

    
    
    public void RegistrarVoto (){
        
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
