package restaurante;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	public void menu() throws IOException {
		int totalComandas = 0;
		double valorBalanco = 0;
		double valorComanda = 0;

		DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner entrada = new Scanner(System.in);
		int op;

		// le o arquivo de itens
		Estoque estoque = new Estoque(1);
		Cardapio cardapio = new Cardapio();
		Clientes clientes = new Clientes(1);
		// Gravar gravar = new Gravar();

		

		do {
			System.out.println("\nMENU RESTAURANTE");
			System.out.println("1- Cadastrar item");
			System.out.println("2- Editar item");
			System.out.println("3- Exibir itens");
			System.out.println("4- Entrada de estoque");
			System.out.println("5- Saída de estoque");
			System.out.println("6- Cardápio");
			System.out.println("7- Comanda");
			System.out.println("8- Balanço");
			System.out.println("9- Clientes");
			System.out.println("99 - Sair\n");
			System.out.printf("Selecione a opção desejada: ");
			
			Scanner entradaMenu = new Scanner(System.in);
			op = entradaMenu.nextInt();

			String produto;
			String comparaCpf;
			int cod;
			int compara1 = 0;
			int compara2 = 0;

			switch (op) {
			case 1:
				Item item = new Item();
				item.cadastra();
				if (item.nome != null) {
					item.codigo = estoque.controle;
					estoque.adicionar(item);
					// gravar.gravarItem(item.categoria, item.codigo, item.nome, item.preco,
					// item.quantidade,
					// item.totalDeProdutos, item.consta, item.confirmado);
				} else {
					System.out.println("Erro no cadastro de item. Tente novamente.");
				}
				break;

			case 2:
				System.out.printf("Insira o código do item a ser editado: ");
				try {
					cod = entrada.nextInt();

					// vai pegar o cod e comparar no array todo
					// compara1 vai ter o valor certo (se houver)
					// compara2 serve apenas pra não salvar os valores em cima do compara1

					for (int i = 0; i < estoque.itens.length; i++) {
						if (estoque.itens[i].codigo == cod) {
							compara1 = i; // cod salva a posição do objeto se for o correto
						} else {
							compara2 = i + 10; // só pro valor ser diferente mesmo
						}
					}

					// ele pega as variaveis de comparação e usa aqui
					// se compara1 for igual a cod, ele chama o método
					if (cod == compara1) {
						System.out.println("Produto encontrado!");
						estoque.itens[cod].editar();
						// adicionar gravação aqui
					} else if (cod != compara1) {
						System.out.println("Produto não encontrado");
					}
					// gravar.pesquisarItem(cod);

				} catch (InputMismatchException e) {
					System.out.println("Insira apenas caracteres válidos (números)");
				}
				break;

			case 3:
				try {
					for (int j = 0; j < estoque.itens.length; j++) {
						estoque.itens[j].exibirItem();
					}
				} catch (NullPointerException e) {
					System.out.println("Não há itens para exibir");
				}
				break;

			case 4:
				try {
					System.out.printf("Insira o código do item para adicionar estoque: ");
					Scanner entradaEstoque = new Scanner(System.in);
					cod = entradaEstoque.nextInt();

					for (int i = 0; i < estoque.itens.length; i++) {
						if (estoque.itens[i].codigo == cod) {
							compara1 = i; // cod salva a posição do objeto se for o correto
						} else {
							compara2 = i + 10; // só pro valor ser diferente mesmo
						}
					}

					if (cod == compara1) {
						System.out.println("Produto encontrado!");
						estoque.itens[cod].entradaEstoque();
					} else if (cod != compara1) {
						System.out.println("Produto não encontrado");
					}
				} catch (InputMismatchException e) {
					System.out.println("Insira apenas caracteres válidos (números)");
				}
				break;

			case 5:
				try {
					System.out.printf("Insira o código do item para remover estoque: ");
					Scanner saidaEstoque = new Scanner(System.in);

					cod = saidaEstoque.nextInt();

					for (int i = 0; i < estoque.itens.length; i++) {
						if (estoque.itens[i].codigo == cod) {
							compara1 = i; // cod salva a posição do objeto se for o correto
						} else {
							compara2 = i + 10; // só pro valor ser diferente mesmo
						}
					}

					if (cod == compara1) {
						System.out.println("Produto encontrado!");
						estoque.itens[cod].saidaEstoque();
					} else if (cod != compara1) {
						System.out.println("Produto não encontrado");
					}
				} catch (InputMismatchException e) {
					System.out.println("Insira apenas caracteres válidos (números)");
				}
				break;

			case 6:
				System.out.println("\n==== Cardápio ====\n");
				cardapio.mostraCardapio(estoque);
				break;

			case 7:
				try {
					do {
						int paraOCarrinho;
						System.out.println("\n==== Comanda ====\n");
						System.out.println(cardapio.comanda.localDate.format(formatadorBarra));
						System.out.println("1- Mostrar Cardapio");
						System.out.println("2- Adicionar item na comanda");
						System.out.println("3- Remover item na comanda");
						System.out.println("4- Exibir comanda");
						System.out.println("5- Fechar comanda");
						System.out.println("98 - Sair" + "\n");
						System.out.printf("\n Insira a opção desejada: ");
						cardapio.mostrarCarrinho();
						Scanner entradaCarrinho = new Scanner(System.in);

						op = entradaCarrinho.nextInt();

						switch (op) {
						case 1:
							cardapio.mostraCardapio(estoque);
							break;

						case 2:
							try {
								System.out.printf("Insira o codigo: ");
								Scanner entradaParaCarrinho = new Scanner(System.in);
								paraOCarrinho = entradaParaCarrinho.nextInt();

								for (int i = 0; i < estoque.itens.length; i++) {
									if (estoque.itens[i].codigo == paraOCarrinho) {
										cardapio.fazerPedido(estoque.itens[i]);
									}
								}
							} catch (InputMismatchException e) {
								System.out.println("Insira apenas caracteres válidos (números)");
							}
							break;

						case 3:
							try {
								if (cardapio.comanda.getTotalItensPedidos() > 0) {
									System.out.printf("Insira o codigo: ");
									Scanner entradaParaCarrinho2 = new Scanner(System.in);
									paraOCarrinho = entradaParaCarrinho2.nextInt();

									for (int i = 0; i < estoque.itens.length; i++) {
										if (estoque.itens[i].codigo == paraOCarrinho) {
											cardapio.removerPedido(estoque.itens[i]);
										}
									}
								} else {
									System.out.println("O carrinho já está vazio!");
								}
							} catch (InputMismatchException e) {
								System.out.println("Insira apenas caracteres válidos (números)");
							}
							break;

						case 4:
							// Clientes
							cardapio.pedirConta(clientes.clientes);
							break;

						case 5:
							try {
								if (cardapio.comanda.getTotalItensPedidos() > 0) {
									System.out.println("Gostaria de pontuar no programa de fidelidade?");
									System.out.println("1- Sim \n2- Nao");
									System.out.printf("\nInsira a opção desejada: ");
									Scanner entradaComanda = new Scanner(System.in);
									op = entradaComanda.nextInt();
									if (op == 1) {
										try {
											System.out.printf("Insira o CPF: ");
											Scanner entradaCpf = new Scanner(System.in);
											String cpf = entradaCpf.next();
											boolean encontrado = false;
											for (int i = 0; i < clientes.clientes.length; i++) {
												if (clientes.clientes[i].cpf.equals(cpf)) {
													clientes.clientes[i].numeroDePedidos++;
													encontrado = true;
												}
											}
											if (encontrado == false) {
												System.out.println("cpf não encontrado");
											}
										} catch (InputMismatchException e) {
											System.out.println("Insira apenas caracteres válidos (números)");
										}
									}
									System.out.println("Fechando comanda...");
									totalComandas++;
									valorBalanco += cardapio.comanda.getValorTotal();
									cardapio = new Cardapio();
									System.out.println("Comanda fechada! Uma nova comanda está pronta para uso.");
								} else {
									System.out.println("A comanda está vazia!");
								}
							} catch (InputMismatchException e) {
								System.out.println("Insira apenas caracteres válidos (números)");
							}
							break;

						default:
							System.out.println("Opção inválida!");
						}
					} while (op != 98);
				} catch (InputMismatchException e) {
					System.out.println("Insira apenas caracteres válidos (números)");
				}
				break;

			case 8:
				// balanco.verBalanco();
				System.out.println("Comandas fechadas hoje: " + totalComandas);
				System.out.println("Valor total de hoje: R$" + valorBalanco);
				break;

			case 9:
				try {
					do {
						System.out.println("1- Cadastrar cliente");
						System.out.println("2- Desativar cliente");
						System.out.println("3- Procurar cadastro de cliente");
						System.out.println("98- Voltar ao menu principal");
						System.out.printf("Selecione a opção desejada: ");
						Scanner entradaCliente = new Scanner(System.in);
						op = entradaCliente.nextInt();

						switch (op) {
						case 1:
							try {
								Cliente c = new Cliente();
								c.cadastrarCliente();
								if (c.cpfvalido == true && c.nascimento != null) {
									clientes.adicionar(c);
									System.out.println("Cliente cadastrado!");
									c.exibirCliente();
								} else {
									System.out.println("Erro ao cadastrar cliente. Tente novamente.");
								}
							} catch (InputMismatchException e) {
								System.out.println("Insira apenas caracteres válidos (números)");
							}
							break;

						case 2:
							try {
								System.out.printf("Insira o CPF do cliente: ");
								Scanner entradaCpf2 = new Scanner(System.in);
								comparaCpf = entradaCpf2.next();
								try {
									for (int i = 0; i < clientes.clientes.length; i++) {
										if (clientes.clientes[i].cpf.equals(comparaCpf)) {
											clientes.clientes[i].desativa();
										} else {
											System.out.println("CPF não encontrado!");
										}
									}
								} catch (NullPointerException e) {
									System.out.println("Não há itens para exibir");
								}
							} catch (InputMismatchException e) {
								System.out.println("Insira apenas caracteres válidos (números)");
							}
							break;

						case 3:
							try {
								System.out.printf("Insira o CPF do cliente: ");
								Scanner entradaCpf3 = new Scanner(System.in);
								comparaCpf = entradaCpf3.next();
								clientes.pesquisarCliente(comparaCpf);
							} catch (InputMismatchException e) {
								System.out.println("Insira apenas caracteres válidos (números)");
							}
							break;

						default:
							if (op != 98) {
								System.out.println("Opção inválida!");
							}
							break;
						}
					} while (op != 98);

				} catch (InputMismatchException e) {
					System.out.println("Insira apenas caracteres válidos (números)");
				}
				break;

			case 99:
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}
		} while (op != 99);
		entrada.close(); // Fecha o Scanner
		menu();
	}
}
