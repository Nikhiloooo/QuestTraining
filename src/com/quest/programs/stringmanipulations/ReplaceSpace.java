package com.quest.programs.stringmanipulations;

public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "This is a test";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c==' ') {
                sb.append("%20");

            }
            else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
