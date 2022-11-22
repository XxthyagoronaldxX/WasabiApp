function addEventShowPagamentos() {
    $('.item-container-cliente').off('click').click(function (e) {
        let pagamentosCollapse = $(this).siblings('#item-pagamentos-collapse')

        if (pagamentosCollapse.hasClass('show')) {
            pagamentosCollapse.collapse('hide')
        } else {
            pagamentosCollapse.collapse('show')
        }
    })
}