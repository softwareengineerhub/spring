/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch05.throwsadvice;

/**
 *
 * @author Denys.Prokopiuk
 */
public class ErrorBean {

    public void errorProneMethod() throws Exception {
        throw new Exception("Generic exception");
    }

    public void otherErrorProneMethod() {
        throw new IllegalArgumentException("IllegalArgument Exception");
    }

}
