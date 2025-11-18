package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class SistemaBancario {
    private List contas;
    private List saldos;

    public SistemaBancario() {
        contas = new ArrayList<>();
        saldos = new ArrayList<>();
    }

    public void criarConta(String titular, double saldoInicial) {
        contas.add(titular);
        saldos.add(saldoInicial);
    }

    public void transferir(String origem, String destino, double valor) {
        int indexOrigem = contas.indexOf(origem);
        int indexDestino = contas.indexOf(destino);
        if (indexOrigem != -1 && indexDestino != -1 && saldos.get(indexOrigem) >= valor) {
            saldos.set(indexOrigem, saldos.get(indexOrigem) - valor);
            saldos.set(indexDestino, saldos.get(indexDestino) + valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Erro na transferência.");
        }
    }
}

Refatoração: Separar em camadas distintas (Modelo, Serviço e Interface)
*/

import java.util.HashMap;
import java.util.Map;

public class Ex05 {

    // CAMADA DE MODELO - Representa uma conta bancária
    public static class Conta {
        private final String titular;
        private double saldo;

        public Conta(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public void debitar(double valor) {
            this.saldo -= valor;
        }

        public void creditar(double valor) {
            this.saldo += valor;
        }

        public boolean temSaldoSuficiente(double valor) {
            return this.saldo >= valor;
        }
    }

    // CAMADA DE SERVIÇO - Lógica de negócio
    public static class ServicoBancario {
        private final Map<String, Conta> contas = new HashMap<>();

        public void criarConta(String titular, double saldoInicial) {
            contas.put(titular, new Conta(titular, saldoInicial));
        }

        public ResultadoTransferencia transferir(String origemTitular, String destinoTitular, double valor) {
            Conta origem = contas.get(origemTitular);
            Conta destino = contas.get(destinoTitular);

            if (origem == null || destino == null) {
                return new ResultadoTransferencia(false, "Conta inexistente.");
            }

            if (!origem.temSaldoSuficiente(valor)) {
                return new ResultadoTransferencia(false, "Saldo insuficiente.");
            }

            origem.debitar(valor);
            destino.creditar(valor);

            return new ResultadoTransferencia(true, "Transferência realizada com sucesso.");
        }

        public double consultarSaldo(String titular) {
            Conta conta = contas.get(titular);
            return conta != null ? conta.getSaldo() : 0.0;
        }
    }

    // CAMADA DE INTERFACE - Resultado da operação
    public static class ResultadoTransferencia {
        private final boolean sucesso;
        private final String mensagem;

        public ResultadoTransferencia(boolean sucesso, String mensagem) {
            this.sucesso = sucesso;
            this.mensagem = mensagem;
        }

        public boolean isSucesso() {
            return sucesso;
        }

        public String getMensagem() {
            return mensagem;
        }
    }

    private final ServicoBancario servico = new ServicoBancario();

    public void criarConta(String titular, double saldoInicial) {
        servico.criarConta(titular, saldoInicial);
    }

    public String transferir(String origem, String destino, double valor) {
        ResultadoTransferencia resultado = servico.transferir(origem, destino, valor);
        return resultado.getMensagem();
    }

    public double consultarSaldo(String titular) {
        return servico.consultarSaldo(titular);
    }

    public void executar() {
        System.out.println("\n=== Exercício 05 - Sistema Bancário com Camadas ===\n");

        criarConta("João Silva", 1000.00);
        criarConta("Maria Santos", 500.00);

        System.out.println("Saldos iniciais:");
        System.out.printf("João: R$ %.2f%n", consultarSaldo("João Silva"));
        System.out.printf("Maria: R$ %.2f%n", consultarSaldo("Maria Santos"));

        System.out.println("\nTransferindo R$ 200,00 de João para Maria...");
        System.out.println(transferir("João Silva", "Maria Santos", 200.00));

        System.out.println("\nSaldos após transferência:");
        System.out.printf("João: R$ %.2f%n", consultarSaldo("João Silva"));
        System.out.printf("Maria: R$ %.2f%n", consultarSaldo("Maria Santos"));

        System.out.println("\nTentando transferir R$ 1000,00 de João para Maria...");
        System.out.println(transferir("João Silva", "Maria Santos", 1000.00));
    }
}
