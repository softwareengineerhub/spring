/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.smaple.ch01.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denis
 */
public class AppStatisticsImpl implements AppStatistics {

    @Autowired
    private AppStatistics appStatistics;

    @Override
    public int count() {
        return appStatistics.count();
    }

}
