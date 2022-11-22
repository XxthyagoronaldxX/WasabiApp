package com.netbiis.wassabiapp_jsp.controller.handles;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface IHandle {
    void handle(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
