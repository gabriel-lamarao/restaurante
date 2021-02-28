package restaurante;
import java.util.Scanner;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Cardapio {
    
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
                    if(estoque.itens[i].getCategoria().equals("Comida")){
                System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: " + estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
                }
            }
            break;
            
            case 2:
                for(int i=0; i < estoque.itens.length; i++) {
                    if(estoque.itens[i].getCategoria().equals("Bebida")){
                System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: " + estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
                }
            }
            break;            

            case 3:
                for(int i=0; i < estoque.itens.length; i++) {
                    if(estoque.itens[i].getCategoria().equals("Sobremesa")){
                System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: " + estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
                }
            }
            break;            
        }
        
        }
}

/*	for(int i=0; i < estoque.itens.length; i++) {
            System.out.println("Categoria: " + estoque.itens[i].getCategoria() + "\nNome: " + estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
            }*/
