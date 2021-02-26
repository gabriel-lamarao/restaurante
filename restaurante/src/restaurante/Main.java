package restaurante;

public class Main {
public static void main(String[] args) {
	Estoque produto = new Estoque();
	Cardapio cardapio = new Cardapio();
	
	produto.cadastrar(produto);	
	cardapio.mostraCardapio(produto);
}
}
