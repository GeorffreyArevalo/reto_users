package com.backend.core.users.infrastructure.adapters;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.core.users.domain.spi.PasswordEncoderPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PasswordEncoderAdapter implements PasswordEncoderPort{

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Boolean validate(String password, String encodePassword) {
        return passwordEncoder.matches(password, encodePassword);
    }

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
    
}
