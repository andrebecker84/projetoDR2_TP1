package infnet.andreDR2_TP1.exercicios;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Exercicios01a12Tests {

    // ===== Ex01 Tests =====
    @Test
    void testEx01_AdicionarConta() {
        Ex01 sistema = new Ex01();
        sistema.adicionarConta("João Silva", 1000.00);

        List<String> relatorio = sistema.gerarRelatorio();
        assertEquals(1, relatorio.size());
        assertTrue(relatorio.get(0).contains("João Silva"));
        assertTrue(relatorio.get(0).contains("1000"));
    }

    @Test
    void testEx01_ProcessarPagamentos() {
        Ex01 sistema = new Ex01();
        sistema.adicionarConta("João Silva", 1000.00);
        sistema.processarPagamentos(100.00);

        List<String> relatorio = sistema.gerarRelatorio();
        assertTrue(relatorio.get(0).contains("900"));
    }

    @Test
    void testEx01_Executar() {
        assertDoesNotThrow(() -> new Ex01().executar());
    }

    // ===== Ex02 Tests =====
    @Test
    void testEx02_DadoValido() {
        Ex02 processador = new Ex02();
        String resultado = processador.processar("Este é um dado válido e longo");
        assertTrue(resultado.startsWith("Dado válido:"));
    }

    @Test
    void testEx02_DadoMuitoCurto() {
        Ex02 processador = new Ex02();
        String resultado = processador.processar("Curto");
        assertEquals("Dado muito curto.", resultado);
    }

    @Test
    void testEx02_DadoNulo() {
        Ex02 processador = new Ex02();
        String resultado = processador.processar(null);
        assertEquals("Dado inválido.", resultado);
    }

    @Test
    void testEx02_Executar() {
        assertDoesNotThrow(() -> new Ex02().executar());
    }

    // ===== Ex03 Tests =====
    @Test
    void testEx03_AdicionarItem() {
        Ex03 carrinho = new Ex03();
        carrinho.adicionarItem("Produto A", 10.00, 2);
        assertEquals(20.00, carrinho.calcularTotal(), 0.01);
    }

    @Test
    void testEx03_CalcularTotalMultiplosItens() {
        Ex03 carrinho = new Ex03();
        carrinho.adicionarItem("Produto A", 10.00, 2);
        carrinho.adicionarItem("Produto B", 5.00, 3);
        assertEquals(35.00, carrinho.calcularTotal(), 0.01);
    }

    @Test
    void testEx03_Executar() {
        assertDoesNotThrow(() -> new Ex03().executar());
    }

    // ===== Ex04 Tests =====
    @Test
    void testEx04_AdicionarLivro() {
        Ex04 biblioteca = new Ex04();
        biblioteca.adicionarLivro("Clean Code");
        assertEquals("Livro emprestado: Clean Code", biblioteca.emprestar("Clean Code"));
    }

    @Test
    void testEx04_EmprestarLivroJaEmprestado() {
        Ex04 biblioteca = new Ex04();
        biblioteca.adicionarLivro("Clean Code");
        biblioteca.emprestar("Clean Code");
        assertEquals("Livro não disponível.", biblioteca.emprestar("Clean Code"));
    }

    @Test
    void testEx04_DevolverLivro() {
        Ex04 biblioteca = new Ex04();
        biblioteca.adicionarLivro("Clean Code");
        biblioteca.emprestar("Clean Code");
        assertEquals("Livro devolvido: Clean Code", biblioteca.devolver("Clean Code"));
    }

    @Test
    void testEx04_Executar() {
        assertDoesNotThrow(() -> new Ex04().executar());
    }

    // ===== Ex05 Tests =====
    @Test
    void testEx05_CriarConta() {
        Ex05 banco = new Ex05();
        banco.criarConta("João", 1000.00);
        assertEquals(1000.00, banco.consultarSaldo("João"), 0.01);
    }

    @Test
    void testEx05_TransferenciaComSucesso() {
        Ex05 banco = new Ex05();
        banco.criarConta("João", 1000.00);
        banco.criarConta("Maria", 500.00);

        String resultado = banco.transferir("João", "Maria", 200.00);
        assertEquals("Transferência realizada com sucesso.", resultado);
        assertEquals(800.00, banco.consultarSaldo("João"), 0.01);
        assertEquals(700.00, banco.consultarSaldo("Maria"), 0.01);
    }

    @Test
    void testEx05_TransferenciaSaldoInsuficiente() {
        Ex05 banco = new Ex05();
        banco.criarConta("João", 100.00);
        banco.criarConta("Maria", 500.00);

        String resultado = banco.transferir("João", "Maria", 200.00);
        assertEquals("Saldo insuficiente.", resultado);
    }

    @Test
    void testEx05_Executar() {
        assertDoesNotThrow(() -> new Ex05().executar());
    }

    // ===== Ex06 Tests =====
    @Test
    void testEx06_GerarRelatorio() {
        Ex06 relatorio = new Ex06();
        List<String> clientes = List.of("João", "Maria");
        List<Double> saldos = List.of(1000.00, 2000.00);

        List<String> resultado = relatorio.gerarRelatorio(clientes, saldos);
        assertTrue(resultado.size() >= 4); // Cabeçalho + 2 linhas + rodapé
    }

    @Test
    void testEx06_Executar() {
        assertDoesNotThrow(() -> new Ex06().executar());
    }

    // ===== Ex07 Tests =====
    @Test
    void testEx07_CriarContaValida() {
        assertDoesNotThrow(() -> new Ex07("João", 1000.00));
    }

    @Test
    void testEx07_CriarContaSaldoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Ex07("João", -100.00));
    }

    @Test
    void testEx07_DepositarValorPositivo() {
        Ex07 conta = new Ex07("João", 1000.00);
        conta.depositar(500.00);
        assertEquals(1500.00, conta.getSaldo(), 0.01);
    }

    @Test
    void testEx07_DepositarValorNegativo() {
        Ex07 conta = new Ex07("João", 1000.00);
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(-100.00));
    }

    @Test
    void testEx07_SacarComSaldoSuficiente() {
        Ex07 conta = new Ex07("João", 1000.00);
        conta.sacar(300.00);
        assertEquals(700.00, conta.getSaldo(), 0.01);
    }

    @Test
    void testEx07_SacarSaldoInsuficiente() {
        Ex07 conta = new Ex07("João", 100.00);
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(200.00));
    }

    @Test
    void testEx07_Executar() {
        assertDoesNotThrow(() -> new Ex07("João", 1000.00).executar());
    }

    // ===== Ex08 Tests =====
    @Test
    void testEx08_CriarPedido() {
        Ex08 pedido = new Ex08(1, "Produto", 100.00);
        assertEquals(1, pedido.getId());
        assertEquals("Produto", pedido.getDescricao());
        assertEquals(100.00, pedido.getValor(), 0.01);
    }

    @Test
    void testEx08_AlterarId() {
        Ex08 pedido = new Ex08(1, "Produto", 100.00);
        pedido.alterarId(2);
        assertEquals(2, pedido.getId());
    }

    @Test
    void testEx08_Executar() {
        assertDoesNotThrow(() -> new Ex08(1, "Produto", 100.00).executar());
    }

    // ===== Ex09 Tests =====
    @Test
    void testEx09_ProcessarValorValido() {
        Ex09 processador = new Ex09();
        String resultado = processador.processar("Teste");
        assertEquals("Processando: Teste", resultado);
    }

    @Test
    void testEx09_ProcessarValorNulo() {
        Ex09 processador = new Ex09();
        String resultado = processador.processar(null);
        assertEquals("Valor inválido.", resultado);
    }

    @Test
    void testEx09_Executar() {
        assertDoesNotThrow(() -> new Ex09().executar());
    }

    // ===== Ex10 Tests =====
    @Test
    void testEx10_ProcessarDadoValido() {
        Ex10 servico = new Ex10();
        String resultado = servico.processar("teste");
        assertEquals("Processando: TESTE", resultado);
    }

    @Test
    void testEx10_ProcessarDadoNulo() {
        Ex10 servico = new Ex10();
        assertThrows(IllegalArgumentException.class, () -> servico.processar(null));
    }

    @Test
    void testEx10_ProcessarDadoVazio() {
        Ex10 servico = new Ex10();
        assertThrows(IllegalArgumentException.class, () -> servico.processar(""));
    }

    @Test
    void testEx10_Executar() {
        assertDoesNotThrow(() -> new Ex10().executar());
    }

    // ===== Ex11 Tests =====
    @Test
    void testEx11_ValidarCPFValido() {
        Ex11 validador = new Ex11();
        Ex11.ResultadoValidacao resultado = validador.validarCPF("12345678909");
        assertTrue(resultado.isValido());
    }

    @Test
    void testEx11_ValidarCPFInvalido() {
        Ex11 validador = new Ex11();
        Ex11.ResultadoValidacao resultado = validador.validarCPF("123");
        assertFalse(resultado.isValido());
        assertFalse(resultado.getErros().isEmpty());
    }

    @Test
    void testEx11_ValidarCPFNulo() {
        Ex11 validador = new Ex11();
        Ex11.ResultadoValidacao resultado = validador.validarCPF(null);
        assertFalse(resultado.isValido());
    }

    @Test
    void testEx11_Executar() {
        assertDoesNotThrow(() -> new Ex11().executar());
    }

    // ===== Ex12 Tests =====
    @Test
    void testEx12_ProcessarPagamentoCartao() throws Exception {
        Ex12 pagamento = new Ex12();
        String resultado = pagamento.processarPagamento(100.00, "cartao");
        assertTrue(resultado.contains("cartao"));
    }

    @Test
    void testEx12_ProcessarPagamentoBoleto() throws Exception {
        Ex12 pagamento = new Ex12();
        String resultado = pagamento.processarPagamento(100.00, "boleto");
        assertTrue(resultado.contains("boleto"));
    }

    @Test
    void testEx12_ProcessarPagamentoMetodoInvalido() {
        Ex12 pagamento = new Ex12();
        assertThrows(Ex12.MetodoPagamentoInvalidoException.class,
                () -> pagamento.processarPagamento(100.00, "dinheiro"));
    }

    @Test
    void testEx12_ProcessarPagamentoValorInvalido() {
        Ex12 pagamento = new Ex12();
        assertThrows(Ex12.ValorInvalidoException.class,
                () -> pagamento.processarPagamento(-100.00, "cartao"));
    }

    @Test
    void testEx12_Executar() {
        assertDoesNotThrow(() -> new Ex12().executar());
    }
}