import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
    public static void main(String[] args) throws SQLException {
        Connection conexao = CriarConexao.getConexao();

        String sql = "CREATE TABLE produto (" +
                "id int auto_increment primary key, " +
                "nome varchar(50) not null " +
                ")";

        Statement stmt = conexao.createStatement();
        stmt.execute(sql);

        System.out.println("Tabela criada com sucesso");
        conexao.close();
    }
}
