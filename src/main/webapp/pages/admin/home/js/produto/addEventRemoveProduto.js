function addEventRemoveProduto() {
    $('#modal-btn-remover').off('click').click(function (e) {
        let produtoid = $('#modal-id').val()

        let url = $('#produto-controller-url').val()
        let event = $('#produto-remove-event').val()

        Swal.fire({
            text: 'Você realmente deseja remover o produto?',
            icon: 'question',
            showDenyButton: true,
            showConfirmButton: true,
            confirmButtonText: 'Sim',
            denyButtonText: 'Não',
            customClass: 'swal-adapter',
        }).then((result) => {
            if (result.isConfirmed) {
                $.post(url, {event: event, produtoid: produtoid}).done((data) => {
                    if (data.trim() !== "") {
                        toastAlertTopRight.fire({
                            title: data,
                            icon: "error"
                        })
                    } else {
                        Swal.fire({
                            icon: 'success',
                            title: 'Produto removido!',
                            showConfirmButton: false,
                            customClass: 'swal-adapter',
                            timer: 800,
                        })

                        refreshProdutoList()
                    }
                })
            }
        })


    })
}