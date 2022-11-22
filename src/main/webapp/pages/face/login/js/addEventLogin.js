function addEventLogin() {
    let loginForm = document.getElementById('login_form')

    loginForm.addEventListener('submit', function (e) {
        e.preventDefault()
        return false
    })

    $('#login_button').click(function (e) {
        let cpf = $('#cpfInput').val()
        let senha = $('#senhaInput').val()

        if (cpf.trim().length < 14 || senha.trim().length < 8)
            return;

        let url = $('#cliente_controller_url').val()
        let event = $('#cliente_controller_event_login').val()

        $.post(url, {event: event, cpf: cpf, senha: senha}).done((data) => {
            if (data.trim() !== "") {
                toastAlertTopRight.fire({
                    title: data,
                    icon: 'error'
                })

                $('#senhaInput').val("")
                $('#cpfInput').val("")
            } else {
                let redirect = $('#home_redirect').val()

                $(location).attr('href', redirect)
            }
        })
    })
}

addEventLogin()