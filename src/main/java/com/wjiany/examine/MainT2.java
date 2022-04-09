package com.wjiany.examine;


import java.util.*;

public class MainT2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = s.substring(0,1);
        String tmp = s.substring(0,1);
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i-1)){
                tmp += s.substring(i,i+1);
                if(tmp.length() > res.length()){
                    res = new String(tmp);
                }
            }else {
                tmp = s.substring(i,i+1);
            }
        }
        if(res.startsWith("1")){
            res = res.substring(1);
        }
        System.out.println(res);
    }

}
