package com.quest.programs.stringmanipulations;

public class ReverseWithoutSpecialChar {
    public static void main(String[] args) {
        String str = "abc!$@jkl*";
        String reversed = reversed(str);
        System.out.println(reversed);
    }

    public static String reversed(String str) {
        char[] chars = str.toCharArray();
        int left =0;
        int right =chars.length - 1;
        while (left < right) {
            if (!(chars[left]>= 'a' && chars[left] <= 'z' || chars[left] >= 'A' && chars[left] <='Z' || chars[left] >= '0' && chars[left] <= '9')) {
                left++;

            } else if (!(chars[right] >= 'a' && chars[right] <= 'z' || chars[right] >= 'A' && chars[right] <= 'Z' || chars[right] >= '0' && chars[right] <= '9')) {
                right--;
            }
            else{
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
