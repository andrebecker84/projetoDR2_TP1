package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class SistemaFinanceiro {
  private List contas;
  private List valores;
  public SistemaFinanceiro() {
    contas = new ArrayList<>();
    valores = new ArrayList<>();
  }

  public void adicionarConta(String conta, double valor) {
    contas.add(conta);
    valores.add(valor);
  }

  public void gerarRelatorio() {
    System.out.println("=== Relatório Financeiro ===");
    for (int i = 0; i < contas.size(); i++) {
      System.out.println(
          "Conta: " + contas.get(i) + " - Saldo: " + valores.get(i));
    }
  }

  public void processarPagamentos(double taxa) {
    for (int i = 0; i < valores.size(); i++) {
      valores.set(i, valores.get(i) - taxa);
    }
  }
}

Problemas estruturais identificados:
1. Listas paralelas (contas e valores) - violam coesão e SRP
2. Acoplamento a System.out.println - dificulta testes e reutilização
3. Falta de encapsulamento - dados de uma conta espalhados em duas listas
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01 {

    // Classe interna para representar uma conta financeira
    public static class ContaFinanceira {
        private final String titular;
        private double saldo;

        public ContaFinanceira(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public void descontarTaxa(double taxa) {
            this.saldo -= taxa;
        }

        public String formatarLinha() {
            return String.format("Conta: %s - Saldo: R$ %.2f", titular, saldo);
        }
    }

    private final List<ContaFinanceira> contas = new ArrayList<>();

    public void adicionarConta(String titular, double saldoInicial) {
        contas.add(new ContaFinanceira(titular, saldoInicial));
    }

    public List<String> gerarRelatorio() {
        return contas.stream()
                .map(ContaFinanceira::formatarLinha)
                .collect(Collectors.toList());
    }

    public void processarPagamentos(double taxa) {
        contas.forEach(conta -> conta.descontarTaxa(taxa));
    }

    public void executar() {
        System.out.println("\n=== Exercício 01 - Sistema Financeiro Refatorado ===\n");

        adicionarConta("João Silva", 1500.00);
        adicionarConta("Maria Santos", 2300.00);
        adicionarConta("Pedro Oliveira", 980.50);

        System.out.println("Relatório Inicial:");
        gerarRelatorio().forEach(System.out::println);

        System.out.println("\nProcessando taxa de R$ 50,00 em todas as contas...");
        processarPagamentos(50.00);

        System.out.println("\nRelatório Após Taxas:");
        gerarRelatorio().forEach(System.out::println);
    }
}
