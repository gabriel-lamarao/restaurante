package restaurante;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Aíla Maciel e Gabriel Lamarão
 */
public class Item {

    String nome; // gravar
    String categoria; // gravar
    double preco; // gravar
    int quantidade = 0; //gravar
    int codigo; static int incremento; // gravar
    int totalDeProdutos; //define onde o produto vai ser cadastrado - gravar
    boolean consta; //ele decide se o produto consta ou nao no restaurante - gravar
    boolean confirmado; // Define se o produto estará no carrinho ou não - gravar
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
        System.out.println("Código: " + this.codigo);
        System.out.println("Categoria: "+ this.categoria);
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

        System.out.println("1- Comida");
        System.out.println("2- Bebida");
        System.out.println("3- Sobremesa");
        System.out.printf("Selecione a categoria do produto:");
		try {
			Scanner entradaCadastro = new Scanner(System.in);
			opcao = entradaCadastro.nextInt();
			switch (opcao) {
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

			System.out.printf("Insira o nome: ");
			Scanner nomeItem = new Scanner(System.in);
			try {
				this.nome = nomeItem.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Insira apenas caracteres válidos (letras e números)");
			}
			System.out.printf("Insira o preço: ");
			try {
				Scanner entradaPreco = new Scanner(System.in);
				this.preco = entradaPreco.nextDouble();
				totalDeProdutos = totalDeProdutos + 1;
				System.out.println("Produto cadastrado!");
			} catch (InputMismatchException e) {
				System.out.println("Insira apenas caracteres válidos (números)");
			}
		} catch (InputMismatchException e) {
			System.out.println("Insira apenas caracteres válidos (números)");
		}
	}
    
    public void editar(){        
    	try{ 
    	System.out.println("1- Editar Categoria");
        System.out.println("2- Editar Nome");
        System.out.println("3- Editar Preço");
        System.out.println("4- Desativar/Reativar Item");
        System.out.printf("Insira a opção desejada: ");
            
        	Scanner entradaEditar = new Scanner(System.in);
            opcao = entradaEditar.nextInt();
    			    			
            switch (opcao) {
                case 1:
                    System.out.println("==Editar Categoria==");
                    System.out.println("1- Comida");
                    System.out.println("2- Bebida");
                    System.out.println("3- Sobremesa");
                    System.out.printf("Digite a opção desejada: ");
                    
                    try{
                    	Scanner entradaCategoria = new Scanner(System.in);
                        opcao = entradaCategoria.nextInt();
                        
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
                    }catch(InputMismatchException e){
                        System.out.println("Insira apenas caracteres válidos (números)");
                    }
                break;
                        
            case 2:
                System.out.println("==Editar Nome==");
                Scanner nomeItem = new Scanner(System.in);
                System.out.printf("Insira o nome: ");
                try{
                    this.setNome(nomeItem.nextLine());//.strip());
                    System.out.println("Produto editado!");
                }catch(InputMismatchException e){
                    System.out.println("Insira apenas caracteres válidos (letras e números)");
                }

            break;
                            
            case 3:
                System.out.println("==Editar Preco==");
                System.out.printf("Insira o preco: ");
                try{
                	Scanner entradaPreco2 = new Scanner(System.in);
                    this.setPreco(entradaPreco2.nextDouble());
                    System.out.println("Produto editado!");
                }catch(InputMismatchException e){
                    System.out.println("Insira apenas caracteres válidos (números)");
                }
                
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
        }catch(InputMismatchException e){
            System.out.println("Insira apenas caracteres válidos (números)");
        }
        
    }        
    
    
    public void entradaEstoque(){
		try {
			int adicionar;
			System.out.printf("Insira a quantidade a ser adicionada: ");
			Scanner entradaEstoqueItem = new Scanner(System.in);
			adicionar = entradaEstoqueItem.nextInt();
			this.quantidade = this.quantidade + adicionar;

			System.out.println("Entrada concluída!\n");
			System.out.println("Nome: " + this.nome);
			System.out.println("Quantidade: " + this.quantidade);
		} catch (InputMismatchException e) {
			System.out.println("Insira apenas caracteres válidos (números)");
		}
	}    
    
	public void saidaEstoque() {
		if (this.quantidade > 0) {
			int remover;

			try {
				System.out.printf("Insira a quantidade a ser retirada: ");
				Scanner saidaEstoqueItem = new Scanner(System.in);
				remover = saidaEstoqueItem.nextInt();
				this.quantidade = this.quantidade - remover;

				System.out.println("Saída concluída!\n");
				System.out.println("Nome: " + this.nome);
				System.out.println("Quantidade: " + this.quantidade);
			} catch (InputMismatchException e) {
				System.out.println("Insira apenas caracteres válidos (números)");
			}
		} else {
			System.out.println("Este produto está esgotado!");
		}
	}
}
