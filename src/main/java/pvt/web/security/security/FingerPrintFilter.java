package pvt.web.security.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class FingerPrintFilter implements Filter {

    private AuthenticationManager authenticationManager;

    public FingerPrintFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        if (!Objects.equals("/api/login", servletRequest.getRequestURI())){
            chain.doFilter(request, response);
            return;
        }
        CustomAuthentication authentication = new CustomAuthentication(
                request.getParameter("account"),
                request.getParameter("password")
        );
        Authentication auth;
        try {
            auth = authenticationManager.authenticate(authentication);
        }catch (Exception e) {
            servletResponse.sendRedirect("/login.html");
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Override
    public void destroy() {

    }
}
