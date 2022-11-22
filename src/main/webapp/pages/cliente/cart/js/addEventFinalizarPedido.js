function addEventFinalizarPedido() {
    $('#cart-btn-finalizar-pedido').click(function (e) {
        let total = $('#cart-total').html()

        Swal.fire({
            title: 'Pagamento',
            text: `Total: ${total}`,
            inputLabel: 'Senha:',
            input: 'password',
            inputAttributes: {
                autocapitalize: 'off',
            },
            showCancelButton: true,
            showConfirmButton: true,
            confirmButtonText: 'Confirmar',
            cancelButtonText: 'Cancelar',
            customClass: "swal-adapter",
        }).then((result) => {
            if (result.isConfirmed) {
                let senha = result.value
                let url = $('#cart-pedido-url').val()
                let event = $('#cart-pedido-event-finalizar').val()

                $.post(url, {event: event, senha: senha}).done((result) => {
                    if (result.trim() === "") {
                        Swal.fire({
                            title: "Pedido realizado com sucesso!",
                            showConfirmButton: true,
                            confimButtonText: 'Eba!',
                            icon: 'success',
                            customClass: "swal-adapter",
                        })

                        renderFrameToNoProdutosSelected()
                        refreshInfoPagamento()
                    } else {
                        Swal.fire({
                            title: result,
                            showCancelButton: true,
                            showConfirmButton: false,
                            cancelButtonText: 'Fechar',
                            icon: 'error',
                            customClass: "swal-adapter",
                        })
                    }
                })
            }
        })
    })
}

addEventFinalizarPedido()