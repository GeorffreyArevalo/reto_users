package com.backend.core.users.domain.spi;

public interface PasswordEncoderPort {
    
    Boolean validate(String password, String encodePassword);

    String encode(String password);

}
