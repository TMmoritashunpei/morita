package techma.domain.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            		.antMatchers("/**").permitAll()
                    .antMatchers("/item/**").permitAll()
                    .antMatchers("/user/create").permitAll()
                    .anyRequest().authenticated()
            .and()
            .formLogin().loginProcessingUrl("/item/login")
                    .loginPage("/loginForm")
                    .failureUrl("/loginForm?error")
                    .defaultSuccessUrl("/item", true)
                    .usernameParameter("username").passwordParameter("password")
            .and()
            .logout()
            		.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
                    .logoutSuccessUrl("/loginForm");
    }
    
//    @Configuration
//    static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
//    	@Autowired
//    	UserDetailsService userDetailsService;
//    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
    
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception{
//    	auth.userDetailsSerivce(userDetailsService).passwordEncoder(passwordEncoder());
//    }
}






