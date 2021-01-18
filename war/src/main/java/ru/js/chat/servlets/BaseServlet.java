package ru.js.chat.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static ru.js.chat.utils.Constants.ADMIN_USERNAME;
import static ru.js.chat.utils.Constants.USERNAME_SESSION_ATTRIBUTE;

public abstract class BaseServlet extends HttpServlet {
    protected String getUser(HttpServletRequest request){
        String username = (String) request.getSession().getAttribute(USERNAME_SESSION_ATTRIBUTE);
        if(username == null || "".equals(username)){
            throw new RuntimeException("Имя пользователя не может быть пустым!");
        }

        return username;
    }

    protected boolean isAdmin(HttpServletRequest request){
        return ADMIN_USERNAME.equals(getUser(request));
    }
}
