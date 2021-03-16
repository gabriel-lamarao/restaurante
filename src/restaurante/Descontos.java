package restaurante;
import java.util.Scanner;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Descontos {
	
	

	protected double desconto;
        int resp;
        
	public double descontoPadrao(double valor) {
		desconto = valor * 0.05;
		valor = valor - desconto;
		return valor;
	}

	
	public double descontoManual(double valor) {
		System.out.println("Insira a porcentagem do desconto: ");
		Scanner entradaDescontoManual = new Scanner(System.in);
		desconto = entradaDescontoManual.nextDouble();
		desconto = valor * (desconto * 0.01);
        valor = valor - desconto;
        return valor;
	}
	
	public double descontoFidelidade(double valor, Cliente cliente) {
		return desconto;
	}
	
	public double descontoAniversario(double valor, Cliente cliente, Comanda comanda) {
		if (cliente.nascimento.getDayOfMonth() == comanda.localDate.getDayOfMonth()
				&& cliente.nascimento.getMonthValue() == comanda.localDate.getMonthValue()) {
			desconto = valor * 0.3;
			valor = valor - desconto;
			return valor;
		} else {
			return valor;
		}
	}

}
