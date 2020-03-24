package com.nusaregex.controller;

import java.util.regex.*;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;



public class ControlValidation {
    
    private Pattern pattern;
    private Matcher matcher;
    
    private static ControlValidation INSTANCE = new ControlValidation();
    
    private String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9]+$";
    
    private String NAME_PATTERN = "^[\\p{L} .'-]+$";
    private String NUMERIC_PATTERN = "^[0-9]+$";
    
    private static String PASSWORD_PATTERN = null;
    
    private String PHONE_NUMBER_PATTERN = "^\\+(?:[0-9] ?){6,14}[0-9]$";
    
    private String DATE_PATTERN = "^(?:[0-9][0-9])?[0-9][0-9]-[0-3][0-9]-[0-3][0-9]$";
    
    public ControlValidation() {
        // do nothing...
    }
    
    public static ControlValidation buildPasswordRule( boolean forceSpecialChar,
                                                boolean forceCapitalLetter,
                                                boolean forceNumber,
                                                int minLength,
                                                int maxLength)
    {
        StringBuilder patternBuilder = new StringBuilder("(?=.*[a-z])(?=\\S+$)");
        if (forceSpecialChar)
        {
            patternBuilder.append("(?=.*[@#$%])");
        }
 
        if (forceCapitalLetter)
        {
            patternBuilder.append("(?=.*[A-Z])");
        }
 
        if (forceNumber)
        {
            patternBuilder.append("(?=.*[0-9])");
        }
 
        patternBuilder.append(".{" + minLength + "," + maxLength + "}");
        PASSWORD_PATTERN = patternBuilder.toString();
        return INSTANCE;
    }
    
    public boolean isValidEmail(String val){
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    
    public boolean isValidName(String val) {
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    
    public boolean isValidNIK(String val)   {
        pattern = Pattern.compile(NUMERIC_PATTERN);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    
    public boolean isValidUsername(String val) {
        pattern = Pattern.compile(ALPHANUMERIC_PATTERN);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    
    public static boolean isValidPassword(final String val) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(val);
        return matcher.matches();
    }
    
    public boolean isValidPhoneNumber(String val) {
        pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    
    public boolean isValidDate(String val){
        pattern = Pattern.compile(DATE_PATTERN);
        matcher = pattern.matcher(val);
        return matcher.matches();
    }
    
    
}
