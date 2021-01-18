package ru.js.chat.servlets;

import ru.js.chat.store.Message;
import ru.js.chat.utils.Constants;
import ru.js.chat.store.MessageStore;
import ru.js.chat.store.MessageStoreHolder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = { "/newMessage" })
public class NewMessageServlet extends BaseServlet {

    MessageStore messageStore = MessageStoreHolder.get();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = getUser(request);
        request.setAttribute("user", username);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/newMessage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = getUser(request);
        String text = request.getParameter("message");
        Message message = new Message(new Date(), username, text);
        messageStore.addMessage(message);
        response.sendRedirect(request.getContextPath() + Constants.MESSAGES_URL);
    }
}
