package com.minitasempresa.minitas.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
//@EnableWebSecurity
public class SecurityConfig   {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers("/agent/**").hasRole("AGENT")
                    .requestMatchers("/analyst/**").hasRole("ANALYST")
                    .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();


//        http.authorizeHttpRequests((request) ->
//                        request
////                                .requestMatchers(new AntPathRequestMatcher("/"))
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .requestMatchers("/agent/**").hasRole("AGENT")
//                                .requestMatchers("/analyst/**").hasRole("ANALYST")
////                                .permitAll()
//                                .anyRequest()
//                                .authenticated()
//                )
//                .userDetailsService(userDetailsService)
//                .formLogin();
//        return http.build();
    }
//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("{noop}admin123").roles("ADMIN")
//                .and()
//                .withUser("agent").password("{noop}agent123").roles("AGENT")
//                .and()
//                .withUser("analyst").password("{noop}analyst123").roles("ANALYST");
//    }
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("admin@test.com").password("12345").roles("ADMIN")
                    .and()
                    .withUser("agent").password("12345").roles("AGENT")
                    .and()
                    .withUser("analyst").password("12345").roles("ANALYST");
        }
//    @Override
//    public void customize(WebSecurity web) {
//        web.ignoring().requestMatchers("/resources/**");
//    }
}
