import java.io.*;
import java.util.ArrayList;

public class ArquivoClientes {

    public static ArrayList<Clientes> carregarClientes() {

        ArrayList<Clientes> clientes = new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(
                new FileReader("dados/clientes.csv")
            );

            String linha;

            br.readLine();

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");

                String cpf = dados[0];
                String nome = dados[1];
                String telefone = dados[2];
                String email = dados[3];

                clientes.add(
                    new Clientes(cpf, nome, telefone, email)
                );
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Erro ao carregar clientes");
        }
        return clientes;
    }
    public static void salvarClientes(ArrayList<Clientes> clientes) {

        try {
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("dados/clientes.csv")
            );

            bw.write("cpf;nome;telefone;email");
            bw.newLine();

            for (Clientes c : clientes) {

                bw.write(
                    c.getCpf() + ";" +
                    c.getNome() + ";" +
                    c.getTelefone() + ";" +
                    c.getEmail()
                );
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar clientes");
        }
    }
}