package restaurante;
import java.util.Scanner;
import java.time.LocalDate;
/**
 *
 * @authors Aíla Maciel, Gabriel Lamarão
 */

public class Comanda {
	private double valorTotal;
	private int totalItensPedidos;
	private Item[] itensPedidos;
	private double numPessoas;        
        LocalDate localDate;
        
        Descontos desconto = new Descontos();
        Cliente cliente = new Cliente();
        
	Scanner entrada = new Scanner(System.in);

	public Comanda(int i) {
            itensPedidos = new Item[i];
            this.localDate = LocalDate.now();
	}

	public int getTotalItensPedidos() {
            return totalItensPedidos;
	}
        
        public double getValorTotal(){
            return valorTotal;
        }         

        public void setValorTotal(double valorTotal){
            this.valorTotal = valorTotal;
        }    
	public void dividirConta() {
            System.out.println("Deseja dividir a conta para quantas pessoas?");
            numPessoas = entrada.nextDouble(); // coloquei double só pra não ter o trabalho de converter int depois

            double divisao = valorTotal / numPessoas;

            System.out.println("O valor fica R$" + divisao + " por pessoa");
	}

	public void adicionarItem(Item i) {
            if(i.quantidade > 0){
		if (totalItensPedidos < itensPedidos.length) {
                    itensPedidos[totalItensPedidos] = new Item();
                    i.confirmado = true;
                    itensPedidos[totalItensPedidos] = i; // Aramazena o novo objeto
                    totalItensPedidos++;
                    valorTotal += i.preco;
                    System.out.println("Item adicionado!");
		} else {
                    int novoTamanho = itensPedidos.length + 1;
                    Item[] novoArray = new Item[novoTamanho];

                    for (int j = 0; j < itensPedidos.length; j++) {
                    novoArray[j] = itensPedidos[j];
                    }
                
                    i.confirmado = true;
                    novoArray[itensPedidos.length] = i; // Armazena o novo objeto na ultimaposicao
                    itensPedidos = novoArray;
                    valorTotal += i.preco;
                    totalItensPedidos++;
                    System.out.println("Item adicionado!");
		}
		i.quantidade--;
            } else{
                System.out.println("O produto " + i.nome + " está esgotado.");
            }
	}

	public void removerItem(Item item) {
            if(totalItensPedidos>0) {
                totalItensPedidos--;
                item.confirmado = false;
                item.quantidade++;                    
		valorTotal -= item.preco;	
            }else {
		System.out.println("Erro ao remover, carrinho vazio!");
            }
	}

	public void carrinho() {
            System.out.println("Carrinho: " + totalItensPedidos + " Total: R$" + valorTotal+"\n");
	}

	public void conta() {
            int resp;
            if(totalItensPedidos > 0){
                System.out.println("Comanda:");
		for (int i = 0; i < itensPedidos.length; i++) {
                    if (itensPedidos[i].confirmado == true) {
                        System.out.println(itensPedidos[i].getNome() + "    R$" + itensPedidos[i].getPreco());
                    }
		}

                do{
                    System.out.println("Deseja adicionar algum desconto?");
                    System.out.println("1- Sim");
                    System.out.println("2- Não");
                    resp = entrada.nextInt();
                    switch (resp) {
                        case 1:
                            addDesconto();
                        break;
                    
                        case 2:
                            System.out.println(" ");
                        break;
                        
                        default:
                            System.out.println("Insira uma resposta válida!");
                        break;
                    }
                }while(resp != 1 && resp != 2);
                
                System.out.println("Deseja dividir o valor da conta entre pessoas?");
                System.out.println("1- Sim");
                System.out.println("2- Não");
                resp = entrada.nextInt();
        
                switch(resp){
                    case 1:
                        this.dividirConta();
                    break;
            
                    case 2:
                        System.out.println("Total: R$" + valorTotal);
                    break;
            
                    default:
                        System.out.println("Opção inválida!");
                    break;    
                }                
                //System.out.println("Total: R$" + valorTotal);
            }else{
                System.out.println("A comanda está vazia!");
            }
        }        

        
        public void addDesconto(){
            System.out.println("Selecione o desconto a ser aplicado: ");
            System.out.println("1- Desconto padrão (5%)");
            System.out.println("2- Desconto de aniversariante");
            System.out.println("3- Desconto de fidelidade");
            System.out.println("4- Desconto manual");
            int resp = entrada.nextInt();
                            
            switch (resp){
                case 1:
                    //desconto.descontoPadrao(valorTotal);
                    setValorTotal(desconto.descontoPadrao(valorTotal));
                break;
                                
                case 2:
                    desconto.descontoAniversario(valorTotal, cliente, this);
                break;
                            
                case 3:
                    desconto.descontoFidelidade(valorTotal, cliente);
                break;
                            
                case 4:
                    desconto.descontoPadrao(valorTotal);
                break;
                            
                default:
                    System.out.println("Opção inválida!");
                break;
            }                       
        }
        
}
