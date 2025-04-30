package com.ArielMelo.API_IFood.controller;

import com.ArielMelo.API_IFood.dto.AuthRequest;
import com.ArielMelo.API_IFood.dto.AuthResponse;
import com.ArielMelo.API_IFood.dto.RegisterRequest;
import com.ArielMelo.API_IFood.entities.Usuario;
import com.ArielMelo.API_IFood.repositories.UsuarioRepository;
import com.ArielMelo.API_IFood.service.JwtService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuarioRepository.save(usuario);// Aqui você criptografa a senha

        return ResponseEntity.ok("Usuário registrado!");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest rq) {
        // autentica usando email em vez de username
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(rq.getEmail(), rq.getPassword())
        );
        String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        rq.getEmail(),
                        "",
                        Collections.emptyList()
                )
        );
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
