package restaurante;
import java.util.Scanner;

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

    public void cadastrar(Estoque e){
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

        System.out.println("Selecione a categoria do produto: \n1- Comida \n2- Bebida \n3- Sobremesa"); // fazer switch/case ao inv�s de if
        int opcao = op.nextInt(); 
        switch (opcao) {
          case 1:
              this.categoria = "Comida";
		      case 2:
              this.categoria = "Bebida";
          case 3:
              this.categoria = "Sobremesa";
          default:
            System.out.println("Opcao invalida!");
		    	  break;
		    }
        System.out.println("Insira o nome: ");
        this.nome = op.next();
        System.out.println("Insira o pre�o");
        this.preco = op.nextDouble();
        
        totalDeProdutos = totalDeProdutos+1;
    }
    
    
    
}
