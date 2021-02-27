package restaurante;

public class Cardapio {
	public void mostraCardapio(Estoque e) {
		for(int i=0; i<e.estoque.length; i++) {
			System.out.println(e.estoque[i].getCategoria()+" "+"nome: "+e.estoque[i].getNome()+" preco: "+e.estoque[i].getPreco());
		}
		
		// Usar For Each causa Bug de Null Pointer Exception
		/*for(Estoque x : array.estoque) {
			System.out.println(x.getNome()+" R$ "+x.getPreco());
		}*/
	}
}
