function addEventCreateProduto() {
    $('#modal-btn-criar').off('click').click(function (e) {
        let nome = $('#input-produto-nome').val()
        let descricao = $('#input-produto-descricao').val()
        let preco = $('#input-produto-preco').val()
        let image = $('#input-produto-image').val()
        let quantidade = $('#input-produto-quantidade').val()
        let categoriaid = $('#select-produto-categoria').val()

        if (nome.trim() === "" || descricao.trim() === ""
            || Number(preco) <= 0 || Number(quantidade) < 0 || image.trim() === "" || categoriaid === "-1")
            return

        let url = $('#produto-controller-url').val()
        let event = $('#produto-create-event').val()

        $.post(url, {
            event: event,
            nome: nome,
            descricao: descricao,
            preco: preco,
            image: image,
            quantidade: quantidade,
            categoriaid: categoriaid,
        }).done(function (data) {
            if (data.trim() !== "") {
                toastAlertTopRight.fire({
                    icon: 'warning',
                    title: data,
                })
            } else {
                refreshProdutoList()

                Swal.fire({
                    title: "Produto criado!",
                    showConfirmButton: true,
                    confimButtonText: 'Eba!',
                    icon: 'success',
                    customClass: "swal-adapter",
                })

                $('#input-produto-nome').val("")
                $('#input-produto-descricao').val("")
                $('#input-produto-preco').val("")
                $('#input-produto-image').val("")
                $('#input-produto-quantidade').val("")
                $('#select-produto-categoria').val("-1")
            }
        })
    })
}