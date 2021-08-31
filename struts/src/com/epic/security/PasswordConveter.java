package com.epic.security;


public class PasswordConveter{

    public static String convertPassword(String password) throws Exception{
        AES aes = new AES("gtevdywoap12gryd");
        String encdata =aes.encrypt(password);
        return encdata;
    }

}
