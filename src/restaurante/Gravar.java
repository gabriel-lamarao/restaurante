package restaurante;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Gravar {
	
	
	public Gravar() throws IOException{
		
	}
	String nomeArquivo = "/home/gabriel/git/restaurante/src/restaurante/arquivos/itens.txt";
	FileWriter arquivo = new FileWriter(nomeArquivo, true);
	PrintWriter gravarArquivo = new PrintWriter(arquivo);
	FileReader arquivoLer = new FileReader(nomeArquivo);
	BufferedReader lerArquivo = new BufferedReader(arquivoLer);
	Item item = new Item();
	
	public void gravarItem(String categoria,
			int codigo,
			String nome, 
			double preco,
			int quantidade, 
			int totalDeProdutos,
			boolean consta, 
			boolean confirmado) throws IOException {
		
		FileWriter arquivo = new FileWriter(nomeArquivo, true);
		PrintWriter gravarArquivo = new PrintWriter(arquivo);
		gravarArquivo.println(categoria+","+codigo+","+nome+","+preco+","+quantidade+","+totalDeProdutos+","+consta+","+confirmado);
		arquivo.close();
	}
	// [categoria, codigo, nome, preco, quantidade, totalDeProdutos, consta, confirmado]
	
	public void pesquisarItem(int codigo) throws IOException {
		FileReader arquivoLer = new FileReader(nomeArquivo);
		BufferedReader lerArquivo = new BufferedReader(arquivoLer);
		
		String linha = lerArquivo.readLine();
		String[] divideLinha = linha.split(",");
		int gravaCodigo = Integer.parseInt(divideLinha[1]);
		
		if(linha != null) { // lê a primerira linha
			if(gravaCodigo == codigo) {
				item.editar();
				gravarItem(item.categoria, item.codigo, item.nome, item.preco, item.quantidade,
						item.totalDeProdutos, item.consta, item.confirmado);
			}else {
				while(linha != null) {
					linha = lerArquivo.readLine();
					divideLinha = linha.split(",");
					gravaCodigo = Integer.parseInt(divideLinha[1]);
					if(gravaCodigo == codigo) {
						item.editar();
						gravarItem(item.categoria, item.codigo, item.nome, item.preco, item.quantidade,
								item.totalDeProdutos, item.consta, item.confirmado);						
					}
				}
			}
		}
	}	
}
