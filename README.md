# 🛒 Sistema de Gestão de Pedidos — E-commerce

> Projeto acadêmico desenvolvido na Unidade Curricular **Desenvolvimento Back-end**  
> Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas — Turma CSTADS601  
> Faculdade de Tecnologia SENAI "Antonio Adolpho Lobbe"

---

## 👥 Equipe / Squad

| Nome | Papel |
|---|---|
| **Diogo Antonio Ferrante** | Desenvolvimento |
| **Ana Beatriz Viotto** | Desenvolvimento |
| **Breno Xavier** | Desenvolvimento |

---

## 📋 Sobre o projeto

O **ecommerce-pedidos-techtrio** é um sistema de gestão de pedidos desenvolvido como projeto acadêmico para simular o funcionamento de um e-commerce.

O projeto foi desenvolvido de forma incremental durante as aulas, aplicando conceitos de **Programação Orientada a Objetos**, boas práticas de desenvolvimento, controle de versões, tratamento de exceções e testes automatizados.

O sistema possui funcionalidades relacionadas a produtos, clientes, pedidos, itens de pedido, estoque e processamento de pagamentos.

---

## 🎯 Objetivo

O principal objetivo é desenvolver um sistema de pedidos aplicando na prática os conceitos estudados durante a Unidade Curricular.

Entre os principais objetivos estão:

- Desenvolver um domínio utilizando Programação Orientada a Objetos.
- Aplicar encapsulamento, herança, abstração e polimorfismo.
- Criar relacionamentos entre as classes.
- Implementar regras de negócio.
- Utilizar exceções para tratar situações inválidas.
- Criar testes automatizados.
- Trabalhar com Git e GitHub.
- Utilizar branches e Pull Requests.
- Evoluir futuramente o projeto para persistência, API REST e CI/CD.

---

# 🚀 Funcionalidades

## 📦 Produtos

O sistema permite cadastrar e gerenciar produtos contendo:

- Código
- Nome
- Preço
- Quantidade em estoque

Também existem validações para impedir:

- Código inválido.
- Nome vazio ou inválido.
- Preço inválido.
- Estoque negativo.
- Cadastro de produtos duplicados.

O sistema também realiza o controle do estoque durante a criação dos pedidos.

---

## 👤 Clientes

Os clientes possuem informações como:

- Nome
- Documento
- E-mail
- Telefone
- Endereço

O sistema realiza validações dos dados informados e permite localizar clientes através do documento.

Também existem regras para evitar o cadastro de clientes duplicados.

---

## 🛒 Pedidos

Um pedido possui:

- Número
- Cliente
- Data
- Situação
- Itens
- Forma de pagamento

Um pedido começa com a situação:

**ABERTO**

Após um pagamento aprovado, sua situação passa para:

**PAGO**

O sistema também impede determinadas operações quando o pedido já foi pago.

---

## 🧾 Itens do pedido

Cada item do pedido possui:

- Produto
- Quantidade
- Preço

O subtotal do item é calculado utilizando:

**Subtotal = Preço × Quantidade**

O valor total do pedido é calculado com base nos itens adicionados.

---

# 💳 Formas de pagamento

O sistema possui diferentes formas de pagamento utilizando **abstração, herança e polimorfismo**.

Atualmente são utilizadas:

- 💳 Cartão de Crédito
- 🔑 Pix
- 🧾 Boleto
- 💵 Dinheiro

Existe uma classe abstrata responsável pelas características comuns das formas de pagamento e uma interface responsável pelo processamento dos pagamentos.

### 💳 Cartão de Crédito

O sistema simula o processamento de pagamentos com cartão, incluindo:

- Número do cartão
- Titular
- Bandeira
- Quantidade de parcelas
- Valor

Também existe uma simulação de cartão recusado para testar o tratamento de exceções.

### 🔑 Pix

O Pix utiliza uma chave para realizar o pagamento.

Quando o pagamento é aprovado, o pedido passa para a situação **PAGO**.

### 🧾 Boleto

O boleto simula a geração de uma cobrança.

Como o pagamento não é aprovado imediatamente, o pedido permanece **ABERTO**.

### 💵 Dinheiro

