package com.netbiis.wassabiapp_jsp.controller.handles.cliente;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.IUpdateClienteUsecase;
import com.netbiis.wassabiapp_jsp.core.utils.AttributeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class EditClienteHandle implements IHandle {
    private final IUpdateClienteUsecase updateClienteUsecase;

    public EditClienteHandle(IUpdateClienteUsecase updateClienteUsecase) {
        this.updateClienteUsecase = updateClienteUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleEditEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            System.out.println(error.getMessage());
            response.sendError(500, error.getMessage());
        }
    }

    private void handleEditEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String cpf = request.getParameter("cpf");
        String cartao = request.getParameter("cartao");
        String senhaAtual = request.getParameter("senhaAtual");
        String senha = request.getParameter("senha");
        String repetirSenha = request.getParameter("repetirSenha");

        HttpSession session = request.getSession();
        ClienteEntity cliente = (ClienteEntity) session.getAttribute(AttributeUtil.CLIENTE);

        if (senhaAtual.equals(cliente.getSenha())) {
            if (!(senha.isEmpty()) && senha.equals(repetirSenha) && !(senha.equals(senhaAtual))) {

                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEndereco(endereco);
                cliente.setSenha(senha);
                cliente.setCartao(cartao);
                cliente.setTelefone(telefone);

                this.updateClienteUsecase.execute(cliente);
            } else if (senha.isEmpty()) {

                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEndereco(endereco);
                cliente.setSenha(senhaAtual);
                cliente.setCartao(cartao);
                cliente.setTelefone(telefone);

                this.updateClienteUsecase.execute(cliente);
            } else {
                throw new IllegalArgumentException("Senha inválida!");
            }
        } else {
            throw new IllegalArgumentException("Senha atual incorreta!");
        }
    }
}
