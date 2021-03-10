package restaurante;

import java.util.Scanner;

/**
 *
 * @author Aíla Maciel e Gabriel Lamarão
 */
public class Item {

    String nome;
    String categoria;
    double preco;
    int quantidade = 0;
    int codigo; static int incremento;
    int totalDeProdutos; //define onde o produto vai ser cadastrado
    boolean consta; //ele decide se o produto consta ou nao no restaurante
    boolean confirmado; // Define se o produto estará no carrinho ou não
    int opcao;

    Scanner op = new Scanner(System.in);
    
    public Item(){
        this.consta = true;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCategoria(){
        return this.categoria;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public double getPreco(){
        return this.preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void exibirItem(){
        System.out.println("");
    	System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: R$" + this.preco);
        System.out.println("Quantidade em estoque: " + this.quantidade);
        if(this.consta == true){
            System.out.println("O item está ativo no cardápio");
        } else{
            System.out.println("O item está inativo no cardápio");
        }
        System.out.println("\n");
    }
    
    public void desativa(){
        consta = false;
    }
    
    public void cadastra(){

            System.out.println("Selecione a categoria do produto:");
            System.out.println("1- Comida");
            System.out.println("2- Bebida");
            System.out.println("3- Sobremesa");
            //System.out.println("98- Cancelar ação");
            opcao = op.nextInt(); 
            switch(opcao) {
                case 1:
                    this.categoria = "Comida";
                break;
          
                case 2:
                    this.categoria = "Bebida";
                break;
          
                case 3:
                    this.categoria = "Sobremesa";
                break;            
          
                default:
                    System.out.println("Opcao invalida!");
                break;          
            }
        
            System.out.println("Insira o nome: ");
            this.nome = op.next();
            System.out.println("Insira o preço: ");
            this.preco = op.nextDouble();
            totalDeProdutos = totalDeProdutos+1;
            
        
            System.out.println("Produto cadastrado!");
       
    }
    
    public void editar(){        
        System.out.println("1- Editar Categoria");
        System.out.println("2- Editar Nome");
        System.out.println("3- Editar Preço");
        System.out.println("4- Desativar/Reativar Item");
        System.out.println("Digite a opção desejada:");
                
        opcao = op.nextInt();
    			    			
    	switch (opcao) {
            case 1:
                System.out.println("==Editar Categoria==");
		System.out.println("1- Comida");
		System.out.println("2- Bebida");
		System.out.println("3- Sobremesa");
		System.out.println("Digite a opção desejada: ");
                opcao = op.nextInt();
                        
		switch (opcao) {
                    case 1:
                        this.categoria = "Comida";
                        System.out.println("Produto editado!");
                    break;
                            
                    case 2:
                        this.categoria = "Bebida";
                        System.out.println("Produto editado!");
                    break;
                            
                    case 3:
                        this.categoria = "Sobremesa";
                        System.out.println("Produto editado!");
                    break;                          
                            
                    default:
                        System.out.println("Opcao Invalida");
                    break;
                }
            break;
                        
            case 2:
                System.out.println("==Editar Nome==");
                System.out.println("Insira o nome: ");
                this.setNome(op.next());//.strip());
                System.out.println("Produto editado!");
            break;
                            
            case 3:
                System.out.println("==Editar Preco==");
                System.out.println("Insira o preco: ");
                this.setPreco(op.nextDouble());
                System.out.println("Produto editado!");
            break;

            case 4:
                if(this.consta == true){
                    this.consta = false;
                    System.out.println("Item desativado!");
                } else{
                    this.consta = true;
                    System.out.println("Item reativado!");
                }
            break;
                            
            default:
                System.out.println("Opcao invalida!");
            break;
	}    			
    }        
    
    
    public void entradaEstoque(){
        int adicionar;
        
        System.out.println("Insira a quantidade a ser adicionada: ");
        adicionar = op.nextInt();       
        this.quantidade = this.quantidade + adicionar;
        
        System.out.println("Entrada concluída!\n");
        System.out.println("Nome: " + this.nome);
        System.out.println("Quantidade: " + this.quantidade);
    }    
    
    public void saidaEstoque(){
        if(this.quantidade > 0){
            int remover;
        
            System.out.println("Insira a quantidade a ser retirada: ");
            remover = op.nextInt();       
            this.quantidade = this.quantidade - remover;
        
            System.out.println("Saída concluída!\n");
            System.out.println("Nome: " + this.nome);
            System.out.println("Quantidade: " + this.quantidade);        
        }else{
            System.out.println("Este produto está esgotado!");
        }
    }
    
    /*public void mostrarEstoque(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Quantidade: " + this.quantidade);
    }*/     
}
