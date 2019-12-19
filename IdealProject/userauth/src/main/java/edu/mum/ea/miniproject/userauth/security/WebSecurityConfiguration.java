package edu.mum.ea.miniproject.userauth.security;

import edu.mum.ea.miniproject.userauth.service.InvalidLoginAttemptHandler;
import edu.mum.ea.miniproject.userauth.service.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private UserServiceImpl userAuthDetailsService;
    @Autowired
    private InvalidLoginAttemptHandler invalidLoginAttemptHandler;
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
//    @Autowired
//    private DataSource dataSource;
//
//    @Value("${spring.queries.users-query}")
//    private String usersQuery;
//
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
//        auth.
//                jdbcAuthentication()
//                .usersByUsernameQuery(usersQuery)
//                .authoritiesByUsernameQuery(rolesQuery)
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder());

        auth.userDetailsService(userAuthDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(invalidLoginAttemptHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/user/**")
                .permitAll()

                .anyRequest().authenticated()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/login").and().exceptionHandling();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/resources/*", "/static/templates/**", "/static/css/*", "/static/js/*");
    }



}
