package ru.js.chat.servlets;

import ru.js.chat.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.js.chat.utils.Constants.USERNAME_SESSION_ATTRIBUTE;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter(USERNAME_SESSION_ATTRIBUTE);
        request.getSession().setAttribute(USERNAME_SESSION_ATTRIBUTE, parameter);
        response.sendRedirect(request.getContextPath() + Constants.MESSAGES_URL);
    }
}
