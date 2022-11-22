function addEventAddProdutoToCart() {
    $('#modal-button-add-produto').off('click').click(function(e) {
        let url = $('#pedido-url').val()
        let produtoid = $('#modal-id').val()
        let quantidade = $('#modal-quantidade').val()
        let quantidadeProduto = $('#modal-quantidade-produto').val()
        let event = $('#pedido-event-addprodutotocarrinho').val()

        if (quantidadeProduto <= 0) {
            toastAlertTopRight.fire({
                title: "Fora de estoque!",
                icon: "warning",
            })
            return
        }

        $.post(url, {
            produtoid: produtoid,
            quantidade: quantidade,
            event: event,
        }).done(function () {
            toastAlertTopRight.fire({
                icon: 'success',
                title: 'Produto adicionado!',
            })

            refreshProductList()
            refreshCarouselView()
            refreshCountCarrinho()
        })
    })
}

addEventAddProdutoToCart()