package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class Processador {
    public void executar(String v) { if (v != null) {
            System.out.println("Processando: " + v);
}}}

Refatoração: Corrigir indentação, espaçamento e separação de blocos
*/

public class Ex09 {

    public String processar(String valor) {
        if (valor == null) {
            return "Valor inválido.";
        }

        return "Processando: " + valor;
    }

    public void executar() {
        System.out.println("\n=== Exercício 09 - Código Organizado e Legível ===\n");

        String[] valores = {"Dados válidos", null, "Outro processamento"};

        for (String valor : valores) {
            String resultado = processar(valor);
            System.out.println(resultado);
        }
    }
}
