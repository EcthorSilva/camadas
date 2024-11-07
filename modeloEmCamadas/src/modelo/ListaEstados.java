package modelo;

public enum ListaEstados implements Estado{
    PENDENTE {
        @Override
        public void proximoEstado(Pedido pedido) {
            pedido.setEstado(SEPARACAO);
            pedido.notificarObservadores("está em separação");
        }
    },
    SEPARACAO {
        @Override
        public void proximoEstado(Pedido pedido) {
            pedido.setEstado(ROTA);
            pedido.notificarObservadores("está em rota de entrega");
        }
    },
    ROTA {
        @Override
        public void proximoEstado(Pedido pedido) {
            pedido.setEstado(ENTREGUE);
            pedido.notificarObservadores("foi entregue!");
        }
    },
    ENTREGUE {
        @Override
        public void proximoEstado(Pedido pedido) {
            pedido.setEstado(null);
            System.out.println("Pedido já foi entregue!");
        }
    }
}
