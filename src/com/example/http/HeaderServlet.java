package com.example.http;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class HeaderServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><body><h2>Cabeçalhos da Requisição</h2>");
    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String name = headerNames.nextElement();
      out.println("<p><b>" + name + ":</b> " + request.getHeader(name) + "</p>");
    }
    out.println("<p><b>IP:</b> " + request.getRemoteAddr() + "</p>");
    out.println("<p><b>HTTP:</b> " + request.getProtocol() + "</p>");
    out.println("</body></html>");
  }
}