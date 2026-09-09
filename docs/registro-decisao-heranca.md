# Registro de Decisão — Herança

## Decisão recusada

**Proposta:** Fazer `CarrinhoDeCompras` estender `ArrayList<ItemPedido>`.

## Motivo da recusa

A proposta foi recusada porque `CarrinhoDeCompras` não é um
`ArrayList<ItemPedido>`.

Um carrinho possui uma lista de itens, mas não deve ser tratado como
uma lista. Portanto, utilizar herança nesse caso não representa
corretamente a relação entre as classes.

Além disso, fazer `CarrinhoDeCompras` herdar de `ArrayList` expõe
comportamentos da lista que não necessariamente fazem parte da
responsabilidade do carrinho.

## Alternativa adotada

A alternativa escolhida é utilizar **composição**.

`CarrinhoDeCompras` deverá possuir internamente uma lista de
`ItemPedido`, por exemplo:

`List<ItemPedido> itens`

Dessa forma, o carrinho controla os itens que possui sem precisar
herdar diretamente de `ArrayList`.

## Teste do "é-um"

**CarrinhoDeCompras é um ArrayList?**

Não. ❌

**CarrinhoDeCompras possui uma lista de ItemPedido?**

Sim. ✅

Portanto, composição é mais adequada do que herança.