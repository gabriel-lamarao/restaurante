package restaurante;
import java.util.Scanner;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Descontos {
	
	Scanner entrada = new Scanner(System.in);

	protected double desconto;
        int resp;
        
	public double descontoPadrao(double valor) {
		desconto = valor * (5 / 100);
		valor = valor - desconto;
		return valor;
	}

	
	public double descontoManual(double valor) {
		System.out.println("Insira a porcentagem do desconto: ");
		desconto = entrada.nextDouble();
		desconto = valor * (desconto / 100);
		valor = valor - desconto;
		return valor;
	}
	
	public double descontoFidelidade(double valor, Cliente cliente) {
		return desconto;
	}
	
	public double descontoAniversario(double valor, Cliente cliente, Comanda comanda) {
            if(cliente.nascimento.isEqual(comanda.localDate)){
                desconto = valor * (30/100);
                valor = valor - desconto;
            }
		return valor;
	}

}
