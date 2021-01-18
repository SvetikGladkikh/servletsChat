package ru.js.chat.filters;

import ru.js.chat.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.js.chat.utils.Constants.ADMIN_USERNAME;
import static ru.js.chat.utils.Constants.USERNAME_SESSION_ATTRIBUTE;

public class AdminUserFilter implements Filter {

    public void init(FilterConfig filterConfig) {
        System.out.println("AdminUserFilter initiated.");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String username = (String)httpServletRequest.getSession().getAttribute(USERNAME_SESSION_ATTRIBUTE);
        if(!ADMIN_USERNAME.equals(username)){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Constants.MESSAGES_URL);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {
        System.out.println("AdminUserFilter destroyed.");
    }
}
