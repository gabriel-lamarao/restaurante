package restaurante;
import java.util.Scanner;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Main {

    public static void main(String[] args) {
        
	Estoque produto = new Estoque();
	Cardapio cardapio = new Cardapio();
	
	produto.cadastrar(produto);	
	cardapio.mostraCardapio(produto);
	
	produto.editar(produto);
	cardapio.mostraCardapio(produto);

        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        do{
            System.out.println("Restaurante");
            System.out.println("Selecione a opção desejada: ");
            System.out.println("1 - Estoque");
            System.out.println("2 - Cardapio");
            System.out.println("3 - Contas");
            System.out.println("4 - Sair");
        
            opcao = entrada.nextInt();
        
            switch(opcao){
                case 1:
                    //todos os métodos de estoque
                break;
            
                case 2:
                    //todos os métodos de cardapio
                break;
            
                case 3:
                    //todos os métodos de contas
                break;
            
                case 4:
                    System.exit(0);
                break;
            
                default:
                break;
            }
        }while(opcao != 4); //o menu principal vai se repetir até que o usuário resolva sair do sistema
        
    }
    
}
