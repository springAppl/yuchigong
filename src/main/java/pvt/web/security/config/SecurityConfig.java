package pvt.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pvt.web.security.security.FingerPrintAuthenticationProvider;
import pvt.web.security.security.FingerPrintFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FingerPrintAuthenticationProvider fingerPrintAuthenticationProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new FingerPrintFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(fingerPrintAuthenticationProvider)
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/api/security/test")
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public FingerPrintAuthenticationProvider fingerPrintAuthenticationProvider(){
        return new FingerPrintAuthenticationProvider();
    }

}
