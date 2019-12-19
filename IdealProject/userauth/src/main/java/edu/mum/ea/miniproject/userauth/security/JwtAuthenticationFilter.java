package edu.mum.ea.miniproject.userauth.security;


import com.sun.security.auth.UserPrincipal;
import edu.mum.ea.miniproject.userauth.service.JwtTokenProvider;
import edu.mum.ea.miniproject.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{
            String jwt = getJwtFromRequest(httpServletRequest);

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                logger.info("Token is Valid ");
                String userNameFromToken = tokenProvider.getUserNameFromToken(jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(userNameFromToken);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        }


    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
