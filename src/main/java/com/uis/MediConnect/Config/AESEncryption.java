package com.uis.MediConnect.Config;

import com.google.common.hash.Hashing;
import com.google.common.primitives.Bytes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class AESEncryption {

    private final String textoSecreto;

    public AESEncryption(String texto) {
        this.textoSecreto = texto;
    }


    private SecretKey generarSecretKey(){
        byte[] textoBytes = textoSecreto.getBytes(StandardCharsets.UTF_8);

        byte[] hash = Hashing.sha256().hashBytes(textoBytes).asBytes();
        final int maxLength = 256 / Byte.SIZE;
        byte[] key = Bytes.ensureCapacity(hash, maxLength, 0);

        SecretKey secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }

    public  String cifrar(String mensajeOriginal) throws Exception {


        SecretKey secretKey = generarSecretKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);


        byte[] cipherText = cipher.doFinal(mensajeOriginal.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public  String descifrar(String mensajeCifrado) throws Exception {

        byte[] cipherText = Base64.getDecoder().decode(mensajeCifrado);

        SecretKey secretKey = generarSecretKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedText = cipher.doFinal(cipherText);
        return new String(decryptedText, "UTF-8");
    }
}
