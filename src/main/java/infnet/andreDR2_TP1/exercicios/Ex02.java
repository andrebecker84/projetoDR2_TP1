package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class Processador {
    public void processar(String dado) {
        if (dado != null && !dado.isEmpty()) {
            if (dado.length() > 10) {
                System.out.println("Dado válido: " + dado);
            } else {
                System.out.println("Dado muito curto.");
            }
        } else {
            System.out.println("Dado inválido.");
        }
    }
}

Problemas identificados quanto aos 4 objetivos de código de alta qualidade:
a) Legibilidade: ifs aninhados dificultam leitura, guard clauses seriam melhores
b) Redução de duplicação: System.out.println repetido (violação DRY)
c) Facilidade de modificação: acoplado a console, difícil testar e reutilizar
d) Eficácia na comunicação: lógica espalhada dificulta entender o fluxo
*/

public class Ex02 {

    private static final int TAMANHO_MINIMO = 10;

    public String processar(String dado) {
        if (isInvalido(dado)) {
            return "Dado inválido.";
        }

        if (isMuitoCurto(dado)) {
            return "Dado muito curto.";
        }

        return formatarDadoValido(dado);
    }

    private boolean isInvalido(String dado) {
        return dado == null || dado.isEmpty();
    }

    private boolean isMuitoCurto(String dado) {
        return dado.length() <= TAMANHO_MINIMO;
    }

    private String formatarDadoValido(String dado) {
        return "Dado válido: " + dado;
    }

    public void executar() {
        System.out.println("\n=== Exercício 02 - Processador com Alta Qualidade ===\n");

        String[] testeDados = {
                null,
                "",
                "Curto",
                "Este é um dado válido e suficientemente longo"
        };

        for (String dado : testeDados) {
            String resultado = processar(dado);
            System.out.printf("Entrada: '%s' -> %s%n", dado, resultado);
        }
    }
}
