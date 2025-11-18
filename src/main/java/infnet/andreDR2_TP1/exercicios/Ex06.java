package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class RelatorioFinanceiro {
    public void gerarRelatorio(List clientes, List saldos) {
        System.out.println("=== Relatório Financeiro ===");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Cliente: " + clientes.get(i) + " - Saldo: R$ " + saldos.get(i));
        }
        System.out.println("===========================");
        System.out.println("Fim do Relatório");
    }
}

Refatoração: Dividir em métodos menores com responsabilidades claras
*/

import java.util.ArrayList;
import java.util.List;

public class Ex06 {

    private static final String SEPARADOR = "===========================";

    public List<String> gerarRelatorio(List<String> clientes, List<Double> saldos) {
        List<String> relatorio = new ArrayList<>();

        adicionarCabecalho(relatorio);
        adicionarLinhasClientes(relatorio, clientes, saldos);
        adicionarRodape(relatorio);

        return relatorio;
    }

    private void adicionarCabecalho(List<String> relatorio) {
        relatorio.add("=== Relatório Financeiro ===");
    }

    private void adicionarLinhasClientes(List<String> relatorio, List<String> clientes, List<Double> saldos) {
        for (int i = 0; i < clientes.size(); i++) {
            relatorio.add(formatarLinhaCliente(clientes.get(i), saldos.get(i)));
        }
    }

    private String formatarLinhaCliente(String cliente, Double saldo) {
        return String.format("Cliente: %s - Saldo: R$ %.2f", cliente, saldo);
    }

    private void adicionarRodape(List<String> relatorio) {
        relatorio.add(SEPARADOR);
        relatorio.add("Fim do Relatório");
    }

    public void executar() {
        System.out.println("\n=== Exercício 06 - Relatório Financeiro com Funções Pequenas ===\n");

        List<String> clientes = List.of("João Silva", "Maria Santos", "Pedro Oliveira");
        List<Double> saldos = List.of(1500.00, 2300.00, 980.50);

        List<String> relatorio = gerarRelatorio(clientes, saldos);
        relatorio.forEach(System.out::println);
    }
}
