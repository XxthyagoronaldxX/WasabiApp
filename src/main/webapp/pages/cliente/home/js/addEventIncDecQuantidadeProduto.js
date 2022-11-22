function addEventIncDecQuantidadeProduto() {
    let quantidadeInput = $('#modal-quantidade')

    $('#modal-dec-qt-produto').off('click').click(function(e) {
        let quantidade = Number(quantidadeInput.val()) - 1

        if (quantidade >= 1)
            quantidadeInput.val(quantidade)
    })

    $('#modal-inc-qt-produto').off('click').click(() => {
        let quantidade = Number(quantidadeInput.val()) + 1

        let quantidadeProduto = Number($('#modal-quantidade-produto').val())

        if (quantidade <= quantidadeProduto) {
            quantidadeInput.val(quantidade)
        } else {
            toastAlertTopRight.fire({
                title: "Limite de estoque!",
                icon: "warning",
            })
        }
    })
}

addEventIncDecQuantidadeProduto()