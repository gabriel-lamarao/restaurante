package restaurante;
import java.util.Scanner;

/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Estoque {
    
    String nome;
    String categoria;
    double preco;
    int quantidade;
    int codigo; //esse codigo precisa ser inserido automaticamente
    int totalDeProdutos; //define onde o produto vai ser cadastrado
    Estoque[] estoque;

    
    Estoque(){
    	estoque = new Estoque[1];
    }
    
    Scanner op = new Scanner(System.in);
    
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
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }    
    
    //Aumentar o tamanho do array e criar um novo objeto nele
    public void cadastrar(Estoque e){
        int outro;
        do{        
        if(totalDeProdutos < estoque.length){
            estoque[totalDeProdutos] = new Estoque();
            estoque[totalDeProdutos] = e;
            totalDeProdutos++;
        } else{
            int novoTamanho = estoque.length + 1;
            Estoque[] novoArray = new Estoque[novoTamanho];
            
            for (int i = 0; i < estoque.length; i++){
                novoArray[i] = estoque[i];
            }
            novoArray[estoque.length] = e;
            estoque = novoArray;
            totalDeProdutos++;
        }
        
        System.out.println("==Cadastrar Produto==");
        System.out.println("Selecione a categoria do produto:");
        System.out.println("1-Comida");
        System.out.println("2-Bebida");
        System.out.println("3-Sobremesa");
        
        int opcao = op.nextInt(); 
        
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
            
        System.out.println("Insira o nome: ");
        this.nome = op.next();
        System.out.println("Insira o preco: ");
        this.preco = op.nextDouble();
        System.out.println("Insira a quantidade: ");
        this.quantidade = op.nextInt();
        
        totalDeProdutos = totalDeProdutos+1;
        
        System.out.println("Produto cadastrado!");
        
        System.out.println("Deseja cadastrar outro item?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não");
        outro = op.nextInt();
        } while(outro == 1); //se a pessoa digitar 1, o menu de cadastro vai se repetir        
    }
    
    //Pesquisar o produto no array e editar seus atributos
    public void editar(Estoque e) {            
    	String produto;
    	int opcao;

        int outro;
        do{        
    	System.out.println("==Editar Produto==");
    	System.out.println("Digite o nome do produto: "); 
    	produto = op.next().strip();
    	for(int i=0; i<totalDeProdutos-1; i++) {
    		if(e.estoque[i].nome.equals(produto)) { // busca o produto na lista estoque
    			System.out.println("Produto encontrado!");
    			
    			System.out.println("1-Editar Categoria");
    			System.out.println("2-Editar Nome");
    			System.out.println("3-Editar Preco");
    			System.out.println("4-Editar Quantidade");
    			
    			opcao = op.nextInt();
    			
    			
    			switch (opcao) {
				case 1:
					System.out.println("==Editar Categoria==");
					System.out.println("1-Comida");
					System.out.println("2-Bebida");
					System.out.println("3-Sobremesa");
					
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
					e.estoque[i].setNome(op.next().strip());
                                        System.out.println("Produto editado!");
					break;
				case 3:
					System.out.println("==Editar Preco==");
					System.out.println("Insira o preco: ");
					e.estoque[i].setPreco(op.nextDouble());
                                        System.out.println("Produto editado!");
					break;
				default:
					System.out.println("Opcao invalida!");
					break;
				}
    			
    		}else {
    			System.out.println("Produto não encontrado");
    		}
    	}
        
        System.out.println("Deseja editar outro item?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não");
        outro = op.nextInt();
        } while(outro == 1); //se a pessoa digitar 1, o menu de edição vai se repetir         
    }
    
}
