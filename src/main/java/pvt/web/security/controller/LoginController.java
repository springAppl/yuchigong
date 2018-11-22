package pvt.web.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pvt.web.security.exception.CustomException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestParam(value = "account") String account,
                      @RequestParam(value = "password") String password,
                      HttpServletRequest request){
        if (!Objects.equals("lee", account)) {
            throw new CustomException(HttpStatus.FORBIDDEN, "account password not match");
        }
        if (!Objects.equals("123456", password)) {
            throw new CustomException(HttpStatus.FORBIDDEN, "account password not match");
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("name", account);
        session.setMaxInactiveInterval(30 * 60);
//        Authentication authentication = new CustomAuthentication(account);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


}
