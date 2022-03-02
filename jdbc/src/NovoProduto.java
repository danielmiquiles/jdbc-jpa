import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NovoProduto {
    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = scan.nextLine();

        String sql = "INSERT INTO produto (nome) values (?)";

        Connection conexao = CriarConexao.getConexao();

        PreparedStatement stmt = conexao.prepareStatement(sql);
//        Statement stmt = conexao.createStatement();
        stmt.setString(1, nome);

        stmt.execute();

        System.out.println("Inserido com sucesso");
        scan.close();
    }
}
