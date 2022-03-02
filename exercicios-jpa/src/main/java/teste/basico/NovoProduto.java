package teste.basico;

import infra.DAO;
import modelo.basico.Item;

public class NovoProduto {
    public static void main(String[] args) {
        DAO<Item> dao = new DAO<>(Item.class);

        Item item = new Item("notebook", 3500.00);

        dao.incluirAtomico(item);

        dao.fecharDAO();
    }
}
