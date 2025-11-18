package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class Servico {
    public void processar(String dado) {
        System.out.println("Processando: " + dado.toUpperCase());
    }
}

Problema: NullPointerException ao chamar toUpperCase() em dado nulo
Refatoração: Adicionar tratamento de erro adequado para evitar falhas silenciosas
*/

public class Ex10 {

    public String processar(String dado) {
        if (dado == null || dado.isBlank()) {
            throw new IllegalArgumentException("Dado não pode ser nulo ou vazio");
        }

        return "Processando: " + dado.toUpperCase();
    }

    public void executar() {
        System.out.println("\n=== Exercício 10 - Tratamento Claro de Erros ===\n");

        String[] dados = {"texto válido", "outro texto"};

        for (String dado : dados) {
            System.out.println(processar(dado));
        }

        try {
            processar(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        try {
            processar("");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}
