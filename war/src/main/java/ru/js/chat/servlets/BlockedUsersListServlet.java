package ru.js.chat.servlets;


import ru.js.chat.store.BlockedUsersStore;
import ru.js.chat.store.BlockedUsersStoreHolder;
import ru.js.chat.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/blockedUsers" })
public class BlockedUsersListServlet extends BaseServlet {

    BlockedUsersStore blockedUsersStore = BlockedUsersStoreHolder.get();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = getUser(request);
        request.setAttribute("user", username);
        request.setAttribute("blockedUsers", blockedUsersStore.getAll());
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/blockedUsersList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}
