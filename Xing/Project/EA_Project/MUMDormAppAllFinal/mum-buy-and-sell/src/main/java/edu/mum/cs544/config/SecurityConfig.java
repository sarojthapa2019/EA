//package edu.mum.cs544.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("test@test.com").password("test").roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(RestAuthenticationEntryPoint)
//                .and()
//                .authorizeRequests()
//                .antMatchers("").authenticated()
//                .antMatchers("").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .successHandler()
//                .failureHandler()
//                .and()
//                .logout();
//
//    }
//
//}
