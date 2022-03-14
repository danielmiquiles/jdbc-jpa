package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        Assento assento = new Assento("17A");
        Cliente cliente = new Cliente("Paulo", assento);

        DAO<Object> dao = new DAO<>();

        dao.abrirTransacao()
                .incluir(cliente)
                .incluir(assento)
                .fecharTransacao()
                .fecharDAO();
    }
}
