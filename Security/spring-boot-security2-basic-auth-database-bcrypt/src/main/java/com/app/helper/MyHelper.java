/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.helper;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
public class MyHelper {

    private final int logRounds = 1;

    
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /*public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }*/


}
