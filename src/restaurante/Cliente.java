package restaurante;
import java.util.Scanner;
/**
 *
 * @author Aíla Maciel, Gabriel Lamarão
 */
public class Cliente {
    
    protected String nome;
    // Adicionar o cpf 
    protected int totalDeClientes;
    protected int pedidos;
    protected Data aniversario;
    protected boolean ativo;
    Cliente[] clientes; 
    
    Scanner entrada = new Scanner(System.in);
	
    public Cliente() {
	clientes = new Cliente[1];
        aniversario = new Data();
        this.ativo = true;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    } 
    
    public int getPedidos(){
        return this.pedidos;
    }
    
    public void setPedidos(int pedidos){
        this.pedidos = pedidos;
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

    public void cadastrarCliente(){
        System.out.println("Digite o nome do cliente: ");
        this.nome = entrada.next();
        System.out.println("Digite a data de nascimento do cliente: ");
        System.out.println("Obs.: Formato DD/MM/AAAA");
        System.out.println("Dia: ");
        this.aniversario.dia = entrada.nextInt();
        System.out.println("Mês: ");
        this.aniversario.mes = entrada.nextInt();
        System.out.println("Ano: ");
        this.aniversario.ano = entrada.nextInt();
        totalDeClientes = totalDeClientes + 1;
    }
    
    public void desativa(){
        ativo = false;
    }

    public void exibirCliente(){
        //System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de nascimento: " + this.aniversario.dia + "/" + this.aniversario.mes + "/" + this.aniversario.ano);
        //System.out.println("Nível no programa de fidelidade: ");
        if(this.ativo = true){
            System.out.println("Este cadastro está ativo");
        } else{
            System.out.println("Este cadastro está desativado");
        }
    }
}
