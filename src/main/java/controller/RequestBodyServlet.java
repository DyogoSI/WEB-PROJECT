package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request-body")
public class RequestBodyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body><h2>Corpo da Requisição (POST)</h2>");

        BufferedReader reader = request.getReader();
        String linha;
        while ((linha = reader.readLine()) != null) {
            out.println("<pre>" + linha + "</pre>");
        }

        out.println("</body></html>");
    }
}
