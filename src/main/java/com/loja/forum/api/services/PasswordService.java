package com.loja.forum.api.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordService {
    
    public static String encoder(String senha){
        return new BCryptPasswordEncoder().encode(senha);
    }


}
