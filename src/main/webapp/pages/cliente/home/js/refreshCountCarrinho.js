function refreshCountCarrinho() {
    let url = $('#pedido-url').val()
    let event = $('#pedido-event-getsizecarrinho').val()

    $.get(url, {
        event: event
    }, function (data) {
        $('#cart-counter').html(data)
    })
}

refreshCountCarrinho()