package com.wjiany.leetcode.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanPartition_416 {

    @Test
    public void  test(){
        System.out.println(canPartition(new int[]{3,3,3,4,5}));
    }
    int halfSum;
    boolean result =false;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i< nums.length;i++){
            sum+= nums[i];
        }
        if(sum%2==1){
            return false;
        }
        halfSum = sum/2;

//        rec(nums,0,0);

        return result;
    }


    // 回溯超时
    public void rec(int[] nums,int startIndex,int res){
        if(result){
            return;
        }
        if(startIndex == nums.length){
            if(res == halfSum){
                result = true;
            }
            return;
        }
        for(int i = startIndex;i< nums.length;i++){
            rec(nums,i+1,res+nums[i]);
        }
    }
}