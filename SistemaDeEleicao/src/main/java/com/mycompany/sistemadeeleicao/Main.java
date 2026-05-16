package com.mycompany.sistemadeeleicao;

public class Main {

    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        sistema.iniciarSistema();

        while(true) {

            System.out.println("\n===== SISTEMA DE ELEIÇÃO =====");

            System.out.println("1 - Cadastrar usuário");

            System.out.println("2 - Login");

            System.out.println("0 - Encerrar sistema");

            int opcao = Verificador.lerInteiro("Escolha: ");
            
            switch(opcao) {
                case 1 -> {
                    String nome = Verificador.lerTexto("Nome: ");
                    
                    String cpf = Verificador.lerTexto("CPF: ");
                    
                    String senha = Verificador.lerTexto("Senha: ");
                    
                    System.out.println("1 - Usuário comum");

                    System.out.println("2 - Administrador");

                    int tipo =Verificador.lerInteiro("Tipo: ");
                    
                    sistema.cadastrarUsuario(nome,cpf,senha,tipo);
                }
                case 2 -> {
                    String cpf = Verificador.lerTexto("CPF: ");
                    
                    String senha = Verificador.lerTexto("Senha: ");
                    
                    Usuario usuario =  sistema.login(cpf,senha);
                    
                    if(!Verificador.verificarNull(usuario,"Usuário não encontrado.")) {

                        break;
                    }
                    
                    System.out.println("\nLogin realizado.");
                    
                    boolean logado = true;
                    
                    while(logado) {

                        System.out.println("\n===== MENU USUÁRIO =====");

                        System.out.println("1 - Votar");

                        System.out.println("2 - Candidatar-se" );
                        
                        
                        
                        if(usuario instanceof Administrador) {
                            
                            System.out.println("3 - Criar eleição");

                            System.out.println("4 - Criar urna");

                            System.out.println("5 - Encerrar eleição");

                            System.out.println("6 - Resetar urna");
                        }
                        
                        
                        
                        System.out.println( "0 - Logout");
                        
                        
                        
                        int escolha = Verificador.lerInteiro( "Escolha: " );
                        
                        
                        
                        switch(escolha) {
                            
                            case 1 -> {
                                if(Verificador.verificarNull(sistema.getEleicao(),"Nenhuma eleição criada.")) {
                                    
                                    boolean votar = usuario.votar(sistema);
                                    if(!votar)System.out.println("eleição indisponivel para essse usario");
                                }
                            }
                                
                            case 2 -> {
                                if(Verificador.verificarNull(sistema.getEleicao(),"Nenhuma eleição criada.")){
                                    
                                    int numero =Verificador.lerInteiro("Número do candidato: ");
                                    
                                    usuario.candidatarSe(sistema.getEleicao(),numero);
                                }
                            }
                                
                            case 3 -> {
                                if(usuario instanceof Administrador) {
                                    
                                    String nomeEleicao = Verificador.lerTexto("Nome da eleição: ");
                                    
                                    usuario.criarEleicao(sistema,nomeEleicao);
                                }

                                else {

                                    System.out.println("Usuário sem privilégio.");
                                }
                            }
                                
                                
                                
                            case 4 -> {
                                if(usuario instanceof Administrador) {
                                    
                                    int id =Verificador.lerInteiro("ID da urna: ");
                                    
                                    int tentativas = Verificador.lerInteiro("Tentativas inválidas máximas: ");
                                    
                                    usuario.criarUrna(sistema,id,tentativas);
                                }

                                else {

                                    System.out.println("Usuário sem privilégio.");
                                }
                            }
                                
                                
                                
                            case 5 -> {
                                if(usuario instanceof Administrador) {
                                    
                                    if(Verificador.verificarNull(sistema.getEleicao(),"Nenhuma eleição criada.")) {
                                        
                                        usuario.encerrarEleicao(sistema.getEleicao());
                                    }
                                }

                                else {

                                    System.out.println("Usuário sem privilégio.");
                                }
                            }
                                
                                
                                
                            case 6 -> {
                                if(usuario instanceof Administrador) {
                                    
                                    int idUrna = Verificador.lerInteiro("ID da urna: ");

                                    Urna urnaEncontrada = null;

                                    for(Urna urna : sistema.getUrnas()) {

                                        if(urna.getId() == idUrna) {
                                            urnaEncontrada = urna;
                                            break;
                                        }
                                    }

                                    if(!Verificador.verificarNull(urnaEncontrada,"Urna não encontrada.")) {

                                        break;
                                    }

                                    usuario.resetarUrna(urnaEncontrada);

                                }else{

                                    System.out.println("Usuário sem privilégio.");
                                }
                            }
                                
                                
                                
                            case 0 -> {
                                logado = false;

                                System.out.println("Logout realizado.");
                            }
                                
                                
                                
                            default -> System.out.println("Opção inválida.");
                        }
                    }
                }



                case 0 -> {
                    System.out.println("Sistema encerrado.");

                    return;
                }



                default -> System.out.println("Opção inválida.");
            }
        }
    }
}