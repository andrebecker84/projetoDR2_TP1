package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class CarrinhoDeCompras {
    private List produtos;
    private List precos;
    private List quantidades;

    public CarrinhoDeCompras() {
        produtos = new ArrayList<>();
        precos = new ArrayList<>();
        quantidades = new ArrayList<>();
    }

    public void adicionarProduto(String produto, double preco, int quantidade) {
        produtos.add(produto);
        precos.add(preco);
        quantidades.add(quantidade);
    }

    public void calcularTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += precos.get(i) * quantidades.get(i);
        }
        System.out.println("Total da compra: R$ " + total);
    }
}

Problemas estruturais:
1. Listas paralelas (produtos, precos, quantidades) - dificulta manutenção
2. Falta de coesão - dados de um item espalhados em 3 estruturas
3. Acoplamento ao System.out.println - não há separação entre lógica e apresentação
4. Viola SRP - classe faz cálculo E impressão
*/

import java.util.ArrayList;
import java.util.List;

public class Ex03 {

    // Camada de Modelo - representa um item do carrinho
    public static class ItemCarrinho {
        private final String nome;
        private final double precoUnitario;
        private final int quantidade;

        public ItemCarrinho(String nome, double precoUnitario, int quantidade) {
            this.nome = nome;
            this.precoUnitario = precoUnitario;
            this.quantidade = quantidade;
        }

        public double calcularSubtotal() {
            return precoUnitario * quantidade;
        }

        public String getNome() {
            return nome;
        }

        public double getPrecoUnitario() {
            return precoUnitario;
        }

        public int getQuantidade() {
            return quantidade;
        }
    }

    // Camada de Serviço - gerencia o carrinho e cálculos
    public static class ServicoCarrinho {
        private final List<ItemCarrinho> itens = new ArrayList<>();

        public void adicionarItem(String nome, double preco, int quantidade) {
            itens.add(new ItemCarrinho(nome, preco, quantidade));
        }

        public double calcularTotal() {
            return itens.stream()
                    .mapToDouble(ItemCarrinho::calcularSubtotal)
                    .sum();
        }

        public List<ItemCarrinho> getItens() {
            return new ArrayList<>(itens);
        }
    }

    // Camada de Interface - formatação sem acoplamento a saída específica
    public static class FormatadorCarrinho {
        public String formatarResumo(ServicoCarrinho carrinho) {
            return String.format("Total da compra: R$ %.2f", carrinho.calcularTotal());
        }

        public List<String> formatarItens(ServicoCarrinho carrinho) {
            List<String> linhas = new ArrayList<>();
            for (ItemCarrinho item : carrinho.getItens()) {
                linhas.add(formatarItem(item));
            }
            return linhas;
        }

        private String formatarItem(ItemCarrinho item) {
            return String.format("%dx %s - R$ %.2f (Subtotal: R$ %.2f)",
                    item.getQuantidade(),
                    item.getNome(),
                    item.getPrecoUnitario(),
                    item.calcularSubtotal());
        }
    }

    private final ServicoCarrinho servico = new ServicoCarrinho();
    private final FormatadorCarrinho formatador = new FormatadorCarrinho();

    public void adicionarItem(String nome, double preco, int quantidade) {
        servico.adicionarItem(nome, preco, quantidade);
    }

    public double calcularTotal() {
        return servico.calcularTotal();
    }

    public String obterResumo() {
        return formatador.formatarResumo(servico);
    }

    public void executar() {
        System.out.println("\n=== Exercício 03 - Carrinho de Compras Refatorado ===\n");

        adicionarItem("Notebook Dell", 3200.00, 1);
        adicionarItem("Mouse Logitech", 85.50, 2);
        adicionarItem("Teclado Mecânico", 450.00, 1);

        System.out.println("Itens no carrinho:");
        formatador.formatarItens(servico).forEach(System.out::println);

        System.out.println("\n" + obterResumo());
    }
}
