package pvt.web.security.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Objects;

public class FingerPrintAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication customAuthentication = (CustomAuthentication) authentication;
        if (!Objects.equals("finger-print", customAuthentication.getFingerPrint())) {
            throw new BadCredentialsException(customAuthentication.getFingerPrint());
        }
        if (!Objects.equals("123456", customAuthentication.getPassword())) {
            throw new BadCredentialsException(customAuthentication.getPassword());
        }
        return customAuthentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Objects.equals(aClass, CustomAuthentication.class);
    }
}
