package com.example.http;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    Cookie[] cookies = request.getCookies();
    String user = null;
    if (cookies != null) {
      for (Cookie c : cookies) {
        if ("user".equals(c.getName())) {
          user = c.getValue();
        }
      }
    }
    if (user == null) {
      user = "X";
      Cookie cookie = new Cookie("user", user);
      response.addCookie(cookie);
      out.println("<p>Cookie criado para usuário: " + user + "</p>");
    } else {
      out.println("<p>Bem-vindo de volta, usuário " + user + "</p>");
    }
  }
}