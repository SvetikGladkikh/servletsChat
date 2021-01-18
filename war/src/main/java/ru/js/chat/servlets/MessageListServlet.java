package ru.js.chat.servlets;


import ru.js.chat.store.Message;
import ru.js.chat.store.MessageStore;
import ru.js.chat.store.MessageStoreHolder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/messages" })
public class MessageListServlet extends BaseServlet {

    MessageStore messageStore = MessageStoreHolder.get();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = getUser(request);
        boolean isAdmin = isAdmin(request);
        List<Message> messages = messageStore.getAll();
        request.setAttribute("user", username);
        request.setAttribute("messages", messages);
        request.setAttribute("isAdmin", isAdmin);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/messageList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
