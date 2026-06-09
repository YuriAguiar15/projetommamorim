public class Produtos {
  
  int codigo;
  String nome;
  double preco;
  int estoque;

  public Produtos(int codigo, String nome, double preco, int estoque) {
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
  }
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setNome(String nome) {
    this.nome = nome;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
