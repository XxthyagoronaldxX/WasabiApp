function refreshProductList() {
    let url = $('#produto-url').val()
    let event = $('#produto-event-filterbycategoria').val()
    let categoria_id = $('#produto-categoria-atual').val()

    $('#product-list').load(url, {
        id: categoria_id,
        event: event
    }, function () {
        addEventProdutoInfoToModel()
        addEventRemoveProdutoFromCart()
        addPaginationToProduto()
    })
}

refreshProductList()
