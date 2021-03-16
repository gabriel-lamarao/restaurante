package restaurante;

/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Fidelidade extends Descontos{
	double nivel1 = 0.10;
	double nivel2 = 0.15;
	double nivel3 = 0.20;
	double desconto;
	@Override
	public double descontoFidelidade(double valor, Cliente cliente) {

		// o cliente devera armazenar o seu numero de pedidos;
		if (cliente.pedidos >= 0 && cliente.pedidos <= 10) {
			desconto = valor * nivel1;
			valor = valor - desconto;
			return valor;
		} else if (cliente.pedidos >= 11 && cliente.pedidos <= 20) {
			desconto = valor * nivel2;
			valor = valor - desconto;
			return valor;
		} else if (cliente.pedidos >= 21) {
			desconto = valor * nivel3;
			valor = valor - desconto;
			return valor;
		} else {
			System.out.println("Desconto padrao!");
			return valor;
		}
	}
	// niveis de fidelidade
	// nivel 1: de 0 a 10 x% de desconto
	// nivel 2: 11 a 20 x+x % de desconto
	// nivel 3: 21 a 30 x+x+x% de desconto 
}
