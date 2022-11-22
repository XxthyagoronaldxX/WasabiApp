function addEventIsFreteCheckBox() {
    $('#cart-check-frete').off('click').click(function (e) {
        let value = $(this).is(":checked")

        if (value) {
            $('#cart-frete-value').val("5")
        } else {
            $('#cart-frete-value').val("0")
        }

        refreshInfoPagamento()
    })
}

addEventIsFreteCheckBox()