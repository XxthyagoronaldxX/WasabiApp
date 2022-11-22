function addEventAdicionarFilter() {
    $('#filter-btn-adicionar').off('click').click(function (e) {
        $('#modal-btn-criar').html('Adicionar')
        $('#modal-btn-remover').hide()

        let selected = $('.header-button-selected').html()

        if (selected === 'Produto') {
            resetProdutoInputs()
            addEventCreateProduto()
        } else if (selected === 'Categoria') {
            resetCategoriaInputs()
            addEventCreateCategoria()
        }
    })

    function resetCategoriaInputs() {
        $('#input-categoria-image').val("")
        $('#input-categoria-nome').val("")
    }

    function resetProdutoInputs() {
        $('#input-produto-nome').val("")
        $('#input-produto-descricao').val("")
        $('#input-produto-preco').val("")
        $('#input-produto-image').val("")
        $('#input-produto-quantidade').val("")
        $('#select-produto-categoria').val("-1")
    }
}

addEventAdicionarFilter()