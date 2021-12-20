package com.example.coviddataquery.security.config;

import com.example.coviddataquery.security.filter.TokenAuthenticationFilter;
import com.example.coviddataquery.security.jwt.TokenHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
@RequiredArgsConstructor
@Slf4j
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtProperties jwtProperties;
    private final UserDetailsService userDetailsService;
    private final TokenHelper tokenHelper;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] permitAllPaths = jwtProperties.getPermitAllPaths().toArray(new String[0]);
        log.debug("base-path: " + jwtProperties.getBasePath());
        log.debug("permitAllPaths: " + Arrays.toString(permitAllPaths));

        http.exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .antMatcher(jwtProperties.getBasePath())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(permitAllPaths).permitAll()
                .and()
                .addFilterBefore(tokenAuthenticationFilter(), BasicAuthenticationFilter.class);
        http.csrf().disable();
    }

    private TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter(tokenHelper, userDetailsService);
    }
}