O pagamento em dinheiro considera o valor recebido e calcula o troco quando necessário.

---

# ⚠️ Tratamento de exceções

O projeto possui uma hierarquia de exceções própria para representar situações relacionadas às regras do negócio.

A exceção base é:

`ECommerceException`

A hierarquia atual inclui:

- `EstoqueInsuficienteException`
- `PagamentoRecusadoException`
- `PedidoInvalidoException`
- `ClienteNaoEncontradoException`

### Estoque insuficiente

Quando a quantidade solicitada é maior que o estoque disponível, o sistema lança `EstoqueInsuficienteException`.

A exceção informa:

- Produto
- Quantidade solicitada
- Quantidade disponível

### Pagamento recusado

Quando uma forma de pagamento é recusada, o sistema lança `PagamentoRecusadoException`, armazenando também o motivo da recusa.

### Pedido inválido

`PedidoInvalidoException` é utilizada quando uma operação não pode ser realizada de acordo com o estado atual do pedido.

Exemplos:

- Tentar pagar um pedido sem itens.
- Tentar pagar um pedido já pago.
- Tentar modificar um pedido já pago.

### Cliente não encontrado

`ClienteNaoEncontradoException` é utilizada quando um cliente não é localizado durante uma busca.

---

# 🧪 Testes automatizados

O projeto está evoluindo para uma suíte de testes unitários utilizando **JUnit 5**.

Os testes têm como objetivo validar as regras do domínio e garantir que alterações futuras não quebrem funcionalidades existentes.

Entre os cenários trabalhados estão:

- Criação válida de produtos.
- Validação de preços.
- Validação de estoque.
- Baixa de estoque.
- Estoque insuficiente.
- Criação de clientes.
- Validação de e-mail.
- Validação de documento.
- Clientes duplicados.
- Cliente não encontrado.
- Criação de pedidos.
- Pedido sem itens.
- Pedido já pago.
- Cálculo do valor total.
- Pagamento aprovado.
- Pagamento recusado.
- Processador de pagamento nulo.
- Valor de pagamento diferente do total.
- Quantidade zero.
- Quantidade negativa.

Também serão utilizados **testes parametrizados** para validar diferentes entradas.

---

# 🧠 Conceitos aplicados

Durante o desenvolvimento foram utilizados diversos conceitos de Programação Orientada a Objetos e desenvolvimento de software:

- Programação Orientada a Objetos.
- Encapsulamento.
- Herança.
- Abstração.
- Polimorfismo.
- Classes abstratas.
- Interfaces.
- Composição.
- Relacionamentos entre objetos.
- Coleções.
- `BigDecimal`.
- `LocalDate`.
- Exceções.
- `try/catch`.
- `finally`.
- Try-with-resources.
- Testes unitários.
- Testes parametrizados.
- Git.
- GitHub.
- Branches.
- Pull Requests.

---

# 🛠️ Tecnologias

As principais tecnologias utilizadas no projeto são:

- ☕ Java
- 📦 Maven
- 🧪 JUnit 5
- 🌱 Git
- 🐙 GitHub

Tecnologias que serão incorporadas nas próximas etapas:

- Spring Boot
- Banco de dados
- API REST
- Mockito
- JaCoCo
- GitHub Actions
- CI/CD

---

# 📁 Estrutura do projeto

O projeto está organizado da seguinte maneira:

    ecommerce-pedidos-techtrio/
    │
    ├── back/
    │   └── src/
    │       └── main/
    │           └── java/
    │               └── com/
    │                   └── techtrio/
    │                       └── ecommerce/
    │                           ├── App.java
    │                           │
    │                           ├── excecao/
    │                           │   ├── ECommerceException.java
    │                           │   ├── EstoqueInsuficienteException.java
    │                           │   ├── PagamentoRecusadoException.java
    │                           │   ├── PedidoInvalidoException.java
    │                           │   └── ClienteNaoEncontradoException.java
    │                           │
    │                           └── modelo/
    │                               ├── Pessoa.java
    │                               ├── Cliente.java
    │                               ├── Produto.java
    │                               ├── ItemPedido.java
    │                               ├── Pedido.java
    │                               ├── CadastroClientes.java
    │                               ├── CadastroProdutos.java
    │                               │
    │                               └── pagamento/
    │                                   ├── FormaPagamento.java
    │                                   ├── ProcessadorPagamento.java
    │                                   ├── Pix.java
    │                                   ├── Boleto.java
    │                                   ├── CartaoCredito.java
    │                                   ├── Dinheiro.java
    │                                   └── TestePagamento.java
    │
    ├── pom.xml
    ├── README.md
    └── .gitignore

