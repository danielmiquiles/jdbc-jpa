import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testes {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:mysql://localhost";
//        String usuario = "root";
//        String senha = "";
//
//        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Connection conexao = CriarConexao.getConexao();
        System.out.println("Sucesso");
        conexao.close();
    }
}
