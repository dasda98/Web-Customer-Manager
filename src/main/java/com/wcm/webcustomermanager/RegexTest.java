package com.wcm.webcustomermanager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?<=id=)(\\d+)(?=,)");
        Matcher matcher = pattern.matcher("Product={id=15, name='Router', price=133.99}");

        if (matcher.find()) {
            System.out.println("find");
            String s = matcher.group(0);
            System.out.println(s);
        } else {
            System.out.println("dupa");
        }
    }
}
