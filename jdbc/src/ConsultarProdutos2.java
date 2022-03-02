import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarProdutos2 {
    public static void main(String[] args) throws SQLException {
        Connection conexao = CriarConexao.getConexao();

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome que procura: ");
        String nome = scan.nextLine();

        String sql = "SELECT * from produto where nome LIKE ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, "%" + nome + "%");

        ResultSet result = stmt.executeQuery();

        List<Produto> produtos = new ArrayList<>();

        while (result.next()){
            int id = result.getInt("id");
            String nomeRecebido = result.getString("nome");

            produtos.add(new Produto(id, nomeRecebido));
        }

        for (Produto p : produtos) {
            System.out.println(p.getId() + " ==> " + p.getNome());
        }
    }
}
