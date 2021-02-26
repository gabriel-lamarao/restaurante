package restaurante;

public class Cardapio {
	public void mostraCardapio(Estoque array) {
		for(int i=0; i<array.totalDeProdutos-1; i++) {
			System.out.println("nome: "+array.getNome()+" preco: "+array.getPreco());
		}
		
		// Usar For Each causa Bug de Null Pointer Exception
		/*for(Estoque x : array.estoque) {
			System.out.println(x.getNome()+" R$ "+x.getPreco());
		}*/
	}
}
