package restaurante;
import java.util.Scanner;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Cardapio {
    Comanda comanda = new Comanda(1);
    
    Scanner entrada = new Scanner(System.in);
    int op;
    
    public void mostraCardapio(Estoque estoque) {
        
        System.out.println("Selecione a categoria: ");
        System.out.println("1 - Comidas");
        System.out.println("2 - Bebidas");
        System.out.println("3 - Sobremesas");
        
        op = entrada.nextInt();
        
        switch(op){
            case 1:
                for(int i=0; i < estoque.itens.length; i++) {
                    if(estoque.itens[i].getCategoria().equals("Comida") && estoque.itens[i].consta == true){
                        System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: " + estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
                    }
                }
            break;
            
            case 2:
                for(int i=0; i < estoque.itens.length; i++) {
                    if(estoque.itens[i].getCategoria().equals("Bebida") && estoque.itens[i].consta == true){
                        System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: " + estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
                    }
                }
            break;            

            case 3:
                for(int i=0; i < estoque.itens.length; i++) {
                    if(estoque.itens[i].getCategoria().equals("Sobremesa") && estoque.itens[i].consta == true){
                        System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: " + estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
                    }
                }
            break;            
        }        
    }   
    
    public void fazerPedido(Item i) {
    	comanda.adicionarItem(i);
    }
    
    public void removerPedido(Item i) {
    	comanda.removerItem(i);
    }
    
    public void mostrarCarrinho() {
    	comanda.carrinho();
    }
    
    public void pedirConta() {
    	comanda.conta();
        
        System.out.println("Deseja dividir o valor da conta entre pessoas?");
        System.out.println("1- Sim");
        System.out.println("2- Não");
        int resp = entrada.nextInt();
        
        switch(resp){
            case 1:
                comanda.dividirConta();
            break;
            
            case 2:
                System.out.println("Total: R$" + comanda.getValorTotal());
            break;
            
            default:
                System.out.println("Opção inválida!");
            break;    
        }
    }
}

/*	for(int i=0; i < estoque.itens.length; i++) {
            System.out.println("Categoria: " + estoque.itens[i].getCategoria() + "\nNome: " + estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
            }*/