Os testes unitários ficam organizados na estrutura de testes correspondente aos pacotes das classes do domínio.

---

# ▶️ Como executar

O projeto utiliza Maven para compilação e execução dos testes.

Para verificar a instalação do Maven:

    mvn -version

Para compilar:

    mvn compile

Para executar os testes:

    mvn test

---

# 🌿 Estratégia de branches

O desenvolvimento do projeto é realizado utilizando branches específicas para cada funcionalidade ou etapa.

Algumas branches utilizadas no projeto:

- `main`
- `feature/relacionamentos`
- `feature/pagamento-polimorfico`
- `feature/tratamento-excecoes`
- `feature/testes-unitarios`

O fluxo utilizado é:

**Branch → Desenvolvimento → Testes → Commit → Push → Pull Request → Revisão → Merge**

A branch `main` é utilizada como base principal do projeto.

---

# 📚 Roadmap

| Aula | Entrega | Status |
|---|---|---|
| 01 | Repositório criado, estrutura inicial e README | ✅ Concluído |
| 02 | Branches e primeiro Pull Request | ✅ Concluído |
| 03 | Classe utilitária do domínio | ✅ Concluído |
| 04 | Classes de domínio | ✅ Concluído |
| 05 | Encapsulamento e abstração | ✅ Concluído |
| 06 | Hierarquia de formas de pagamento | ✅ Concluído |
| 07 | Relacionamentos entre classes | ✅ Concluído |
| 08 | Pagamento polimórfico | ✅ Concluído |
| 09 | Tratamento de exceções | ✅ Concluído |
| 10 | Testes unitários | 🚧 Em andamento |
| 11 | Testes de integração e cobertura | ⏳ Pendente |
| 12 | Persistência — Create e Read | ⏳ Pendente |
| 13 | Persistência — Update, Delete e DAO/Repository | ⏳ Pendente |
| 14 | Migração para Spring Boot | ⏳ Pendente |
| 15 | API REST e CI/CD | ⏳ Pendente |
| 16 | Entrega final e apresentação | ⏳ Pendente |

---

# 📈 Próximos passos

- [ ] Finalizar a suíte de testes unitários.
- [ ] Criar testes parametrizados.
- [ ] Atingir pelo menos 70% de cobertura de linhas.
- [ ] Criar testes de integração.
- [ ] Configurar JaCoCo.
- [ ] Implementar persistência de dados.
- [ ] Implementar DAO/Repository.
- [ ] Migrar o projeto para Spring Boot.
- [ ] Criar API REST.
- [ ] Configurar CI/CD.
- [ ] Finalizar documentação.
- [ ] Preparar apresentação final.

---

# 🤝 Combinado da equipe

1. Participar ativamente das atividades.
2. Manter uma comunicação clara e respeitosa.
3. Dividir as tarefas de forma justa.
4. Revisar as alterações antes do merge.
5. Manter a branch `main` estável.
6. Utilizar mensagens de commit claras.
7. Testar as funcionalidades antes de realizar o Pull Request.
8. Evitar alterações que não estejam relacionadas à tarefa da branch.

---

# 🎓 Informações acadêmicas

**Instituição:** Faculdade de Tecnologia SENAI "Antonio Adolpho Lobbe"

**Curso:** Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas

**Turma:** CSTADS601

**Unidade Curricular:** Desenvolvimento Back-end

**Projeto:** Sistema de Gestão de Pedidos — E-commerce

---

# 🔗 Repositório

[GitHub — ecommerce-pedidos-techtrio](https://github.com/DiogoFerrante/ecommerce-pedidos-techtrio)

---

# 📄 Licença

Projeto acadêmico desenvolvido para fins educacionais.

© 2026 — TechTrio
