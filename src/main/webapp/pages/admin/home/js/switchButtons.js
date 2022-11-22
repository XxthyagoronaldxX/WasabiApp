function switchButtons() {
    $('.button-select').off('click').click(function (e) {
        $('#header-buttons').children('.button-select').removeClass('header-button-selected')

        $(this).addClass('header-button-selected')

        refreshModal()
    })
}

switchButtons()