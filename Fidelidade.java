package restaurante;

/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Fidelidade extends Descontos{
	int numeroDePedidos;
	double nivel1 = 10/100;
	double nivel2 = 15/100;
	double nivel3 = 20/100;
	
	@Override
	public double descontoFidelidade(double valor, Cliente cliente) {

            //o cliente devera armazenar o seu numero de pedidos;
            if(cliente.pedidos > 0 && cliente.pedidos<=10) {
		super.desconto = valor - (valor*nivel1);
		return super.desconto;
            }else if(cliente.pedidos >= 11 && cliente.pedidos <= 20) {
		super.desconto = valor - (valor*nivel2);
		return super.desconto;
            }else if(cliente.pedidos >= 21){
		super.desconto = valor - (valor*nivel3);
		return super.desconto;
            }else {			
		return super.descontoPadrao(valor);
            }
	}
	// niveis de fidelidade
	// nivel 1: de 0 a 10 x% de desconto
	// nivel 2: 11 a 20 x+x % de desconto
	// nivel 3: 21 a 30 x+x+x% de desconto 
}
