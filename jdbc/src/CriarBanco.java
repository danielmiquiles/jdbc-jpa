import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:mysql://localhost";
//        String usuario = "root";
//        String senha = "";
//
//        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        Connection conexao = CriarConexao.getConexao();
        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS curso_jdbc");
        System.out.println("Sucesso");
        conexao.close();
    }

}
