package com.example.http;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MethodsServlet extends HttpServlet {
  protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
    response.setContentType("text/plain;charset=UTF-8");
    response.getWriter().println("Métodos suportados: GET, POST, PUT, DELETE, OPTIONS");
  }
}