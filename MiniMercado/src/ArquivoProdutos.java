import java.io.*;
import java.util.ArrayList;

public class ArquivoProdutos {

    public static ArrayList<Produtos> carregarProdutos() {

        ArrayList<Produtos> produtos = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(
                new FileReader("dados/produtos.csv")
            );

            String linha;

            br.readLine();

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                int codigo = Integer.parseInt(dados[0]);
                String nome = dados[1];
                double preco = Double.parseDouble(dados[2]);
                int estoque = Integer.parseInt(dados[3]);

                produtos.add(
                    new Produtos(codigo, nome, preco, estoque)
                );
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Erro ao carregar produtos");

        }

        return produtos;
    }
    public static void salvarProdutos(ArrayList<Produtos> produtos) {
      
    }
}