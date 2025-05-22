package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body><h2>Cabeçalhos da Requisição</h2>");
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            String value = request.getHeader(header);
            out.printf("<p><strong>%s:</strong> %s</p>%n", header, value);
        }

        out.printf("<p><strong>IP do Cliente:</strong> %s</p>", request.getRemoteAddr());
        out.printf("<p><strong>Protocolo:</strong> %s</p>", request.getProtocol());
        out.println("</body></html>");
    }
}
