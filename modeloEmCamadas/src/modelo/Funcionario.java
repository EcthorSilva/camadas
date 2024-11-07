package modelo;

public class Funcionario {
    private String nome;
    
    public Funcionario(String nome) {
        this.nome = nome;
    }

    public void atualizar(String mensagem) {
        System.out.println("Atendente " + nome + ": O pedido " + mensagem);
    }
}
