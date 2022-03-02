import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas {
    public static void main(String[] args) throws SQLException {
        Connection conexao = CriarConexao.getConexao();

        String sql = "SELECT * from produto";
        Statement stmt = conexao.createStatement();

        ResultSet result = stmt.executeQuery(sql);

        List<Produto> produtos = new ArrayList<>();

        while (result.next()){
            int id = result.getInt("id");
            String nome = result.getString("nome");

            produtos.add(new Produto(id, nome));
        }

        for (Produto p : produtos) {
            System.out.println(p.getId() + " ==> " + p.getNome());
        }
    }
}
