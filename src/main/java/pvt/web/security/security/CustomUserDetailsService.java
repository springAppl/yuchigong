package pvt.web.security.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (!Objects.equals("lee", s)) {
            throw new UsernameNotFoundException(s);
        }
        UserDetails userDetails = new CustomUserDetails(s, "123456");
        return userDetails;
    }
}
