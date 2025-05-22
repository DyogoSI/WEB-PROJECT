package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codeParam = request.getParameter("code");
        int code;

        try {
            code = Integer.parseInt(codeParam);
        } catch (Exception e) {
            code = 200; // padrão
        }

        response.setStatus(code);
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.printf("<p>Status HTTP enviado: <strong>%d</strong></p>", code);
        out.println("</body></html>");
    }
}
