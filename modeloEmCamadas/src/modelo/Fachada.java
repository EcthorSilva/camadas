package modelo;

import java.util.ArrayList;
import java.util.List;

public class Fachada {

    // adicionando itens
    private List<String> lista = new ArrayList<>();
    private Pedido pedido;

    public boolean temPedido() {
        return pedido != null;
    }
    public void adicionarItem(String item) {
        lista.add(item);
    }

    // realizando um pedido
    public void realizarPedido() {
        if (!lista.isEmpty()) {
            pedido = new Pedido(lista);
        } else {
            System.out.println("Não é possível realizar um pedido sem itens.");
        }
    }

    // Observadores do pedido
    public void adicionarObservadores(Observadores observadores){
        // anexando observadores ao pedido
        if (temPedido()){
            pedido.registrarObservadores(observadores);
        } else {
            System.out.println("Não há pedidos");
        }
    }

    // Ciclo de vida do pedido
    public void alterarEstadoPedido(){
        if (pedido.temObservadores()){
            pedido.avancarEstado();
        } else {
            System.out.println("Não há observadores para notificar");
        }
    }

    public void exibirPedido(){
        if (temPedido()){
            System.out.println("Detalhes do pedido:");
            System.out.println("Estado inicial do pedido" + pedido);
        } else {
            System.out.println("Não há pedidos");
        }
    }
}
