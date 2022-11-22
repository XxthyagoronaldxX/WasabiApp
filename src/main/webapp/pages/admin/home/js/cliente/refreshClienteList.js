function refreshClienteList() {
    let url = $('#cliente-controller-url').val()
    let event = $('#cliente-findall-event').val()

    $.get(url, {event: event}, function () {
        let listUrl = $('#list-cliente-component-url').val()

        $('#list').load(listUrl, function () {
            addEventShowPagamentos()
            addEventShowProdutos()
        });
    })
}