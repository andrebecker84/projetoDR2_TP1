package infnet.andreDR2_TP1.exercicios;

/*
Código original do professor:

public class SistemaBiblioteca {
    private List livros;
    private List disponibilidade;

    public SistemaBiblioteca() {
        livros = new ArrayList<>();
        disponibilidade = new ArrayList<>();
    }

    public void adicionarLivro(String titulo) {
        livros.add(titulo);
        disponibilidade.add(true);
    }

    public void emprestarLivro(String titulo) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).equals(titulo) && disponibilidade.get(i)) {
                disponibilidade.set(i, false);
                System.out.println("Livro emprestado: " + titulo);
                return;
            }
        }
        System.out.println("Livro não disponível.");
    }

    public void devolverLivro(String titulo) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).equals(titulo)) {
                disponibilidade.set(i, true);
                System.out.println("Livro devolvido: " + titulo);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}

Problemas de separação de responsabilidades:
1. Classe única mistura conceito de Livro com gerenciamento de Biblioteca
2. Listas paralelas (livros e disponibilidade) - dados relacionados separados
3. System.out.println misturado com lógica de negócio
4. Estado do livro (disponível) não pertence ao conceito de Livro
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ex04 {

    // Classe Livro - representa o conceito de um livro
    public static class Livro {
        private final String titulo;
        private boolean disponivel;

        public Livro(String titulo) {
            this.titulo = titulo;
            this.disponivel = true;
        }

        public String getTitulo() {
            return titulo;
        }

        public boolean isDisponivel() {
            return disponivel;
        }

        public void emprestar() {
            this.disponivel = false;
        }

        public void devolver() {
            this.disponivel = true;
        }
    }

    // Classe Biblioteca - gerencia a coleção de livros
    public static class Biblioteca {
        private final List<Livro> acervo = new ArrayList<>();

        public void adicionarLivro(String titulo) {
            acervo.add(new Livro(titulo));
        }

        public Optional<Livro> buscarLivro(String titulo) {
            return acervo.stream()
                    .filter(livro -> livro.getTitulo().equals(titulo))
                    .findFirst();
        }

        public String emprestarLivro(String titulo) {
            Optional<Livro> livroOpt = buscarLivro(titulo);

            if (livroOpt.isEmpty()) {
                return "Livro não encontrado.";
            }

            Livro livro = livroOpt.get();
            if (!livro.isDisponivel()) {
                return "Livro não disponível.";
            }

            livro.emprestar();
            return "Livro emprestado: " + titulo;
        }

        public String devolverLivro(String titulo) {
            Optional<Livro> livroOpt = buscarLivro(titulo);

            if (livroOpt.isEmpty()) {
                return "Livro não encontrado.";
            }

            livroOpt.get().devolver();
            return "Livro devolvido: " + titulo;
        }

        public List<Livro> listarLivrosDisponiveis() {
            return acervo.stream()
                    .filter(Livro::isDisponivel)
                    .toList();
        }
    }

    private final Biblioteca biblioteca = new Biblioteca();

    public void adicionarLivro(String titulo) {
        biblioteca.adicionarLivro(titulo);
    }

    public String emprestar(String titulo) {
        return biblioteca.emprestarLivro(titulo);
    }

    public String devolver(String titulo) {
        return biblioteca.devolverLivro(titulo);
    }

    public void executar() {
        System.out.println("\n=== Exercício 04 - Sistema de Biblioteca Refatorado ===\n");

        adicionarLivro("Clean Code - Robert Martin");
        adicionarLivro("Design Patterns - Gang of Four");
        adicionarLivro("Refactoring - Martin Fowler");

        System.out.println(emprestar("Clean Code - Robert Martin"));
        System.out.println(emprestar("Clean Code - Robert Martin"));
        System.out.println(devolver("Clean Code - Robert Martin"));
        System.out.println(emprestar("Clean Code - Robert Martin"));

        System.out.println("\nLivros disponíveis:");
        biblioteca.listarLivrosDisponiveis().forEach(livro ->
                System.out.println("- " + livro.getTitulo())
        );
    }
}
