function refreshCategoriaList() {
    let url = $('#categoria-controller-url').val()
    let event = $('#categoria-findall-event').val()

    $('#modal-btn-fechar').trigger('click')

    $.get(url, {event: event}).done(() => {
        let listUrl = $('#list-categoria-component-url').val()

        $('#list').load(listUrl, function () {
            addEventCategoriaToModal()
            addEventCreateCategoria()
        });
    })
}