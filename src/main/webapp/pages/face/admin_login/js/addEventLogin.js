function addEventLogin() {
    let form = document.getElementById('login-form');

    form.addEventListener('submit', function (e) {
        e.preventDefault()
        return false
    })

    $('#login-btn').click(function (e) {
        e.preventDefault()

        let username = $('#username-label').val()
        let senha = $('#senha-label').val()
        let url = $('#admin-controller-url').val()
        let event = $('#admin-event-login').val()
        let redirect = $('#admin-home-redirect').val()

        console.log(redirect)

        if (username.trim().length === 0 || senha.trim().length < 8)
            return;



        $.post(url, {event: event, username: username, senha: senha}).done(function (data) {
            if (data.trim() !== "") {
                toastAlertTopRight.fire({
                    icon: 'warning',
                    title: data,
                })
            } else {


                $(location).attr('href', redirect)
            }
        })
    })
}

addEventLogin()