public class DAOTest {
    public static void main(String[] args) {
        DAO dao = new DAO();

        String sql = "INSERT INTO produto (nome) VALUES (?)";

        int idInserido = dao.inserir(sql, "Miquiles");

        System.out.println(idInserido);
    }
}
