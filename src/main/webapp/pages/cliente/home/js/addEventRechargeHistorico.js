function addEventRechargeHistorico() {
    $('#header-btn-historico').off('click').click(function (e) {
        let url = $('#pedido-url').val()
        let event = $('#pedido-event-getallpedido').val()
        let redirect = $('#historic-redirect-url').val()

        $.get(url, {event: event}).done((data) => {
            if (data.trim() !== "") {
                toastAlertTopRight.fire({
                    title: data,
                    icon: 'warning',
                })
            } else {
                $(location).attr('href', redirect)
            }
        });
    })
}

addEventRechargeHistorico()