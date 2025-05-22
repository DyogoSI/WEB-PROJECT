package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("usuario")) {
                    usuario = c.getValue();
                    break;
                }
            }
        }

        out.println("<html><body>");
        if (usuario != null) {
            out.printf("<p>Bem-vindo de volta, usuário '%s'!</p>", usuario);
        } else {
            Cookie novo = new Cookie("usuario", "X");
            novo.setMaxAge(60 * 60 * 24); // 1 dia
            response.addCookie(novo);
            out.println("<p>Bem-vindo novo usuário! Cookie criado.</p>");
        }
        out.println("</body></html>");
    }
}
