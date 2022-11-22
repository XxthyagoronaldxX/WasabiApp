function addEventProdutoToModal() {
    $('.cart-item-content').click(function (e) {
        let nome = $(this).children('#item-cart-nome').val()
        let descricao = $(this).children('#item-cart-descricao').val()
        let image = $(this).children('#item-cart-image').val()
        let preco = $(this).children('#item-cart-preco').val()
        let id = $(this).children('#item-cart-id').val()
        let quantidade = $(this).children('#item-cart-quantidade').val()
        let quantidadeProduto = $(this).children('#item-cart-quantidade-produto').val()

        $('#modal-nome').html(nome)
        $('#modal-descricao').html(descricao)
        $('#modal-preco').html("R$ " + preco)
        $('#modal-image').attr("src", image)
        $('#modal-id').val(id)
        $('#modal-quantidade').val(quantidade)
        $('#modal-quantidade-produto-span').html("Quantidade no estoque: " + quantidadeProduto)
        $('#modal-quantidade-produto').val(quantidadeProduto)
    })
}

addEventProdutoToModal()