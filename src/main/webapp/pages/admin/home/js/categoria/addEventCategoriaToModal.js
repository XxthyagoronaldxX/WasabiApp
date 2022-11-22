function addEventCategoriaToModal() {
    $('.item-list-categoria').off('click').click(function (e) {
        let nome = $(this).children('#item-list-nome').val()
        let image = $(this).children('#item-list-image').val()
        let id = $(this).children('#item-list-id').val()

        $('#input-categoria-nome').val(nome)
        $('#input-categoria-image').val(image)
        $('#modal-id').val(id)

        $('#modal-btn-criar').html('Atualizar')
        $('#modal-btn-remover').css('display', 'block')

        addEventRemoveCategoria()
        addEventUpdateCategoria()
    })
}