public class CompraService {

  double total = 0;

  public void realizarCompra(Produtos produtos, int quantidade) {

    if (quantidade <= 0) {
      System.out.println("Quantidade inválida");
    }
    else if (quantidade > produtos.estoque) {
      System.out.println("Estoque insuficiente");
    } else {
       double subtotal = quantidade * produtos.preco;

      produtos.estoque = produtos.estoque - quantidade;

      total = total + subtotal;

      System.out.println("\n===== COMPRA REALIZADA =====");

      System.out.println("Produto: " + produtos.nome);
      System.out.println("Quantidade: " + quantidade);
      System.out.println("Subtotal: " + subtotal);
      System.out.println("Total atual: " + total);
      System.out.println("Novo estoque: " + produtos.estoque);
    }
  }
}
