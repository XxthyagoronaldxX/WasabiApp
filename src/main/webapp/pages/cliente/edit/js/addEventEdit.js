function addEventEdit() {
    let editForm = document.getElementById("edit_form")

    editForm.addEventListener('submit', function (e) {
        e.preventDefault()
        return false
    })

    $('#edit-btn-atualizar').click(function (e) {
        let nome = $('#nomeInput').val()
        let telefone = $('#telefoneInput').val()
        let endereco = $('#enderecoInput').val()
        let cpf = $('#cpfInput').val()
        let cartao = $('#cartaoInput').val()
        let senhaAtual = $('#senhaAtual').val()
        let senhaNova = $('#senhaNova').val()
        let senhaNovaRepetir = $('#repetirSenhaInput').val()

        if (senhaNova !== senhaNovaRepetir) {
            toastAlertTopRight.fire({
                title: "Nova senha diferente!",
                icon: "warning",
            })

            return
        }

        let url = $('#cliente-controller-url').val()
        let event = $('#cliente-controller-event-edit').val()

        $.post(url, {
            event: event,
            nome: nome,
            telefone: telefone,
            endereco: endereco,
            cpf: cpf,
            cartao: cartao,
            senhaAtual: senhaAtual,
            senha: senhaNova,
            repetirSenha: senhaNovaRepetir,
        }).done((data) => {
            if (data.trim() !== "") {
                toastAlertTopRight.fire({
                    title: data,
                    icon: "error",
                })

                return
            }

            Swal.fire({
                title: "Cadastro atualizado!",
                icon: "success",
            })

            let redirect = $('#redirect-home').val()

            setInterval(() => {
                $(location).attr('href', redirect)
            }, 600)
        })
    })
}

addEventEdit()