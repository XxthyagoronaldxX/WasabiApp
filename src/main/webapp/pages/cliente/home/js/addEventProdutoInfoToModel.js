function addEventProdutoInfoToModel() {
    function modifyModal(nome, descricao, preco, image, quantidade, quantidadeProduto, id) {
        $('#modal-nome').html(nome)
        $('#modal-descricao').html(descricao)
        $('#modal-preco').html("R$ " + preco)
        $('#modal-image').attr("src", image)
        $('#modal-id').val(id)
        $('#modal-quantidade').val(quantidade)
        $('#modal-quantidade-produto-span').html("Quantidade no estoque: " + quantidadeProduto)
        $('#modal-quantidade-produto').val(quantidadeProduto)

        if (quantidadeProduto <= 0) {
            let btn = $('#modal-button-add-produto')

            btn.css("background-color", "gray")
            btn.html("Sem estoque!")
        } else {
            let btn = $('#modal-button-add-produto')

            btn.css("background-color", "#198754")
            btn.html("Adicionar")
        }
    }


    $('.adicionar-badge').off('click').click(function (e) {
        let nome = $(this).parent().children('#item-card-nome').val()
        let descricao = $(this).parent().children('#item-card-descricao').val()
        let image = $(this).parent().children('#item-card-image').val()
        let preco = $(this).parent().children('#item-card-preco').val()
        let id = $(this).parent().children('#item-card-id').val()
        let quantidade = $(this).parent().children('#item-card-quantidade').val()
        let quantidadeProduto = $(this).parent().children('#item-card-quantidade-produto').val()

        modifyModal(nome, descricao, preco, image, quantidade, quantidadeProduto, id)
    })

    $('.carousel-item-button').off('click').click(function (e) {
        let id = $(this).children('#carousel-item-id').val()
        let nome = $(this).children('#carousel-item-nome').val()
        let descricao = $(this).children('#carousel-item-descricao').val()
        let image = $(this).children('#carousel-item-image').val()
        let preco = $(this).children('#carousel-item-preco').val()
        let quantidade = $(this).children('#carousel-item-quantidade').val()
        let quantidadeProduto = $(this).children('#carousel-item-quantidade-produto').val()

        modifyModal(nome, descricao, preco, image, quantidade, quantidadeProduto, id)
    })

    $('.adicionado-badge').off('click').click(function (e) {
        let nome = $(this).parent().parent().children('#item-card-nome').val()
        let descricao = $(this).parent().parent().children('#item-card-descricao').val()
        let image = $(this).parent().parent().children('#item-card-image').val()
        let preco = $(this).parent().parent().children('#item-card-preco').val()
        let id = $(this).parent().parent().children('#item-card-id').val()
        let quantidade = $(this).parent().parent().children('#item-card-quantidade').val()
        let quantidadeProduto = $(this).parent().parent().children('#item-card-quantidade-produto').val()

        modifyModal(nome, descricao, preco, image, quantidade, quantidadeProduto, id)
    })
}

addEventProdutoInfoToModel()