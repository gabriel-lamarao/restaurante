package restaurante;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Clientes {
	
    // Criar o vetor de clientes
    protected int totalDeClientes;
    Cliente[] clientes; 
    
    
    public Clientes(int totalDeClientes) {
    	clientes = new Cliente[totalDeClientes];
    }
    
    public void adicionar(Cliente cliente) {
	// novo cliente
	if (totalDeClientes < clientes.length) {
            clientes[totalDeClientes] = new Cliente();
            clientes[totalDeClientes] = cliente;
            totalDeClientes++;
	} else {
            int novoTamanho = clientes.length + 1;
            Cliente[] novoArray = new Cliente[novoTamanho];
            
            try{
                for (int i = 0; i < clientes.length; i++) {
                    novoArray[i] = clientes[i];
                }
            }catch(NullPointerException e){
                System.out.println("Erro ao percorrer lista de clientes!");
            }        
	novoArray[clientes.length] = cliente;
	clientes = novoArray;
	totalDeClientes++;
	}
    }

    public void pesquisarCliente(String comparaCpf) {
        try{
            for(int i =0; i<clientes.length; i++) {
		if(clientes[i].cpf.equals(comparaCpf)==true) {
                    System.out.println("Cliente encontrado!");
                    clientes[i].exibirCliente();
		}else {
                    System.out.println("Cliente não encontrado!");
		}
            }
        }catch(NullPointerException e){
            System.out.println("Não há clientes cadastrados!");
        }
    }
    
}