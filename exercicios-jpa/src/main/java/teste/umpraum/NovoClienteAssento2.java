package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento = new Assento("5B");
        Cliente cliente = new Cliente("Daniel", assento);

        DAO<Cliente> dao = new DAO<>();

        dao.incluirAtomico(cliente).fecharDAO();
    }
}
