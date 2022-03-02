import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    private Connection conexao;

    private Connection getConexao() {
        try {
            if(conexao != null && !conexao.isClosed()){
                return conexao;
            }
        } catch (SQLException e) {
        }

        conexao = CriarConexao.getConexao();
        return conexao;
    }

    public int inserir(String sql, Object...atributos){
        try {
            PreparedStatement stmt = getConexao().prepareStatement(
                    sql, PreparedStatement.RETURN_GENERATED_KEYS
            );

            addAtributos(stmt,atributos);

            if (stmt.executeUpdate() > 0){
                ResultSet r = stmt.getGeneratedKeys();
                if (r.next()){
                    return r.getInt(1);
                }
            }

            return -1;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    private void addAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {
        int index = 1;
        for (Object atributo: atributos){
            if (atributo instanceof String){
                stmt.setString(index, (String) atributo);
            } else if (atributo instanceof Integer){
                stmt.setInt(index, (Integer) atributo);
            }
            index++;
        }
    }

}
