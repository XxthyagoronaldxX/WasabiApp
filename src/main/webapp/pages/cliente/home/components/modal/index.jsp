<%@ page contentType="text/html;charset=UTF-8" %>
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="modal-nome" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable modal-wrapper">
        <div class="modal-content">
            <div class="modal-header">
                <h1 id="modal-nome">Title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="modal-top">
                    <div class="form-group mt-2 me-2">
                        <h4 id="modal-preco">R$ 25.00</h4>
                        <p class="fw-bold">Selecione a quantidade:</p>

                        <form class="quantidade-contador input-group rounded-pill">
                            <a class="btn form-text text-danger" id="modal-dec-qt-produto">-</a>
                            <input class="form-control" type="number"
                                   id="modal-quantidade" name="quantidade"
                                   value="1" disabled>

                            <a class="btn form-text text-primary inc" id="modal-inc-qt-produto">+</a>

                            <input type="hidden" id="modal-quantidade-produto" value="">
                            <input type="hidden" id="modal-id" name="produtoid" value="-1"/>
                        </form>

                        <span id="modal-quantidade-produto-span">Quantidade no estoque: 0</span>
                    </div>
                    <div class="form-group mt-2">
                        <img id="modal-image"
                             src="${pageContext.request.contextPath}/imgs/icon_sushi_login.png"
                             alt="Imagem do produto"/>
                    </div>
                </div>

                <hr class="text-light fw-bold">
                <h2 id="modal-descricao-title">Descrição</h2>
                <p id="modal-descricao">aqui fica a descrição do produto</p>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cancelar</button>
                <button type="submit" id="modal-button-add-produto" data-bs-dismiss="modal" class="btn btn-primary">
                    Adicionar
                </button>
            </div>
        </div>
    </div>
</div>
