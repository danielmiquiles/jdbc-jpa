package teste.basico;

import infra.DAO;
import modelo.basico.Item;

import java.util.List;

public class ObterProdutos {
    public static void main(String[] args) {
        DAO<Item> dao = new DAO<>(Item.class);

        List<Item> itens = dao.obterTodos();

        for (Item item: itens) {
            System.out.print("id ==> " + item.getId() + ", nome ==> " + item.getNome() + ", preço ==> " + item.getPreco());
            System.out.println();
        }

        dao.fecharDAO();
    }
}
