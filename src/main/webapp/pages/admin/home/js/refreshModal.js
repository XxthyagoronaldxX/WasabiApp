function refreshModal() {
    let selected = $('.header-button-selected').html()

    if (selected === 'Produto') {
        let url = $('#modal-produto-input').val()

        $('#filter-container').css('display', 'flex')
        $('#filter-options').css('display', 'flex')

        $('#modal-form').load(url)

        refreshProdutoList()
    } else if (selected === 'Categoria') {
        let url = $('#modal-categoria-input').val()

        $('#filter-container').css('display', 'flex')
        $('#filter-options').css('display', 'none')

        $('#modal-form').load(url)

        refreshCategoriaList()
    } else if (selected === 'Cliente') {
        $('#filter-container').css('display', 'none')

        refreshClienteList()
    }
}

refreshModal()