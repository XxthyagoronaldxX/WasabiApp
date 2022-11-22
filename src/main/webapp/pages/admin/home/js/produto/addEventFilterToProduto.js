function addEventFilterToProduto() {
    let url = $('#produto-controller-url').val()
    let event = $('#produto-findall-event').val()
    let listUrl = $('#list-produto-component-url').val()

    $('#filter-select').off('change').change(function (e) {
        let selected = $(this).val()

        $('.input-filter-flag').css('display', 'none')

        if (selected === "1") {
            filterProdutoNome()
        } else if (selected === "2") {
            filterProdutoPreco()
        } else if (selected === "3") {
            filterProdutoCategoria()
        } else {
            refreshProdutoList()
        }
    })

    function filterProdutoCategoria() {
        $('#filter-input-select-container').css('display', 'flex')

        $('#filter-input-select').off('change').change(function (e) {
            $.get(url, {
                event: event,
                filter: "3",
                categoriaid: $(this).val()
            }, function () {
                $('#list').load(listUrl, function () {
                    addEventProdutoToModal()
                    addEventFilterToProduto()
                });
            })
        })
    }

    function filterProdutoPreco() {
        $('#filter-input-valor-container').css('display', 'flex')

        $('#filter-input-lessthan').off('keyup').keyup(function (e) {
            let higherthan = $('#filter-input-higherthan').val()

            $.get(url, {
                event: event,
                filter: "2",
                lessthan: $(this).val(),
                higherthan: higherthan
            }, function (data) {
                if (data.trim() !== "") {
                    toastAlertTopRight.fire({
                        title: data,
                        icon: "warning"
                    })
                }

                $('#list').load(listUrl, function () {
                    addEventProdutoToModal()
                    addEventFilterToProduto()
                });
            })
        })

        $('#filter-input-higherthan').off('keyup').keyup(function (e) {
            let lessthan = $('#filter-input-lessthan').val()

            $.get(url, {
                event: event,
                filter: "2",
                lessthan: lessthan,
                higherthan: $(this).val()
            }, function () {
                $('#list').load(listUrl, function () {
                    addEventProdutoToModal()
                    addEventFilterToProduto()
                });
            })
        })
    }

    function filterProdutoNome() {
        $('#filter-input-text-container').css('display', 'block')

        $('#filter-input-text').off('keyup').keyup(function (e) {
            $.get(url, {event: event, filter: "1", nome: $(this).val()}, function () {
                $('#list').load(listUrl, function () {
                    addEventProdutoToModal()
                    addEventFilterToProduto()
                });
            })
        })
    }
}