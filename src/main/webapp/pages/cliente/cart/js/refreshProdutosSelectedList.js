function refreshProdutosSelectedList() {
    let url = $('#cart-list-component-url').val()

    $('#cart-produtos-selected').load(url, function (response, status, xhr) {
        let cart = document.getElementsByClassName("cart-item-produto-quantidade")

        if (cart.length === 0) {
            renderFrameToNoProdutosSelected()
        } else {
            addEventProdutoToModal()
            refreshInfoPagamento()
        }
    })
}

refreshProdutosSelectedList()