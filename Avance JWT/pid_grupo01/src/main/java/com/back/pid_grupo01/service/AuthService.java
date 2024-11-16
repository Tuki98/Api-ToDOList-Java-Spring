package com.back.pid_grupo01.service;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.back.pid_grupo01.jwt.JwtService;
import com.back.pid_grupo01.model.AuthResponse;
import com.back.pid_grupo01.model.LoginRequest;
import com.back.pid_grupo01.model.RegisterRequest;
import com.back.pid_grupo01.model.Usuario;
import com.back.pid_grupo01.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final UsuarioRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user=userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
            .nombre(request.getNombre())
            .apellido(request.getApellido())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .fecha(new Date())
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }
}
