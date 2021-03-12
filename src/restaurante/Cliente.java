package restaurante;

public class Cliente {
	protected String nome;
	protected int totalDeClientes;
	protected int id;
	protected int pedidos;
	protected Data aniversario;
	// Criar o vetor de clientes
	Cliente[] clientes;
	
	
	public Cliente() {
		clientes = new Cliente[1];
	}
	
	public void adicionaCliente(Cliente cliente) {
		//novo cliente
		if(totalDeClientes < clientes.length) {
			clientes[totalDeClientes] = new Cliente();
			clientes[totalDeClientes] = cliente;
            totalDeClientes++;
		}else {
			int novoTamanho = clientes.length + 1;
            Cliente[] novoArray = new Cliente[novoTamanho];
            
            for (int i = 0; i < clientes.length; i++){
                novoArray[i] = clientes[i];
            }
        novoArray[clientes.length] = cliente;
        clientes = novoArray;
        totalDeClientes++;
		}
	}
	
}
