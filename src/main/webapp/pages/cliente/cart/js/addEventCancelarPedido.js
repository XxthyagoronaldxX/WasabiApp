function addEventCancelarPedido() {
    $('#cart-btn-cancelar-pedido').click(function (e) {
        Swal.fire({
            title: 'Cancelar pedido?',
            showCancelButton: true,
            showConfirmButton: true,
            confirmButtonText: 'Sim',
            cancelButtonText: 'Não',
            customClass: "swal-adapter",
        }).then(function (result) {
            if (result.isConfirmed)
                cancelarPedido()
        })

        function cancelarPedido() {
            let url = $('#cart-pedido-url').val()
            let event = $('#cart-pedido-event-cancelar').val()

            $.post(url, {event: event}).done(() => {
                renderFrameToNoProdutosSelected()
                refreshInfoPagamento()
            })
        }
    })
}

addEventCancelarPedido()