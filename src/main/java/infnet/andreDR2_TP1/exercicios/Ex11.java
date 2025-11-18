package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class Servico {
    public void processar(String dado) {
        System.out.println("Processando: " + dado.toUpperCase());
    }
}

public class ValidadorCPF {
    public boolean validar(String cpf) {
        if (cpf.length() != 11) {
            return false;
        }
        return true;
    }
}

Problema: Retorno boolean não informa POR QUE a validação falhou
Refatoração: Implementar sinalização explícita com classe de resposta
*/

import java.util.ArrayList;
import java.util.List;

public class Ex11 {

    // Classe de resposta para sinalização explícita de erros
    public static class ResultadoValidacao {
        private final boolean valido;
        private final List<String> erros;

        private ResultadoValidacao(boolean valido, List<String> erros) {
            this.valido = valido;
            this.erros = new ArrayList<>(erros);
        }

        public static ResultadoValidacao sucesso() {
            return new ResultadoValidacao(true, List.of());
        }

        public static ResultadoValidacao falha(String... erros) {
            return new ResultadoValidacao(false, List.of(erros));
        }

        public boolean isValido() {
            return valido;
        }

        public List<String> getErros() {
            return new ArrayList<>(erros);
        }

        public String getMensagemErros() {
            return String.join("; ", erros);
        }
    }

    public String processar(String dado) {
        if (dado == null || dado.isBlank()) {
            throw new IllegalArgumentException("Dado não pode ser nulo ou vazio");
        }
        return "Processando: " + dado.toUpperCase();
    }

    public ResultadoValidacao validarCPF(String cpf) {
        if (cpf == null) {
            return ResultadoValidacao.falha("CPF não pode ser nulo");
        }

        if (cpf.isBlank()) {
            return ResultadoValidacao.falha("CPF não pode ser vazio");
        }

        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        if (cpfLimpo.length() != 11) {
            return ResultadoValidacao.falha(
                    String.format("CPF deve ter 11 dígitos. Recebido: %d", cpfLimpo.length())
            );
        }

        if (cpfLimpo.matches("(\\d)\\1{10}")) {
            return ResultadoValidacao.falha("CPF não pode ter todos os dígitos iguais");
        }

        return ResultadoValidacao.sucesso();
    }

    public void executar() {
        System.out.println("\n=== Exercício 11 - Sinalização Explícita de Erros ===\n");

        String[] cpfs = {
                "123.456.789-09",
                "12345678909",
                "123",
                "11111111111",
                null,
                ""
        };

        for (String cpf : cpfs) {
            ResultadoValidacao resultado = validarCPF(cpf);
            if (resultado.isValido()) {
                System.out.printf("CPF '%s': VÁLIDO%n", cpf);
            } else {
                System.out.printf("CPF '%s': INVÁLIDO - %s%n", cpf, resultado.getMensagemErros());
            }
        }

        System.out.println("\nProcessamento de dados:");
        System.out.println(processar("texto de exemplo"));
    }
}
