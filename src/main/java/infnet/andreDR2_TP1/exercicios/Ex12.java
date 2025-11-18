package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class Pagamento {
    public void processarPagamento(double valor, String metodo) {
        if (metodo.equals("cartao")) {
            System.out.println("Pagamento de R$" + valor + " realizado via cartão.");
        } else if (metodo.equals("boleto")) {
            System.out.println("Pagamento de R$" + valor + " realizado via boleto.");
        } else {
            System.out.println("Erro: Método de pagamento inválido.");
        }
    }
}

Refatoração: Criar exceções customizadas e tratamento estruturado de erros
*/

public class Ex12 {

    // Exceção customizada para método de pagamento inválido
    public static class MetodoPagamentoInvalidoException extends Exception {
        public MetodoPagamentoInvalidoException(String metodo) {
            super(String.format("Método de pagamento inválido: '%s'. Métodos aceitos: cartao, boleto, pix", metodo));
        }
    }

    // Exceção customizada para valor inválido
    public static class ValorInvalidoException extends Exception {
        public ValorInvalidoException(double valor) {
            super(String.format("Valor de pagamento inválido: R$ %.2f. Deve ser maior que zero.", valor));
        }
    }

    public enum MetodoPagamento {
        CARTAO("cartao"),
        BOLETO("boleto"),
        PIX("pix");

        private final String codigo;

        MetodoPagamento(String codigo) {
            this.codigo = codigo;
        }

        public static MetodoPagamento deCodigo(String codigo) throws MetodoPagamentoInvalidoException {
            if (codigo == null) {
                throw new MetodoPagamentoInvalidoException("null");
            }

            for (MetodoPagamento metodo : values()) {
                if (metodo.codigo.equalsIgnoreCase(codigo)) {
                    return metodo;
                }
            }

            throw new MetodoPagamentoInvalidoException(codigo);
        }

        public String getCodigo() {
            return codigo;
        }
    }

    public String processarPagamento(double valor, String metodoStr)
            throws ValorInvalidoException, MetodoPagamentoInvalidoException {

        if (valor <= 0) {
            throw new ValorInvalidoException(valor);
        }

        MetodoPagamento metodo = MetodoPagamento.deCodigo(metodoStr);

        return String.format("Pagamento de R$ %.2f realizado via %s.",
                valor, metodo.getCodigo());
    }

    public void executar() {
        System.out.println("\n=== Exercício 12 - Tratamento com Exceções Customizadas ===\n");

        // Caso de sucesso
        try {
            System.out.println(processarPagamento(150.00, "cartao"));
            System.out.println(processarPagamento(250.00, "boleto"));
            System.out.println(processarPagamento(350.00, "pix"));
        } catch (ValorInvalidoException | MetodoPagamentoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Caso de erro: método inválido
        try {
            System.out.println(processarPagamento(100.00, "dinheiro"));
        } catch (ValorInvalidoException e) {
            System.out.println("Erro de valor: " + e.getMessage());
        } catch (MetodoPagamentoInvalidoException e) {
            System.out.println("Erro de método: " + e.getMessage());
        }

        // Caso de erro: valor inválido
        try {
            System.out.println(processarPagamento(-50.00, "cartao"));
        } catch (ValorInvalidoException e) {
            System.out.println("Erro de valor: " + e.getMessage());
        } catch (MetodoPagamentoInvalidoException e) {
            System.out.println("Erro de método: " + e.getMessage());
        }
    }
}
