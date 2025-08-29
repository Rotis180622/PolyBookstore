/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectone.util;

import java.util.regex.Pattern;

/**
 *
 * @author whath
 */
public class XVali {

    public static boolean checkspace(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean usernamedangnhap(String gmail) {
        if (gmail == null || gmail.trim().isEmpty()) {
            return false;
        }
        String Regex = "^[\\w.]+@[\\w.]+\\.[a-zA-Z]{1,2}$";
               if (gmail.matches(Regex)) {
            return true;
        }
               return false;
    }

    public static boolean checkDouble(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        try {
        Double.valueOf(text);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
    }

    public static boolean checkInteger(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.valueOf(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkloai(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        String regex = "^[A-Z]00\\d+";
        if (text.matches(regex)) {
            return true;
        }
        return false;
    }

    public static boolean checktenloai(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        String Regex = "^[a-zA-Z]+$";
        if (text.matches(Regex)) {
            return true;
        }
        return false;
    }

    public static boolean checktime(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        if (XDate.parse(text, XDate.PATTERN_FULL) == null) {
            return false;
        }
        return true;
    }
    
    public static boolean checkidThe(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
         String Regex = "^100\\d+";
        if (text.matches(Regex)) {
            return true;
        }
        return false;
    }

    

}
