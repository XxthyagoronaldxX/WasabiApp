function addEventCreateCategoria() {
    $('#modal-btn-criar').off('click').click(function (e) {
        let nome = $('#input-categoria-nome').val()
        let image = $('#input-categoria-image').val()

        if (nome.trim() === "" || image.trim() === "")
            return

        let url = $('#categoria-controller-url').val()
        let event = $('#categoria-create-event').val()

        $.get(url, {event: event, nome: nome, image: image}).done((data) => {
            if (data.trim() !== "") {
                toastAlertTopRight.fire({
                    title: data,
                    icon: 'warning',
                })
            } else {
                Swal.fire({
                    title: "Categoria criada!",
                    showConfirmButton: true,
                    confirmButtonText: 'Eba!',
                    icon: 'success',
                    customClass: "swal-adapter",
                })

                $('#input-categoria-nome').val("")
                $('#input-categoria-image').val("")

                refreshCategoriaList()
            }
        })

    })
}