package com.netbiis.wassabiapp_jsp.controller.handles.cliente;

import com.netbiis.wassabiapp_jsp.controller.handles.IHandle;
import com.netbiis.wassabiapp_jsp.model.entities.ClienteEntity;
import com.netbiis.wassabiapp_jsp.model.usecases.cliente.ICreateClienteUsecase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegisterClienteHandle implements IHandle {
    private final ICreateClienteUsecase createClienteUsecase;

    public RegisterClienteHandle(ICreateClienteUsecase createClienteUsecase) {
        this.createClienteUsecase = createClienteUsecase;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            handleRegisterEvent(request, response);
        } catch (IllegalArgumentException error) {
            response.getWriter().print(error.getMessage());
        } catch (Exception error) {
            System.out.println(error.getMessage());
            response.sendError(500, error.getMessage());
        }
    }

    private void handleRegisterEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String cpf = request.getParameter("cpf");
        String cartao = request.getParameter("cartao");
        String senha = request.getParameter("senha");
        String repetirSenha = request.getParameter("repetirSenha");

        if (senha.equals(repetirSenha)) {
            ClienteEntity cliente = new ClienteEntity();

            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEndereco(endereco);
            cliente.setSenha(senha);
            cliente.setCartao(cartao);
            cliente.setTelefone(telefone);

            this.createClienteUsecase.execute(cliente);
        } else {
            throw new IllegalArgumentException("SENHA: Senhas não batem!");
        }
    }
}
