package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Item;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class UmPraMuitos1 {
    public static void main(String[] args) {

        DAO<Object> dao = new DAO<>();
        Pedido pedido = new Pedido();
        Item produto = new Item("Microondas", 526.55);
        ItemPedido item = new ItemPedido(pedido,produto,2);


        dao.abrirTransacao()
                .incluir(produto)
                .incluir(pedido)
                .incluir(item)
                .fecharTransacao()
                .fecharDAO();

    }
}
