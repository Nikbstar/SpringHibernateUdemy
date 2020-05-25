package ru.nik66.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.nik66.springdemo.entity.User;
import ru.nik66.springdemo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private UserService service;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");
        String userName = authentication.getName();
        System.out.println("userName=" + userName);
        User theUser = service.findByUserName(userName);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user", theUser);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

}
