function addEventRemoveCategoria() {
    $('#modal-btn-remover').off('click').click(function (e) {
        let categoriaid = $('#modal-id').val()

        let url = $('#categoria-controller-url').val()
        let event = $('#categoria-remove-event').val()

        Swal.fire({
            text: 'Você realmente deseja remover a categoria?',
            icon: 'question',
            showDenyButton: true,
            showConfirmButton: true,
            confirmButtonText: 'Sim',
            denyButtonText: 'Não',
            customClass: 'swal-adapter',
        }).then((result) => {
            if (result.isConfirmed) {
                $.post(url, {event: event, categoriaid: categoriaid}).done((data) => {
                    if (data.trim() !== "") {
                        toastAlertTopRight.fire({
                            title: data,
                            icon: "error"
                        })
                    } else {
                        Swal.fire({
                            icon: 'success',
                            title: 'Categoria removida!',
                            showConfirmButton: false,
                            customClass: 'swal-adapter',
                            timer: 800,
                        })

                        refreshCategoriaList()
                    }
                })
            }
        })


    })
}