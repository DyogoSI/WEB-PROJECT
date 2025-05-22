package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/methods")
public class MethodsServlet extends HttpServlet {
    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.setContentType("text/plain;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("Métodos suportados: GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
