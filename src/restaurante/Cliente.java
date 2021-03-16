package restaurante;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

/**
 *
 * @author Aíla Maciel, Gabriel Lamarão
 */
public class Cliente {
    
    protected String nome;
    protected int totalDeClientes;
    //protected int id;
    protected int pedidos;
    protected boolean ativo;
    protected String cpf;
    protected boolean cpfvalido;
    int dia, mes, ano;
    LocalDate nascimento;
    protected String nivel;
    protected int numeroDePedidos;
    
    
    // Criar o vetor de clientes
    Cliente[] clientes; 
    
    DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner entrada = new Scanner(System.in);
    
    
	
    public Cliente() {
	clientes = new Cliente[1];
        this.ativo = true;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return this.cpf;
    }
    
    public void setCPF(String cpf){
        this.cpf = cpf;
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
    	try{
        System.out.println("Digite o CPF do cliente: ");
        System.out.println("Obs.: apenas números");
        Scanner entradaClienteClasse = new Scanner(System.in);    
        this.cpf = entradaClienteClasse.next();
            validaCPF(this.cpf);
            if(this.cpfvalido == true){
                Scanner entradanome = new Scanner (System.in);
                System.out.println("Digite o nome do cliente: ");
                this.nome = entradanome.nextLine();
                System.out.println("Digite a data de nascimento do cliente: ");
                System.out.println("Obs.: Formato DD/MM/AAAA");
                System.out.println("Dia: ");
                try{
                	Scanner entradaDia = new Scanner(System.in);
                    dia = entradaDia.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Insira apenas caracteres válidos (números)");
                }            
                System.out.println("Mês: ");
                try{
                	Scanner entradaMes = new Scanner(System.in);
                    mes = entradaMes.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Insira apenas caracteres válidos (números)");
                }            
                System.out.println("Ano: ");
                try{
                	Scanner entradaAno = new Scanner(System.in);
                    ano = entradaAno.nextInt();
                    this.nascimento = LocalDate.of(ano, mes, dia);
                    totalDeClientes = totalDeClientes + 1;
                }catch(InputMismatchException e){
                    System.out.println("Insira apenas caracteres válidos (números)");
                }            
            } else{
                System.out.println("Cadastre um CPF válido.");
            }
            }catch(InputMismatchException e){
                System.out.println("Insira apenas caracteres válidos (números)");
            }

    }
    
    public void desativa(){
        ativo = false;
    }

    public void exibirCliente(){        
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Data de nascimento: " + this.nascimento.format(formatadorBarra));
        if(this.ativo = true){
            System.out.println("Este cadastro está ativo");
        } else{
            System.out.println("Este cadastro está desativado");
        }
    }
    
    public void validaCPF(String cpf){
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") ||
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") ||
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") ||
            cpf.equals("77777777777") ||
            cpf.equals("88888888888") ||
            cpf.equals("99999999999") ||
            cpf.length() != 11){
                System.out.println("O CPF é inválido.");
                this.cpfvalido = false;
        } else{        
            char[] digitos2 = cpf.toCharArray();
            int[] digitos = new int[digitos2.length];
            for(int i = 0; i < digitos2.length; i++){
                digitos[i] = Integer.parseInt(String.valueOf(digitos2[i]));
            }
            int[] peso1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] peso2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] resultado1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            int[] resultado2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
            //1o digito verificador
            for(int i = 0; i < 9; i++){
                resultado1[i] = digitos[i] * peso1[i];
            }
        
            int soma1 = 0;
            for(int i = 0; i < 9; i++){
                soma1 += resultado1[i];
            }
        
            int quo1, resto1;
            quo1 = soma1/11;
            resto1 = soma1%11;
        
            int verif1;
            if(resto1 < 2){
                verif1 = 0;
            } else{
                verif1 = 11 - resto1;
            }

            //2o digito verificador
            for(int i = 0; i < 10; i++){
                resultado2[i] = digitos[i] * peso2[i];
            }
        
            int soma2 = 0;
            for(int i = 0; i < 10; i++){
                soma2 += resultado2[i];
            }
        
            int quo2, resto2;
            quo2 = soma2/11;
            resto2 = soma2%11;
        
            int verif2;
            if(resto2 < 2){
                verif2 = 0;
            } else{
                verif2 = 11 - resto2;
            }

            //compara os digitos verificadores pra ver se é valido
            if(digitos[9] == verif1 && digitos[10] == verif2){
                System.out.println("O CPF é válido!");
                this.cpfvalido = true;
            } else{
                System.out.println("O CPF é inválido.");
                this.cpfvalido = false;
            }
        }
    }

    public String nivelFidelidade(){
    //esse void serve pra exibir o nível de fidelidade do cliente
        if(this.pedidos > 0 && this.pedidos<=10) {
            nivel = "Nível 1 no programa de fidelidade";
        }else if(this.pedidos >= 11 && this.pedidos <= 20) {
            nivel = "Nível 2 no programa de fidelidade";
        }else {
            nivel = "Nível 3 no programa de fidelidade";
        }
        return nivel;
    } 
}
