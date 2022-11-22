function _calcTotalProduto() {
    let quantidadeList = document.getElementsByClassName("cart-item-produto-quantidade")
    let precoList = document.getElementsByClassName("cart-item-produto-preco")
    let total = 0

    for (let i = 0;i < quantidadeList.length;i++) {
        total += Number(quantidadeList[i].value) * Number(precoList[i].value)
    }

    return total;
}

function refreshInfoPagamento() {
    let totalProduto = _calcTotalProduto()
    let frete = Number($('#cart-frete-value').val())
    let total = totalProduto + frete;

    $('#cart-produtos-total').html("R$ " + totalProduto.toFixed(2))
    $('#cart-frete').html("R$ " + frete.toFixed(2))
    $('#cart-total').html("R$ " + total.toFixed(2))
}