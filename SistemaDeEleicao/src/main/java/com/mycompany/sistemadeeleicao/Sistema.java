/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeeleicao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author enzod
 */
public class Sistema {
   private ArrayList<Usuario> usuarios;
   private ArrayList<Urna> urnas;
   private Eleicao eleicao; 

    public Eleicao getEleicao() {
        return eleicao;
    }

   
   public ArrayList<Urna> getUrnas() {
        return urnas;
   }
   
    public void setEleicao(Eleicao eleicao) {
        this.eleicao = eleicao;
    }
   
   public void adicionarUrna(Urna urna) {
        urnas.add(urna);
   }
   
   public void cadastrarUsuario(String nome,String cpf,String senha,int tipo) {

        Scanner scan = new Scanner(System.in);

        if(tipo == 1) {

            Usuario usuario = new Usuario();
            if(!usuario.validarCpf(cpf, usuarios)) {

                System.out.println("Cpf invalido");
                return;
            }

            if(!usuario.validarSenha(senha)) {

                System.out.println("Senha inválida.");
                return;
            }

            usuario.setNome(nome);
            usuario.setCpf(cpf);
            usuario.setSenha(senha);

            usuarios.add(usuario);

            System.out.println("Usuário cadastrado.");
        }

        else if(tipo == 2) {

            System.out.println(
                "Login de administrador necessário."
            );

            System.out.print("CPF ADM: ");
            String cpfAdm = scan.nextLine();

            System.out.print("Senha ADM: ");
            String senhaAdm = scan.nextLine();

            Usuario adm = login(cpfAdm, senhaAdm);

            if(adm == null ||!(adm instanceof Administrador)) {

                System.out.println(
                    "Administrador inválido."
                );

                return;
            }

            Usuario novoAdm = new Administrador();
            
            if(!novoAdm.validarCpf(cpf,usuarios)) {

                System.out.println("Cpf invalido");
                return;
            }

            if(!novoAdm.validarSenha(senha)) {

                System.out.println(
                    "Senha de administrador inválida."
                );

                return;
            }

            novoAdm.setNome(nome);
            novoAdm.setCpf(cpf);
            novoAdm.setSenha(senha);

            usuarios.add(novoAdm);

            System.out.println(
                "Administrador cadastrado."
            );
        }

    }   
   
   public Usuario login (String cpf, String senha){
       
        Usuario usuario = buscarUsuario(cpf);

        if(usuario != null && usuario.getSenha().equals(senha)) {

            return usuario;
        }

        return null;
   }
   
   private Usuario buscarUsuario (String cpf){
       for(Usuario u : usuarios) {

            if(u.getCpf().equals(cpf)) {

                return u;
            }
        }

        return null;
   }
   
   public void adcionarUrna (Urna urna){
       
       urnas.add(urna);

        System.out.println(
            "Urna adicionada ao sistema."
        );
   }
   
   public void iniciarSistema (){
       usuarios = new ArrayList<>();

        urnas = new ArrayList<>();

        eleicao = null;

        criarPrimeiroAdm();

        System.out.println(
            "Sistema iniciado com sucesso."
        );
   }
   private void criarPrimeiroAdm() {

        Scanner scan = new Scanner(System.in);

        System.out.println(
            "===== CRIAÇÃO DO PRIMEIRO ADMINISTRADOR ====="
        );

        Administrador adm = new Administrador();

        System.out.print("Nome: ");
        String nome = scan.nextLine();

        System.out.print("CPF: ");
        String cpf = scan.nextLine();

        String senha;

        do {

            System.out.print("Senha: ");
            senha = scan.nextLine();

        }while(!adm.validarSenha(senha));

        adm.setNome(nome);
        adm.setCpf(cpf);
        adm.setSenha(senha);

        usuarios.add(adm);

        System.out.println(
            "Primeiro administrador criado."
        );
    }

}
