function addEventRemoveProdutoFromCart() {
    $('.remover-badge').off('click').click(function (e) {
        Swal.fire({
            text: 'Você realmente deseja remover o produto da lista de pedidos?',
            icon: 'question',
            showDenyButton: true,
            showConfirmButton: true,
            confirmButtonText: 'Sim',
            denyButtonText: 'Não',
            customClass: "swal-adapter",
        }).then((result) => {
            if (result.isConfirmed) {
                let id = $(this).parent().parent().children('#item-card-id').val()
                let url = $('#pedido-url').val()
                let event = $('#pedido-event-removeprodutofromcarrinho').val()

                $.post(url, {event: event, id: id}).done(() => {
                    refreshProductList()
                    refreshCountCarrinho()
                })

                Swal.fire({
                    icon: 'success',
                    title: 'Produto removido!',
                    showConfirmButton: false,
                    customClass: "swal-adapter",
                    timer: 800,
                })
            }
        })
    })
}

addEventRemoveProdutoFromCart()