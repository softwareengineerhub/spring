/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.conversion.ch01.propertyeditor;

import java.beans.PropertyEditorSupport;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Denys.Prokopiuk
 */
public class DateTimeEditor extends PropertyEditorSupport {
    
    private DateTimeFormatter dateTimeFormatter;
    
    public DateTimeEditor(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(DateTime.parse(text, dateTimeFormatter));
    }
    
}
