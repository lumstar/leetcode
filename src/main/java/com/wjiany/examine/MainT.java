package com.wjiany.examine;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainT {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //int line = sc.nextInt();
        int line = 1000;
        String source = Integer.toBinaryString(line);
        String toString = new StringBuilder(source).reverse().toString();
        String fun = fun("", toString);
        String result = new StringBuilder(fun).reverse().toString();
         List<String> list = new ArrayList<>();
        for (int i = 0 ; i< result.length() % 8 ;i++){
            String substring = result.substring(0, 8);
            list.add(0,substring);
            result = result.substring(8);
        }
        String hh = "";
        for (int i = 0 ; i< list.size();i++){
            hh+=list.get(i);
        }
        hh = hh+result;
        String out = null;
        if(result.length()%8 == 1){
           out = "0"+hh;
        }else {
            out = hh;
        }
        System.out.println(out);
    }
    private static String fun(String start,String res){
    if(res.length() < 8){
        return start+res;
    }
    if(res.length() == 8 && res.charAt(7) == '0'){
        return start+res;
    }
    String before = res.substring(0, 7);
    String after = res.substring(7);
    return fun(start+before+"1",after);
}
}
