function addEventRemoveToModal() {
    $('#modal-button-remove-produto').click(function (e) {
        Swal.fire({
            title: 'Confirmação',
            text: 'Você realmente deseja remover o produto?',
            icon: 'question',
            showDenyButton: true,
            showConfirmButton: true,
            confirmButtonText: 'Sim',
            denyButtonText: 'Não',
            customClass: 'swal-adapter',
        }).then((result) => {
            if (result.isConfirmed) {
                removeProduto()
                Swal.fire({
                    icon: 'success',
                    title: 'Produto removido!',
                    showConfirmButton: false,
                    customClass: 'swal-adapter',
                    timer: 800,
                })
            }
        })

        function removeProduto() {
            let url = $('#cart-pedido-url').val()
            let event = $('#cart-pedido-event-remove-produto-carrinho').val()
            let id = $('#modal-id').val()

            $.post(url, {event: event, id: id}).done(() => {
                refreshProdutosSelectedList()
            })
        }
    })
}

addEventRemoveToModal()