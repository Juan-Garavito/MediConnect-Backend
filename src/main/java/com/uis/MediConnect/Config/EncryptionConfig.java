package com.uis.MediConnect.Config;

import com.uis.MediConnect.Config.AESEncryption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {

    @Value("${secretKey.AES}")
    private String textoSecreto;

    @Bean
    public AESEncryption instanceEncryptionAES(){
        return new AESEncryption(textoSecreto);
    }
}
