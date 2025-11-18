package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

Problemas: Estados inválidos possíveis
- Depósitos negativos permitidos
- Saques superiores ao saldo permitidos
- Saldo inicial negativo permitido
*/

public class Ex07 {

    private final String titular;
    private double saldo;

    /**
     * Contrato explícito: titular não pode ser nulo/vazio e saldo inicial não pode ser negativo
     */
    public Ex07(String titular, double saldoInicial) {
        validarTitular(titular);
        validarSaldoNaoNegativo(saldoInicial);

        this.titular = titular;
        this.saldo = saldoInicial;
    }

    /**
     * Deposita um valor na conta
     * Contrato: valor deve ser positivo
     */
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo. Recebido: " + valor);
        }
        saldo += valor;
    }

    /**
     * Saca um valor da conta
     * Contrato: valor deve ser positivo e não pode exceder o saldo disponível
     */
    public void sacar(double valor) {
        validarValorPositivo(valor);
        validarSaldoSuficiente(valor);

        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    // Validações explícitas
    private void validarTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular não pode ser nulo ou vazio");
        }
    }

    private void validarSaldoNaoNegativo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo. Recebido: " + saldo);
        }
    }

    private void validarValorPositivo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo. Recebido: " + valor);
        }
    }

    private void validarSaldoSuficiente(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException(
                    String.format("Saldo insuficiente. Saldo: %.2f, Valor solicitado: %.2f", saldo, valor)
            );
        }
    }

    public void executar() {
        System.out.println("\n=== Exercício 07 - Conta Bancária com Validações ===\n");

        Ex07 conta = new Ex07("João Silva", 1000.00);
        System.out.printf("Conta criada para %s com saldo: R$ %.2f%n", conta.getTitular(), conta.getSaldo());

        conta.depositar(500.00);
        System.out.printf("Após depósito de R$ 500,00: R$ %.2f%n", conta.getSaldo());

        conta.sacar(300.00);
        System.out.printf("Após saque de R$ 300,00: R$ %.2f%n", conta.getSaldo());

        try {
            conta.sacar(2000.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        try {
            conta.depositar(-100.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}
