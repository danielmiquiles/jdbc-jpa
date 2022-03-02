import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterarProduto {
    public static void main(String[] args) throws SQLException {
        Connection conexao = CriarConexao.getConexao();
        Scanner scan = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();

        System.out.println("Digite o id desejado: ");
        String id = scan.nextLine();

        String select = "SELECT * FROM produto WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(select);

        stmt.setString(1, id);
        ResultSet result = stmt.executeQuery();

        if (result.next()){
            produtos.add(new Produto(result.getInt("id"), result.getString("nome")));
            System.out.println("Digite o novo nome desejado: ");
            String novoNome = scan.nextLine();

            String update = "UPDATE produto set nome = ? WHERE id = ?";
            stmt = conexao.prepareStatement(update);

            stmt.setString(1, novoNome);
            stmt.setString(2, id);

            stmt.execute();
        } else {
            System.out.println("Pessoa não encontrada");
        }
    }
}
