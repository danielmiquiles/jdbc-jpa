import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirProduto {
    public static void main(String[] args) throws SQLException {
        Connection conexao = CriarConexao.getConexao();
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o código: ");
        String id = scan.nextLine();

        String select = "SELECT * FROM produto WHERE id = ?";
        String delete = "DELETE FROM produto WHERE id = ?";

        PreparedStatement stmt = conexao.prepareStatement(select);
        stmt.setString(1, id);

        ResultSet r = stmt.executeQuery();

        if(r.next()){
            stmt = conexao.prepareStatement(delete);
            stmt.setString(1, id);

            stmt.execute();

            System.out.println("Deletado com sucesso");
        } else {
            System.out.println("O item não existe");
        }
        conexao.close();
        scan.close();
    }
}
