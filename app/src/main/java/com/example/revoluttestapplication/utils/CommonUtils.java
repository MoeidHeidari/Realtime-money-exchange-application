package com.example.revoluttestapplication.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * common useful utilities
 *
 * @author moeidheidari
 * @version 1.0
 */

public class CommonUtils
{
    /**
     * this method gets a string as an input and perform a pattern on the given string to check if it is a well formed currency
     * input or not. if it was it returns true and otherwise returns false
     * @param input
     * @return boolean
     */
    public static boolean isCurrancyValid(String input)
    {
        String pattern = "^([0-9]{0,4}((.)[0-9]{0,3}))$"; // 4 digits followe by . followed by 2 digits
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);
        if(m.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
