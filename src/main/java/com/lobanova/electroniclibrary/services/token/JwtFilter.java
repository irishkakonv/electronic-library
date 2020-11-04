package com.lobanova.electroniclibrary.services.token;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
            String requestTokenHeader = httpServletRequest.getHeader("Authorization");
            String username = null;
            if (Objects.nonNull(requestTokenHeader) && requestTokenHeader.startsWith("Bearer")) {
               String  token = requestTokenHeader.substring(7);
                username = tokenService.getUsernameFromToken(token);
            }
            if (Objects.nonNull(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
