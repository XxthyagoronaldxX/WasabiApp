function addEventShowProdutos() {
    $('.item-pedido').click(function (e) {
        let collapse = $(this).children('#item-produtos-collapse')


        if (collapse.hasClass("show")) {
            collapse.collapse('hide')
        } else {
            collapse.collapse('show')
        }
    })
}