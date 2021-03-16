package restaurante;

import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Main {

	public static void main(String[] args) throws IOException{
		Menu menu = new Menu();
		try {
			menu.menu();				
		}catch (InputMismatchException e) {
			System.out.println("Insira apenas caracteres válidos (números)"+" CATCH DO MAIN");
		}
	}
}