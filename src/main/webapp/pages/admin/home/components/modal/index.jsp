<%@ page contentType="text/html;charset=UTF-8" %>

<div class="modal fade" id="modal-adicionar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="modal-nome" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable modal-wrapper">
        <div class="modal-content">

            <h1 id="modal-title">Produto</h1>

            <form id="modal-form">

            </form>

            <div class="modal-buttons">
                <button class="btn btn-secondary" id="modal-btn-fechar" data-bs-dismiss="modal">Fechar</button>
                <button class="btn btn-danger" type="button" id="modal-btn-remover">Deletar</button>
                <button class="btn btn-primary" form="modal-form" id="modal-btn-criar" type="submit">Criar</button>
            </div>

            <input type="hidden" id="modal-id" value="0"/>
        </div>
    </div>
</div>
