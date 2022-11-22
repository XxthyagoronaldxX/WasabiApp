function addEventRegister() {
    let registerForm = document.getElementById('register_form')

    registerForm.addEventListener('submit', function (e) {
        e.preventDefault()
        return false
    })

    function isEmpty(value) {
        return value === null || value.trim() === ""
    }

    $('#register_button').click(function (e) {
        let nome = $('#nomeInput').val()
        let telefone = $('#telefoneInput').val()
        let endereco = $('#enderecoInput').val()
        let cpf = $('#cpfInput').val()
        let cartao = $('#cartaoInput').val()
        let senha = $('#senhaInput').val()
        let againSenha = $('#repetirSenhaInput').val()

        if (isEmpty(nome) || isEmpty(telefone)
            || isEmpty(endereco) || isEmpty(cpf)
            || isEmpty(cartao) || isEmpty(senha)
            || isEmpty(againSenha) || againSenha.length < 8
            || senha.length < 8)
            return

        let url = $('#cliente_controller_url').val()
        let event = $('#cliente_controller_event_register').val()

        $.post(url, {
            event: event,
            nome: nome,
            telefone: telefone,
            endereco: endereco,
            cpf: cpf,
            cartao: cartao,
            senha: senha,
            repetirSenha: againSenha,
        }).done((data) => {
            if (!isEmpty(data)) {
                toastAlertTopRight.fire({
                    title: data,
                    icon: 'error',
                })
                return
            }

            Swal.fire({
                title: "Registrado com sucesso!",
                icon: "success",
                timer: 2500,
            }).then(() => {
                let redirect = $('#redirect_page').val()

                setInterval(() => {
                    $(location).attr('href', redirect)
                }, 600)
            })
        }).fail((error) => {
            console.log(error)
        })
    })
}

addEventRegister()