import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    ArrayList<Clientes> clientes = ArquivoClientes.carregarClientes();
    ArrayList<Produtos> produtos = ArquivoProdutos.carregarProdutos();
    System.out.println("Produtos carregados: " + produtos.size());

    CompraService compra = new CompraService();

    int opcao = -1;

    while (opcao != 0) {
      System.out.println("\n=======================");
      System.out.println("     MINI MERCADO");
      System.out.println("=======================");
      System.out.println("1 - Produtos");
      System.out.println("2 - Clientes");
      System.out.println("3 - Realizar Compra");
      System.out.println("4 - Controle de Estoque");
      System.out.println("0 - Sair");

      opcao = sc.nextInt();

      if (opcao == 1) {
        int opcaoProduto = -1;

    while (opcaoProduto != 0) {

        System.out.println("\n=======================");
        System.out.println("       PRODUTOS");
        System.out.println("=======================");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Buscar Produto");
        System.out.println("4 - Alterar Produto");
        System.out.println("5 - Remover Produto");
        System.out.println("0 - Voltar");

        opcaoProduto = sc.nextInt();

        if (opcaoProduto == 1) {
            System.out.println("\\n===== CADASTRAR PRODUTO =====");
            System.out.print("Código: ");
            int codigo = sc.nextInt();

            sc.nextLine();

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();

           System.out.print("Estoque: ");
          int estoque = sc.nextInt();

            produtos.add(new Produtos(codigo, nome, preco, estoque));

            ArquivoProdutos.salvarProdutos(produtos);

            System.out.println("\nProduto cadastrado com sucesso!");
        }

        else if (opcaoProduto == 2) {
            System.out.println("\\n===== LISTA DE PRODUTOS =====");
            for (Produtos p : produtos) {

              System.out.println("--------------------");
              System.out.println("Código: " + p.getCodigo());
              System.out.println("Nome: " + p.getNome());
              System.out.println("Preço: R$ " + p.getPreco());
              System.out.println("Estoque: " + p.getEstoque());

            }
        }

        else if (opcaoProduto == 3) {
            System.out.println("\\n===== BUSCAR PRODUTO =====");
            System.out.print("Digite o código: ");

            int codigo = sc.nextInt();

              Produtos produtoEncontrado = null;

              for (Produtos p : produtos) {
              if (p.getCodigo() == codigo) {
              produtoEncontrado = p;
              break;
              }
            }

              if (produtoEncontrado == null) {

              System.out.println("Produto não encontrado.");

              } else {

              System.out.println("Código: " + produtoEncontrado.getCodigo());
              System.out.println("Nome: " + produtoEncontrado.getNome());
              System.out.println("Preço: R$ " + produtoEncontrado.getPreco());
              System.out.println("Estoque: " + produtoEncontrado.getEstoque());

              }
             }

        else if (opcaoProduto == 4) {
            System.out.println("\n===== ALTERAR PRODUTO =====");
            System.out.print("Digite o código: ");

            int codigo = sc.nextInt();

              Produtos produtoEncontrado = null;

            for (Produtos p : produtos) {
             if (p.getCodigo() == codigo) {
            produtoEncontrado = p;
            break;
            }
          }

          if (produtoEncontrado == null) {

            System.out.println("Produto não encontrado.");

          } else {

            sc.nextLine();

            System.out.print("Novo nome: ");
            String nome = sc.nextLine();

            System.out.print("Novo preço: ");
            double preco = sc.nextDouble();

            System.out.print("Novo estoque: ");
            int estoque = sc.nextInt();

            produtoEncontrado.setNome(nome);
            produtoEncontrado.setPreco(preco);
            produtoEncontrado.setEstoque(estoque);

            ArquivoProdutos.salvarProdutos(produtos);

            System.out.println("Produto alterado com sucesso!");
          }
        }

          else if (opcaoProduto == 5) {
              System.out.println("\n===== REMOVER PRODUTO =====");
              System.out.print("Digite o código: ");

              int codigo = sc.nextInt();

             Produtos produtoRemover = null;

              for (Produtos p : produtos) {
            if (p.getCodigo() == codigo) {
            produtoRemover = p;
            break;
              }
                }

                if (produtoRemover == null) {

                System.out.println("Produto não encontrado.");

              } else {

              produtos.remove(produtoRemover);

              ArquivoProdutos.salvarProdutos(produtos);

              System.out.println("Produto removido com sucesso!");
            }
          }
        }

      }

      else if (opcao == 2) {

        int opcaoCliente = -1;

        while (opcaoCliente != 0) {

          System.out.println("\n=======================");
          System.out.println("       CLIENTES");
          System.out.println("=======================");
          System.out.println("1 - Cadastrar Cliente");
          System.out.println("2 - Listar Clientes");
          System.out.println("3 - Buscar Cliente");
          System.out.println("4 - Alterar Cliente");
          System.out.println("5 - Remover Cliente");
          System.out.println("0 - Voltar");

          opcaoCliente = sc.nextInt();

          if (opcaoCliente == 1) {
            System.out.println("\n===== CADASTRAR CLIENTE =====");
            System.out.print("Digite o CPF: ");
            String cpf = sc.next();

            sc.nextLine();

            System.out.print("Digite o Nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite o Telefone: ");
            String telefone = sc.nextLine();

            System.out.print("Digite o Email: ");
            String email = sc.nextLine();

            clientes.add(new Clientes(cpf, nome, telefone, email));
            ArquivoClientes.salvarClientes(clientes);

            System.out.println("\nCliente cadastrado com sucesso!");
          }

           else if (opcaoCliente == 2) {
            System.out.println("\n===== LISTA DE CLIENTES =====");
            if (clientes.isEmpty()) {

              System.out.println("Nenhum cliente cadastrado.");

            } else {

                for (Clientes c : clientes) {

                  System.out.println("----------------------------");
                  System.out.println("CPF: " + c.getCpf());
                  System.out.println("Nome: " + c.getNome());
                  System.out.println("Telefone: " + c.getTelefone());
                  System.out.println("Email: " + c.getEmail());

                }
              }
            }

          else if (opcaoCliente == 3) {
            System.out.println("\n===== BUSCAR CLIENTE =====");
            System.out.print("Digite o CPF: ");
            String cpf = sc.next();

            Clientes clienteEncontrado = null;

              for (Clientes c : clientes) {

                if (c.getCpf().equals(cpf)) {
                  clienteEncontrado = c;
                }

              }

              if (clienteEncontrado == null) {
                System.out.println("Cliente não encontrado.");

              } else {

                System.out.println("\nCliente encontrado!");
                System.out.println("CPF: " + clienteEncontrado.getCpf());
                System.out.println("Nome: " + clienteEncontrado.getNome());
                System.out.println("Telefone: " + clienteEncontrado.getTelefone());
                System.out.println("Email: " + clienteEncontrado.getEmail());

              }
            }
          

          else if (opcaoCliente == 4) {
            System.out.println("\n===== ALTERAR CLIENTE =====");
            System.out.print("Digite o CPF: ");
            String cpf = sc.next();

              Clientes clienteEncontrado = null;

                for (Clientes c : clientes) {
                  if (c.getCpf().equals(cpf)) {
                  clienteEncontrado = c;
                }
              }

              if (clienteEncontrado == null) {
                System.out.println("Cliente não encontrado.");
              } else {

              sc.nextLine();

                System.out.print("Novo nome: ");
                String nome = sc.nextLine();

                System.out.print("Novo telefone: ");
                String telefone = sc.nextLine();

                System.out.print("Novo email: ");
                String email = sc.nextLine();

                clienteEncontrado.setNome(nome);
                clienteEncontrado.setTelefone(telefone);
                clienteEncontrado.setEmail(email);
                ArquivoClientes.salvarClientes(clientes);

                System.out.println("Cliente alterado com sucesso!");
              }
              } else if (opcaoCliente == 5) {
                System.out.println("\n===== REMOVER CLIENTE =====");
                System.out.print("Digite o CPF: ");
                String cpf = sc.next();

                Clientes clienteRemover = null;

                  for (Clientes c : clientes) {
                    if (c.getCpf().equals(cpf)) {
                    clienteRemover = c;
                  }

                }

                      if (clienteRemover == null) {
                        System.out.println("Cliente não encontrado.");

                      } else {
                        clientes.remove(clienteRemover);
                        ArquivoClientes.salvarClientes(clientes);
                        System.out.println("Cliente removido com sucesso!");

                      }
                    }
                }
              }
      
              else if (opcao == 3) {

                  System.out.println("Sou cadastrado? (S/N)");

                  String resposta = sc.next();

                  if (resposta.equalsIgnoreCase("S")) {

                  System.out.println("Digite o CPF:");

                  String cpf = sc.next();

                  Clientes clienteEncontrado = null;

                  for (Clientes c : clientes) {

                  if (c.getCpf().equals(cpf)) {
                    clienteEncontrado = c;
                    break;
                  } 

                 }

                  if (clienteEncontrado == null) {

                     System.out.println("Cliente não encontrado!");
                    System.out.println("Compra sem cadastro.");

                  } else {

                       System.out.println(
                          "Bem-vindo, " +
                            clienteEncontrado.getNome() + "!"
                  );

                }
              } else {
                System.out.println("Compra sem cadastro.");
              }

                compra.total = 0;

                String continuar = "s";


              while (continuar.equalsIgnoreCase("s")) {

                System.out.println("\n****************");
                System.out.println("===== PRODUTOS =====");
                System.out.println("****************");

                for (Produtos p : produtos) {
                   System.out.println(
                   p.getCodigo() + " - " +
                   p.getNome() + " | R$ " +
                   p.getPreco() + " | Estoque: " +
                   p.getEstoque()
                   );
                }
                System.out.println("====================");
                System.out.println("Digite o codigo do produto:");
          
                int codigo = sc.nextInt();
          
                Produtos produtoEscolhido = null;
          
                  for (Produtos p : produtos) {
                    if (p.getCodigo() == codigo) {
                      produtoEscolhido = p;
                      break;
                    }
                  }
            if (produtoEscolhido == null) {
              System.out.println("\nProduto não encontrado");

            } else {
              System.out.println("====================");
              System.out.println("Produto escolhido: " + produtoEscolhido.getNome());
              System.out.println("====================");
              System.out.println("Digite a quantidade");
                
                int quantidade = sc.nextInt();
                
                compra.realizarCompra(produtoEscolhido, quantidade);

                ArquivoProdutos.salvarProdutos(produtos);

                }

                System.out.println("Deseja continuar comprando? (s/n)");

                continuar = sc.next();
              }
              System.out.println("\n===================");
              System.out.println("TOTAL FINAL: R$ " + compra.total);
              System.out.println("===================");
              }

               else if (opcao == 4) {

                System.out.println("\n===== ESTOQUE =====");

                for (Produtos p : produtos) {

                  System.out.println(
                    p.getCodigo() + " - " +
                    p.getNome() +
                    " | Estoque: " +
                    p.getEstoque()
                  );
                }
              }
             else if (opcao == 0) {
                System.out.println("Sistema encerrado");
            } else {
              System.out.println("Opção inválida");
      }
    }
  }
}