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

@WebServlet(urlPatterns = { "/unblockUser" })
public class UnblockUserServlet extends BaseServlet {

    BlockedUsersStore blockedUsersStore = BlockedUsersStoreHolder.get();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/views/unblockUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        blockedUsersStore.unblockUser(username);
        response.sendRedirect(request.getContextPath() + Constants.BLOCKED_USERS_URL);
    }
}
