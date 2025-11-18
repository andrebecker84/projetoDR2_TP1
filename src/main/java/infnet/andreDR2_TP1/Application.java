package infnet.andreDR2_TP1;

import infnet.andreDR2_TP1.exercicios.*;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    // Cores ANSI
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String DIM = "\u001B[2m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";

    // Constantes do menu
    private static final int PRIMEIRA_OPCAO = 1;
    private static final int ULTIMA_OPCAO = 12;
    private static final int OPCAO_SAIR = 0;
    private static final int TEMPO_PAUSA_MS = 1000;

    private static final String[][] OPCOES_MENU = {
        {" 1", "Ex01 - Sistema Financeiro"},
        {" 2", "Ex02 - Processador de Dados"},
        {" 3", "Ex03 - Carrinho de Compras"},
        {" 4", "Ex04 - Sistema de Biblioteca"},
        {" 5", "Ex05 - Sistema Bancário"},
        {" 6", "Ex06 - Relatório Financeiro"},
        {" 7", "Ex07 - Conta Bancária"},
        {" 8", "Ex08 - Pedido"},
        {" 9", "Ex09 - Processador"},
        {"10", "Ex10 - Serviço"},
        {"11", "Ex11 - Validador de CPF"},
        {"12", "Ex12 - Sistema de Pagamento"}
    };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            executarLoop(scanner);
        }
    }

    private static void executarLoop(Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            continuar = processarEntrada(scanner);
        }
    }

    private static boolean processarEntrada(Scanner scanner) {
        String entrada = scanner.nextLine().trim();

        if (!isNumero(entrada)) {
            exibirMensagemErro();
            pausar();
            return true;
        }

        return executarOpcao(Integer.parseInt(entrada));
    }

    private static boolean isNumero(String entrada) {
        return entrada.matches("\\d+");
    }

    private static void exibirMensagemErro() {
        System.out.printf("%n  ❌ Opção inválida. Digite um número de %d a %d.%n",
            OPCAO_SAIR, ULTIMA_OPCAO);
    }

    private static void exibirMenu() {
        limparTela();
        exibirCabecalho();
        exibirTabelaOpcoes();
        exibirPrompt();
    }

    private static void exibirCabecalho() {
        System.out.println(BOLD);
        System.out.println("╭──────────────────────────────────────╮");
        System.out.println("│  Clean Code & Qualidade de Software  │");
        System.out.println("│     DR2-TP1 · André Luis Becker      │");
        System.out.println("╰──────────────────────────────────────╯" + RESET);
    }

    private static void exibirTabelaOpcoes() {
        System.out.println("╭────┬─────────────────────────────────╮");
        System.out.println("│ N° │          Exercício              │");
        System.out.println("├────┼─────────────────────────────────┤");

        for (String[] opcao : OPCOES_MENU) {
            exibirLinhaOpcao(opcao[0], opcao[1]);
        }

        System.out.println("├────┼─────────────────────────────────┤");
        exibirOpcaoSair();
        System.out.println("╰────┴─────────────────────────────────╯");
    }

    private static void exibirLinhaOpcao(String numero, String descricao) {
        System.out.printf("│ %s%s%s │ %-32s│%n", CYAN, numero, RESET, descricao);
    }

    private static void exibirOpcaoSair() {
        System.out.printf("│ %s%2d%s │ %-32s│%n", GREEN, OPCAO_SAIR, RESET, "Sair");
    }

    private static void exibirPrompt() {
        System.out.print("Execute o exercício → ");
    }

    private static boolean executarOpcao(int opcao) {
        if (opcao == OPCAO_SAIR) {
            return exibirDespedida();
        }

        if (!isOpcaoValida(opcao)) {
            exibirMensagemErro();
            pausar();
            return true;
        }

        executarExercicio(opcao);
        aguardarContinuacao();
        return true;
    }

    private static boolean isOpcaoValida(int opcao) {
        return opcao >= PRIMEIRA_OPCAO && opcao <= ULTIMA_OPCAO;
    }

    private static boolean exibirDespedida() {
        limparTela();
        System.out.println("\n  Até logo! 👋\n");
        return false;
    }

    private static void executarExercicio(int opcao) {
        limparTela();
        exibirSeparador();

        try {
            switch (opcao) {
                case 1  -> new Ex01().executar();
                case 2  -> new Ex02().executar();
                case 3  -> new Ex03().executar();
                case 4  -> new Ex04().executar();
                case 5  -> new Ex05().executar();
                case 6  -> new Ex06().executar();
                case 7  -> new Ex07("João Silva", 1000.00).executar();
                case 8  -> new Ex08(1, "Produto Exemplo", 100.00).executar();
                case 9  -> new Ex09().executar();
                case 10 -> new Ex10().executar();
                case 11 -> new Ex11().executar();
                case 12 -> new Ex12().executar();
            }
        } catch (Exception e) {
            exibirMensagemErroExecucao(e);
        }

        exibirSeparador();
    }

    private static void exibirSeparador() {
        System.out.println(DIM + "─────────────────────────────────────────────────────────────────" + RESET);
    }

    private static void exibirMensagemErroExecucao(Exception e) {
        System.out.println("\n  ❌ Erro: " + e.getMessage());
    }

    private static void aguardarContinuacao() {
        System.out.print("\n  Pressione Enter para continuar...");
        limparBuffer();
    }

    private static void limparBuffer() {
        try {
            System.in.read();
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (IOException ignored) {
            // Buffer não limpo, mas aplicação continua funcionando
        }
    }

    private static void limparTela() {
        try {
            if (isWindows()) {
                limparTelaWindows();
            } else {
                limparTelaUnix();
            }
        } catch (Exception e) {
            limparTelaFallback();
        }
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").contains("Windows");
    }

    private static void limparTelaWindows() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    private static void limparTelaUnix() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void limparTelaFallback() {
        System.out.print("\n".repeat(50));
    }

    private static void pausar() {
        try {
            Thread.sleep(TEMPO_PAUSA_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}