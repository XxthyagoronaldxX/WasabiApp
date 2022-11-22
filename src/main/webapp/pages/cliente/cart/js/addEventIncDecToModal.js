function addEventIncDecToModal() {
    let url = $('#cart-pedido-url').val()

    $('#modal-dec-qt-produto').click(function (e) {
        let input = $('#modal-quantidade')

        if (Number(input.val()) > 1) {
            let id = $('#modal-id').val()
            let event = $('#cart-pedido-event-dec').val()

            let newValue = Number(input.val()) - 1

            input.val(newValue)

            $.post(url, {id: id, event: event,}).done(() => {
                refreshProdutosSelectedList()
            })
        }
    })

    $('.inc').click(function (e) {
        let input = $('#modal-quantidade')
        let id = $('#modal-id').val()
        let event = $('#cart-pedido-event-inc').val()

        let newValue = Number(input.val()) + 1

        $.post(url, {id: id, event: event,}).done((data) => {
            if (data.trim() !== "") {
                toastAlertTopRight.fire({
                    title: data,
                    icon: "warning"
                })
            } else {
                input.val(newValue)

                refreshProdutosSelectedList()
            }
        })
    })
}

addEventIncDecToModal()