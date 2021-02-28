package restaurante;
import java.util.Scanner;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int op;
        
        Estoque estoque = new Estoque(2);
        Cardapio cardapio = new Cardapio();
        
        /*for(int i = 0; i < estoque.itens.length; i++){
            Item ii = new Item();
            ii.cadastra();
            estoque.adicionar(ii);
        }
        
        estoque.itens[1].entradaEstoque();
        estoque.itens[0].editar();
        
        
        for(int j = 0; j < estoque.itens.length; j++){
            estoque.itens[j].exibirItem();
        }*/
        
        
        //Item i1 = new Item();
        //i1.cadastra();
        //i1.exibirItem();
        //estoque.adicionar(i1);
        
        do{
        System.out.println("Menu restaurante");
        System.out.println("Selecione a opção desejada: ");
        System.out.println("1 - Cadastrar item");
        System.out.println("2 - Editar item");
        System.out.println("3 - Exibir itens");
        System.out.println("4 - Entrada de estoque");
        System.out.println("5 - Saída de estoque");
        System.out.println("6 - Cardápio");
        System.out.println("99 - Sair");
        
        op = entrada.nextInt();
        String produto;
        
        switch(op){
            case 1:
                Item ii = new Item();
                ii.cadastra();
                estoque.adicionar(ii);
            break;
            
            case 2:
                System.out.println("Digite o nome do item a ser editado: ");
                produto = entrada.next();
                for(int i=0; i<estoque.itens.length; i++) {
                    if(estoque.itens[i].nome.equals(produto)) { // busca o produto na lista estoque
                    System.out.println("Produto encontrado!");
                    estoque.itens[i].editar();
                    } else{
                        System.out.println("Produto não encontrado");
                    }
                }
            break;
            
            case 3:
                for(int j = 0; j < estoque.itens.length; j++){
                estoque.itens[j].exibirItem();
                }
            break;
            
            case 4:
                System.out.println("Digite o nome do item para adicionar estoque: ");
                produto = entrada.next();
                for(int i=0; i<estoque.itens.length; i++) {
                    if(estoque.itens[i].nome.equals(produto)) { // busca o produto na lista estoque
                    System.out.println("Produto encontrado!");
                    estoque.itens[i].entradaEstoque();
                    } else{
                        System.out.println("Produto não encontrado");
                    }
                }
            break;
            
            case 5:
                System.out.println("Digite o nome do item para remover estoque: ");
                produto = entrada.next();
                for(int i=0; i<estoque.itens.length; i++) {
                    if(estoque.itens[i].nome.equals(produto)) { // busca o produto na lista estoque
                    System.out.println("Produto encontrado!");
                    estoque.itens[i].saidaEstoque();
                    } else{
                        System.out.println("Produto não encontrado");
                    }
                }
            break;
            
            case 6:
                cardapio.mostraCardapio(estoque);
            break;
            
            case 99:
                System.exit(0);
            break;
            
            default:
                System.out.println("Opção inválida");
            break;    
        }
    }while(op != 99);
        
    }
    
}
