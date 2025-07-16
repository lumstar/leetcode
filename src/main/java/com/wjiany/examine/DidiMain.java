package com.wjiany.examine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DidiMain {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        /**
         * 输入一个整数 数组
         * 做一个全排列组合，
         *
         */
        int[] nums = new int[]{1,1,3};
        boolean[] used = new boolean[nums.length];
        br(nums,"",used,0);

        set.forEach(s-> System.out.println(s));
    }

    public static void br(int[] nums,String res,boolean[] used,int times){
        if(times == nums.length){
            set.add(res);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            br(nums,res+""+nums[i],used,times+1);
            used[i] = false;
        }

    }
}
