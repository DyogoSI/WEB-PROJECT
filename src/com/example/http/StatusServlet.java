package com.example.http;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class StatusServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String code = request.getParameter("code");
    int statusCode = 200;
    try { statusCode = Integer.parseInt(code); } catch (Exception e) {}
    response.setStatus(statusCode);
    response.setContentType("text/plain;charset=UTF-8");
    response.getWriter().println("Status definido como: " + statusCode);
  }
}