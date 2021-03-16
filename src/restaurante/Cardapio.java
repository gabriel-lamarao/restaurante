package restaurante;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Cardapio {
    Comanda comanda = new Comanda(1);
    
    
    int op;
    
	public void mostraCardapio(Estoque estoque) {
		try {
			System.out.println("Selecione a categoria: ");
			System.out.println("1 - Comidas");
			System.out.println("2 - Bebidas");
			System.out.println("3 - Sobremesas");
			
			Scanner entrada = new Scanner(System.in);
			op = entrada.nextInt();

			switch (op) {
			case 1:
				try {
					for (int i = 0; i < estoque.itens.length; i++) {
						if (estoque.itens[i].getCategoria().equals("Comida") && estoque.itens[i].consta == true) {
							System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: "
									+ estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
						}
					}
				} catch (NullPointerException e) {
					System.out.println("Erro ao exibir cardápio. Não há itens para exibir!");
				}
				break;

			case 2:
				try {
					for (int i = 0; i < estoque.itens.length; i++) {
						if (estoque.itens[i].getCategoria().equals("Bebida") && estoque.itens[i].consta == true) {
							System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: "
									+ estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
						}
					}
				} catch (NullPointerException e) {
					System.out.println("Erro ao exibir cardápio. Não há itens para exibir!");
				}
				break;

			case 3:
				try {
					for (int i = 0; i < estoque.itens.length; i++) {
						if (estoque.itens[i].getCategoria().equals("Sobremesa") && estoque.itens[i].consta == true) {
							System.out.println("Código: " + estoque.itens[i].codigo + "\nNome: "
									+ estoque.itens[i].getNome() + "\nPreço: R$" + estoque.itens[i].getPreco());
						}
					}
				} catch (NullPointerException e) {
					System.out.println("Erro ao exibir cardápio. Não há itens para exibir!");
				}
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Insira apenas caracteres válidos (números)");
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
    
    public void pedirConta(Cliente[] clientes) {
    	comanda.conta(clientes);
    }
    
}