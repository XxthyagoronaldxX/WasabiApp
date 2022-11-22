function addEventFilterProdutoByCategoria() {
    $('.categoria-item').off('click').click(function(e) {
        let id = $(this).children('#categoria-id').val()

        $('#produto-categoria-atual').val(id)

        refreshProductList()
    })
}

addEventFilterProdutoByCategoria()