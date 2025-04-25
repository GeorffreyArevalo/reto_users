package com.backend.core.users.domain.spi;

import com.backend.core.users.domain.models.UserModel;

public interface TokenAuthenticatePort {
    
    String createToken( UserModel userModel );

    String validateToken(String token);

}
