package ru.js.chat.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/blockedUserMessage" })
public class BlockedUserMessageServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = getUser(request);
        request.getSession().invalidate();
        request.setAttribute("user", username);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/blockedUserMessage.jsp");
        dispatcher.forward(request, response);
    }
}
