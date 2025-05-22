package com.example.http;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RequestBodyServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body><h2>Corpo da Requisição</h2>");
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String mensagem = request.getParameter("mensagem");
    out.println("<p><b>Nome:</b> " + nome + "</p>");
    out.println("<p><b>Email:</b> " + email + "</p>");
    out.println("<p><b>Mensagem:</b> " + mensagem + "</p>");
    out.println("</body></html>");
  }
}