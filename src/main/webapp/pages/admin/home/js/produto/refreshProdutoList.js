function refreshProdutoList() {
    let url = $('#produto-controller-url').val()
    let event = $('#produto-findall-event').val()

    $('#modal-btn-fechar').trigger('click')

    $.get(url, {event: event}).done(() => {
        let listUrl = $('#list-produto-component-url').val()

        $('#list').load(listUrl, function () {
            addEventProdutoToModal()
            addEventFilterToProduto()
        });
    })
}