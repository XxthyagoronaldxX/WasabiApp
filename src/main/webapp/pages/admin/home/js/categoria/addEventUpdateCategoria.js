function addEventUpdateCategoria() {
    $('#modal-btn-criar').off('click').click(function (e) {
        let nome = $('#input-categoria-nome').val()
        let image = $('#input-categoria-image').val()
        let categoriaid = $('#modal-id').val()

        if (nome.trim() === "" || image.trim() === "")
            return

        let url = $('#categoria-controller-url').val()
        let event = $('#categoria-update-event').val()

        console.log(nome, image, categoriaid, url, event)

        $.post(url, {
            event: event,
            nome: nome,
            image: image,
            categoriaid: categoriaid,
        }).done(function (data) {
            if (data.trim() !== "") {
                toastAlertTopRight.fire({
                    icon: 'warning',
                    title: data,
                })
            } else {
                refreshCategoriaList()

                Swal.fire({
                    title: "Categoria atualizado!",
                    showConfirmButton: true,
                    confirmButtonText: 'Eba!',
                    icon: 'success',
                    customClass: "swal-adapter",
                })
            }
        })
    })
}