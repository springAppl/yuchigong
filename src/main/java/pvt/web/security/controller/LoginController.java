package pvt.web.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestParam(value = "account") String account,
                      @RequestParam(value = "password") String password,
                      HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        if (!Objects.equals("lee", account)) {
            response.sendRedirect("/login.html");
            return;
        }
        if (!Objects.equals("123456", password)) {
            response.sendRedirect("/login.html");
            return;
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("name", account);
        session.setMaxInactiveInterval(30 * 60);
//        Authentication authentication = new CustomAuthentication(account);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


}
