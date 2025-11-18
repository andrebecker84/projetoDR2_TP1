package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class Pedido {
    private int id;
    // Identificação do pedido private String descricao;
    // Descrição do pedido private double valor;
    // Valor do pedido
    // Construtor do pedido

    public Pedido(int id, String descricao, double valor) {
        this.id = id;                 // Define o ID do pedido
        this.descricao = descricao; // Define a descrição
        this.valor = valor;         // Define o valor
    }

    // Método que retorna o ID do pedido
    public int getId() {
        return id;
    }

    // Método que define um novo ID para o pedido
    public void setId(int id) {
        this.id = id;
    }
}

Refatoração: Remover comentários desnecessários, tornar código autoexplicativo
*/

public class Ex08 {

    private int id;
    private final String descricao;
    private final double valor;

    public Ex08(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    /**
     * Altera o ID do pedido.
     * Nota: Em sistemas reais, alterar IDs é desencorajado - este método existe apenas
     * para casos excepcionais de migração ou correção de dados.
     */
    public void alterarId(int novoId) {
        this.id = novoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void executar() {
        System.out.println("\n=== Exercício 08 - Pedido sem Comentários Desnecessários ===\n");

        Ex08 pedido = new Ex08(1001, "Notebook Dell Inspiron 15", 3500.00);
        System.out.printf("Pedido #%d: %s - R$ %.2f%n",
                pedido.getId(), pedido.getDescricao(), pedido.getValor());

        pedido.alterarId(2001);
        System.out.printf("Pedido após alteração de ID: #%d%n", pedido.getId());
    }
}
