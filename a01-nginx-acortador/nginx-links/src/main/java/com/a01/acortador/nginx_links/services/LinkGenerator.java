package com.a01.acortador.nginx_links.services;

import java.security.SecureRandom;


import org.springframework.stereotype.Component;

@Component 
public class LinkGenerator {
    private final static String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final static int longitud = 7;
    
    
    private final SecureRandom random = new SecureRandom();

    public String next(){
        StringBuilder code = new StringBuilder(longitud);
        for (int i= 0; i<=longitud; i++){
            code.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return code.toString();
    }
}
