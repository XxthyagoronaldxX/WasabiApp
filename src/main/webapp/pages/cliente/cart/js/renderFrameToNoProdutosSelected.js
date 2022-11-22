function renderFrameToNoProdutosSelected() {
    $('#cart-produtos-selected').html("<div class=\"sem-produtos\">" +
        "<h4>Não foi selecionado nenhum produto!</h4></div>")
    $('#cart-info-frete').remove()
    $('#cart-frete-value').val('0')
    $('#cart-btn-cancelar-pedido').remove()
    $('#cart-btn-finalizar-pedido').remove()
}



