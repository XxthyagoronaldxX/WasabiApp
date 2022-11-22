function removeFormDefaultAction() {
    let form = document.getElementById("modal-form")

    form.addEventListener('submit', function (e) {
        e.preventDefault()
        return false
    })
}

removeFormDefaultAction()