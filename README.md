# TP1 • Clean Code e Boas Práticas

[![Infnet](https://img.shields.io/badge/Instituto_Infnet-blue)](https://www.infnet.edu.br/)
[![Eng._de_Software](https://img.shields.io/badge/Eng._de_Software-blue)](https://www.infnet.edu.br/cursos/graduacao/engenharia-de-software/)
[![DR2_Clean_Code](https://img.shields.io/badge/Disciplina-DR2_•_Clean_Code_e_Boas_Práticas-yellow)](https://www.infnet.edu.br/disciplinas/dr2-clean-code-e-boas-praticas/)
![Professor](https://img.shields.io/badge/Professor-Rafael_Bento_Cruz-yellow)
![Aluno](https://img.shields.io/badge/Aluno-Andr%C3%A9_Luis_Becker-yellow)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-@becker84-blue?style=plastic&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/becker84/)
[![GitHub](https://img.shields.io/badge/GitHub-@andrebecker84-181717?style=plastic&logo=github&logoColor=white)](https://github.com/andrebecker84)

---

## 📖 Sobre

Trabalho acadêmico de **Engenharia de Software** focado em **Clean Code** e **boas práticas de desenvolvimento**. 

- O projeto apresenta a refatoração sistemática de 12 códigos Java com problemas estruturais, aplicando princípios fundamentais de engenharia de software conforme estabelecido por Robert C. Martin.

> [!NOTE]
> O resultado são `12 exercícios`, todos refatorados com `46 testes` automatizados passando.

---

## 🎯 Objetivos

- ✅ **12 exercícios** refatorados de forma incremental
- ✅ **46 testes unitários** garantindo que tudo funciona
- ✅ **Aplicação de princípios SOLID, DRY, KISS, YAGNI, CQS**
- ✅ **Separação em camadas de abstração adequadas** (modelo, serviço, apresentação)
- ✅ Desenvolver **contratos explícitos** com validações robustas
- ✅ **Tratamento adequado de erros** com exceções customizadas
- ✅ **Código legível e limpo, modular e testável**

---

## 📊 Badges do Projeto

![Projeto](https://img.shields.io/badge/Projeto-projetoDR2__TP1-blue?style=plastic&logo=htmx&logoColor=white)
[![GitHub Repo](https://img.shields.io/badge/GitHub-Repository-181717?style=plastic&logo=github&logoColor=white)](https://github.com/andrebecker84/projetoDR2_TP1)
[![Last Commit](https://img.shields.io/github/last-commit/andrebecker84/projetoDR2_TP1?style=plastic)](https://github.com/andrebecker84/projetoDR2_TP1)
[![Repo Size](https://img.shields.io/github/repo-size/andrebecker84/projetoDR2_TP1?style=plastic)](https://github.com/andrebecker84/projetoDR2_TP1)
[![License](https://img.shields.io/github/license/andrebecker84/projetoDR2_TP1?style=plastic&logo=readme&logoColor=white)](LICENSE)

![Status](https://img.shields.io/badge/Status-Completo-success?style=plastic)
![Qualidade](https://img.shields.io/badge/Qualidade-A+-brightgreen?style=plastic)
[![Build](https://img.shields.io/github/actions/workflow/status/andrebecker84/projetoDR2_TP1/maven.yml?style=plastic&logo=github-actions&logoColor=white&branch=main)](https://github.com/andrebecker84/projetoDR2_TP1/actions)
[![Tests](https://raw.githubusercontent.com/andrebecker84/projetoDR2_TP1/main/.github/badges/tests.svg)](https://github.com/andrebecker84/projetoDR2_TP1/actions)
[![Coverage](https://raw.githubusercontent.com/andrebecker84/projetoDR2_TP1/main/.github/badges/coverage.svg)](https://github.com/andrebecker84/projetoDR2_TP1/actions)
[![Branches](https://img.shields.io/badge/Branches-1-blue?style=plastic&logo=git&logoColor=white)](https://github.com/andrebecker84/projetoDR2_TP1/branches)

---

## 🚀 Tecnologias utilizadas

| Tecnologia                                                                                                                                                                      |  Descrição                    |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------|
| [![Java](https://img.shields.io/badge/Java-21-ED8B00?style=plastic&logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) | Linguagem de programação      |
| [![Maven](https://img.shields.io/badge/Maven-3.11.0-C71A36?style=plastic&logo=apache-maven&logoColor=white)](https://maven.apache.org/)                                         | Gerenciamento de dependências |
| [![JUnit5](https://img.shields.io/badge/JUnit-5.10.0-25A162?style=plastic&logo=junit5&logoColor=white)](https://junit.org/junit5/)                                              | Framework de testes           |
| [![IntelliJ](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=plastic&logo=intellij-idea)](https://www.jetbrains.com/idea/)                                              | IDE recomendada               |

---

## ⚙️ Como executar

### Pré-requisitos
- **Java 21** ou superior ([Download](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html))
- **Maven 3.8+** ([Download](https://maven.apache.org/download.cgi))

### Compilar e testar
```bash
git clone https://github.com/andrebecker84/projetoDR2_TP1.git
cd projetoDR2_TP1
mvn clean compile # Compila o projeto (opcional)
mvn clean test
```
Resultado esperado: `BUILD SUCCESS - 46/46 testes passando`

### Executar a aplicação
```bash
mvn exec:java -Dexec.mainClass="infnet.andreDR2_TP1.Application"
```

---

## 📊 Estatísticas

```
📁 Total de Exercícios:     12 refatorados
✅ Testes Unitários:        46 (100% passing)
📄 Linhas de Código:        ~2500 (comentadas e documentadas)
🎯 Cobertura de Testes:     100%
📚 Princípios Aplicados:    SOLID, DRY, KISS, YAGNI, CQS
```

---

## 🗂️ Estrutura do Projeto

```
📁 projetoDR2_TP1/
│
├── 📄 README.md                               # Este arquivo (resumo GitHub)
├── 📄 pom.xml                                 # Configuração Maven
├── 📄 .gitignore                              # Exclusões GitHub
│
├── 📁 doc/                                    # Documentação
│   ├── 📄 DOCUMENTACAO_TP1.md                 # Documentação completa (70+ páginas)
│   └── 📁 img/                                # Imagens e diagramas utilizadas na documentação
│
└── 📁 src/
    ├── 📁 main/java/infnet/andreDR2_TP1/
    │   ├── 📄 Application.java                # Menu interativo
    │   └── 📁 exercicios/                     # 12 exercícios refatorados
    │       ├── 📄 Ex01.java                   # Sistema Financeiro
    │       ├── 📄 Ex02.java                   # Processador de Dados
    │       ├── 📄 Ex03.java                   # Carrinho de Compras
    │       ├── 📄 Ex04.java                   # Sistema de Biblioteca
    │       ├── 📄 Ex05.java                   # Sistema Bancário
    │       ├── 📄 Ex06.java                   # Relatório Financeiro
    │       ├── 📄 Ex07.java                   # Conta Bancária (Validações)
    │       ├── 📄 Ex08.java                   # Pedido (Comentários)
    │       ├── 📄 Ex09.java                   # Processador (Formatação)
    │       ├── 📄 Ex10.java                   # Serviço (Tratamento de Erros)
    │       ├── 📄 Ex11.java                   # Validador de CPF
    │       └── 📄 Ex12.java                   # Sistema de Pagamento com Exceções
    │
    └── 📁 test/java/infnet/andreDR2_TP1/
        └── 📁 exercicios/
            └── 📄 Exercicios01a12Tests.java   # 46 testes unitários ✅
```

---

## 🧼 Princípios de Clean Code Aplicados

### SOLID
- ✅`SRP` (`S`ingle Responsibility Principle) — cada classe tem uma responsabilidade
- ✅`OCP` (`O`pen/Closed Principle) — aberta para extensão, fechada para modificação
- ❌`LSP` (`L`iskov Substitution Principle) — subclasses podem substituir superclasses
- ❌`ISP` (`I`nterface Segregation Principle) — interfaces específicas são melhores que genéricas
- ✅`DIP` (`D`ependency Inversion Principle) — depende de abstrações, não implementações

### Outros
- ✅`DRY` (Don't Repeat Yourself) — não repita código
- ✅`KISS` (Keep It Simple, Stupid) — mantenha simples
- ✅`YAGNI` (You Aren't Gonna Need It) — não implemente o que não precisa
- ✅`CQS` (Command-Query Separation) — separe comandos de consultas

### Clean Code

- ✅ Nomes reveladores de intenção
- ✅ Funções pequenas e coesas
- ✅ Comentários apenas quando agregam valor
- ✅ Tratamento adequado de erros
- ✅ Testes automatizados
- ✅ Formatação consistente
- ✅ Abstrações em níveis apropriados

---

## 📚 Exercícios Implementados

>### `Ex01` Sistema Financeiro
>>**Objetivo:** Explicar importância da qualidade do código

- **Problemas Resolvidos:**
  - ❌ Listas paralelas →         ✅ Classe `ContaFinanceira`
  - ❌ Acoplamento a System.out → ✅ Retorna `List<String>`
  - ❌ Falta de encapsulamento →  ✅ Métodos encapsulados

>### `Ex02` Processador de Dados
>>**Objetivo:** Aplicar os 4 objetivos de código de qualidade

- **Melhorias:**
  - ✅ Legibilidade (guard clauses)
  - ✅ Redução de duplicação (DRY)
  - ✅ Facilidade de modificação (desacoplamento)
  - ✅ Eficácia na comunicação (nomes claros)

>### `Ex03` Carrinho de Compras
>>**Objetivo:** Camadas de abstração estratégicas

- **Arquitetura:**
  - 🏗️ **Modelo:**    `ItemCarrinho`
  - ⚙️ **Serviço:**   `ServicoCarrinho`
  - 🖥️ **Interface:** `FormatadorCarrinho`

>### `Ex04` Sistema de Biblioteca
>>**Objetivo:** Separação de responsabilidades

- **Solução:**
  - 📚 Classe `Livro` (entidade)
  - 🏢 Classe `Biblioteca` (gerenciador)
  - 🔍 Uso de `Optional<T>` para busca segura

>### `Ex05` Sistema Bancário
>>**Objetivo:** 3 camadas (Modelo, Serviço, Interface)

- **Implementação:**
  - 💳 `Conta` (modelo)
  - 🏦 `ServicoBancario` (regras de negócio)
  - 📋 `ResultadoTransferencia` (DTO)

>### `Ex06` Relatório Financeiro
>>**Objetivo:** Funções pequenas e coesas

- **Decomposição:**
  - `adicionarCabecalho()` - 1 linha
  - `adicionarLinhasClientes()` - 3 linhas
  - `formatarLinhaCliente()` - 1 linha
  - `adicionarRodape()` - 2 linhas

>### `Ex07` Conta Bancária
>>**Objetivo:** Contratos explícitos e validações

- **Validações:**
  - ✅ Titular não nulo/vazio
  - ✅ Saldo inicial >= 0
  - ✅ Depósitos positivos
  - ✅ Saques <= saldo

>### `Ex08` Pedido
>>**Objetivo:** Comentários claros sem redundâncias

- **Abordagem:**
  - ❌ Removidos comentários óbvios
  - ✅ Código autoexplicativo
  - ✅ Javadoc apenas onde agrega valor

>### `Ex09` Processador
>>**Objetivo:** Código organizado e legível

- **Melhorias:**
  - ✅ Indentação consistente (4 espaços)
  - ✅ Espaçamento adequado
  - ✅ Nomes significativos

>### `Ex10` Serviço
>>**Objetivo:** Tratamento robusto de erros

- **Implementação:**
  - ✅ Validação explícita
  - ✅ Exceções descritivas
  - ✅ Fail-fast

>### `Ex11` Validador de CPF
>>**Objetivo:** Sinalização explícita de erros

- **Solução:**
  - 📊 Classe `ResultadoValidacao`
  - 📋 Lista de erros detalhados
  - 🔍 Mensagens específicas

>### `Ex12` Sistema de Pagamento
>>**Objetivo:** Exceções customizadas

- **Exceções:**
  - ⚠️ `MetodoPagamentoInvalidoException`
  - ⚠️ `ValorInvalidoException`
  - 🔒 Enum `MetodoPagamento` (type-safe)

---

## 🧪 Testes

### **Execute com:**
```bash
mvn test
```

### **Resultado esperado:**

> [!TIP]
> ```
> [INFO] Tests run: 46, Failures: 0, Errors: 0, Skipped: 0
> [INFO] BUILD SUCCESS
> ```

---

### **Resumo dos Testes:**
>>O projeto possui **46 testes unitários** cobrindo todos os exercícios:
>- ✅ Casos de sucesso
>- ✅ Validações
>- ✅ Exceções
>- ✅ Comportamentos específicos de cada exercício

| Exercício | Testes | Status     |
|-----------|--------|------------|
| Ex01      | 3      | ✅          |
| Ex02      | 4      | ✅          |
| Ex03      | 3      | ✅          |
| Ex04      | 4      | ✅          |
| Ex05      | 4      | ✅          |
| Ex06      | 2      | ✅          |
| Ex07      | 6      | ✅          |
| Ex08      | 3      | ✅          |
| Ex09      | 3      | ✅          |
| Ex10      | 4      | ✅          |
| Ex11      | 4      | ✅          |
| Ex12      | 5      | ✅          |
| **TOTAL** | **46** | **✅ 100%** |

---

## 📄 Documentação

1. **[DOCUMENTACAO_TP1.md](doc/DOCUMENTACAO_TP1.md)**
   - **Documentação completa do trabalho com:**
       - ✅ Análise detalhada de cada exercício
       - ✅ Fundamentação teórica completa
       - ✅ Código original vs refatorado
       - ✅ Justificativas de todas as decisões

---

## 📚 Referências

### Livros:
- Martin, Robert C. **Código Limpo** (2011)
- Bloch, Joshua. **Java Efetivo** (2018)
- Fowler, Martin. **Refatoração** (2018)

### Documentação Oficial:
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Maven Documentation](https://maven.apache.org/guides/)

### Repositórios Referência:
- [SILVA DA GLORIA, Leonardo. spaceXMissions - Metodologia de Testes (2025)](https://github.com/leoinfnet/spaceXMissions)

---

## ⚖️ Licença

> [!WARNING]
> Este projeto é parte de um trabalho acadêmico e destina-se exclusivamente para fins educacionais.
>
> ⚖️ Licenciado sob a [MIT License](LICENSE).



---

## 🙏 Agradecimentos

- **Prof. Rafael Bento Cruz** - Orientação e revisão técnica
- **Instituto Infnet** - Infraestrutura e suporte acadêmico
- **Robert C. Martin** - Inspiração através de "Clean Code"

---

<div align="center">

**Desenvolvido com 🤘 por [André Luis Becker](https://github.com/andrebecker84)**

</div>
