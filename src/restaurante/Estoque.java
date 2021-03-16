package restaurante;
import java.util.Scanner;

/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Estoque {
    
    int controle;
    Item[] itens;
    
    
    
    public Estoque(int totalDeProdutos){
        // instancia dados
    	itens = new Item[totalDeProdutos];
    }
    
    // receber os atributos de itens.txt formatados para salvar no vetor de itens
    public void adicionar(Item it){
        if(controle < itens.length){
            itens[controle] = new Item();
            itens[controle] = it;
            controle++;
        } else{
            int novoTamanho = itens.length + 1;
            Item[] novoArray = new Item[novoTamanho];
            
            for (int i = 0; i < itens.length; i++){
                novoArray[i] = itens[i];
            }
        novoArray[itens.length] = it;
        itens = novoArray;
        controle++;
        }
    }
    
}
