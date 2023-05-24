package com.minitasempresa.minitas.service;

import com.minitasempresa.minitas.jpa.entity.User;
import com.minitasempresa.minitas.jpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("USUARIO ENTRO: " + username);
        User user = userRepository.findByEmail(username).orElseThrow(
                () -> {
                    log.error("ERROR DE AUTENTICACIÓN AL INICIAR CON EL USUARIO " + username);
                    return new UsernameNotFoundException("Error de autenticación");
                }
        );

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));

        log.info("USUARIO AUTENTICADO: " + username);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }

}
