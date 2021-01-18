package ru.js.chat.filters;

import ru.js.chat.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.js.chat.utils.Constants.USERNAME_SESSION_ATTRIBUTE;

public class AuthUserFilter implements Filter {

    public void init(FilterConfig filterConfig) {
        System.out.println("AuthUserFilter initiated.");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String username = (String)httpServletRequest.getSession().getAttribute(USERNAME_SESSION_ATTRIBUTE);
        if(username == null
                && !Constants.LOGIN_URL.equals(httpServletRequest.getRequestURI())) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Constants.LOGIN_URL);
        } else if("".equals(username)){
            throw new RuntimeException("Имя пользователя не может быть пустой строкой!");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {
        System.out.println("AuthUserFilter destroyed.");
    }
}
