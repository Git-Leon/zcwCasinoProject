package com.github.curriculeon.tools;

/**
 * Created by leon on 2/25/18.
 */
public class StringUtils {
    public static String repeatString(String str, int numberOfTimes) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numberOfTimes; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
