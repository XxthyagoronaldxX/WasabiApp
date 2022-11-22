function refreshCarouselView() {
    let url = $('#produto-carousel-view-url').val()

    $('#carousel-view').load(url)
}

refreshCarouselView()