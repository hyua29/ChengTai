package web.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override  // pass user and roles
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("John").password("123").roles("Admin");
        auth.inMemoryAuthentication().withUser("Ben").password("1234").roles("Manager");
        auth.inMemoryAuthentication().withUser("Susan").password("123").roles("Client");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and()
                .formLogin().loginPage("/login")    // loginPage MUST be the same as the mapping in ControllerClass
                .loginProcessingUrl("/authenticateTheUser") // loginProcessUrl is in-build
                .permitAll()                                // anyone can access the login form
                .and().logout().permitAll();
    }
}
