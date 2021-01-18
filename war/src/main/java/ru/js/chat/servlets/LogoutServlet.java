package ru.js.chat.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = getUser(request);
        request.getSession().invalidate();
        request.setAttribute("user", username);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/logout.jsp");
        dispatcher.forward(request, response);
    }
}
