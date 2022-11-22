function addEventProdutoToModal() {
    $('.item-list-produto').off('click').click(function (e) {
        let nome = $(this).children('#item-list-nome').val()
        let descricao = $(this).children('#item-list-descricao').val()
        let image = $(this).children('#item-list-image').val()
        let preco = $(this).children('#item-list-preco').val()
        let id = $(this).children('#item-list-id').val()
        let quantidade = $(this).children('#item-list-quantidade').val()
        let categoriaid = $(this).children('#item-list-categoria-id').val()

        $('#input-produto-nome').val(nome)
        $('#input-produto-descricao').val(descricao)
        $('#input-produto-preco').val(preco)
        $('#input-produto-image').val(image)
        $('#input-produto-quantidade').val(quantidade)
        $('#select-produto-categoria').val(categoriaid)
        $('#modal-id').val(id)

        $('#modal-btn-criar').html('Atualizar')
        $('#modal-btn-remover').css('display', 'block')

        addEventRemoveProduto()
        addEventUpdateProduto()
    })
}