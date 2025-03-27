package com.wjiany.leetcode.string;


import org.junit.Test;

public class LongestCommonPrefix_14 {
    @Test
    public void test() {
        System.out.println(longestCommonPrefixee(new String[]{"dog", "dacecar", "dar"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }
        String str = strs[0];
        String res = "";
        String tmp = "";
        for (int j = str.length(); j > 0; j--) {
            tmp = str.substring(0, j);
            int time = 0;
            for (int i = 1; i < length; i++) {
                if (strs[i].startsWith(tmp)) {
                    time++;
                }
                if (time == length - 1) {
                    res = tmp;
                    return res;
                }
            }
        }
        return res;
    }

    public String longestCommonPrefixee(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }
        int size = strs.length;
        int index = 0;
        String res = "";


        while (true) {
            int times = 0;
            for (int i = 1; i < size; i++) {

                if (index < strs[0].length() && index < strs[i].length()) {

                    if (strs[0].charAt( index) == (strs[i].charAt(index))) {

                        times++;
                    } else {
                        return res;
                    }
                } else {
                    return res;
                }

            }
            if (times == size - 1) {
                res += strs[0].charAt(index);
            }
            index++;
        }


    }
}
