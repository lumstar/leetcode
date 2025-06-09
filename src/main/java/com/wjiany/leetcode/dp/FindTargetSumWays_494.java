package com.wjiany.leetcode.dp;

import org.junit.Test;

public class FindTargetSumWays_494 {

    @Test
    public void  test(){
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
       // rec(nums,target,nums.length,nums.length,0,0);
        return ans;
    }

    /**
     * 回溯
     * @param nums
     * @param target
     * @param addNum
     * @param subNum
     * @param res
     * @param startIndex
     */
    public void rec(int[] nums,int target,int addNum,int subNum,int res,int startIndex){
        if((addNum+subNum) == nums.length){
            if(res == target){
                ans++;
            }
            return;
        }
        for(int i = startIndex;i<nums.length;i++){
            rec(nums,target,addNum-1,subNum,res+nums[i],i+1);
            rec(nums,target,addNum,subNum-1,res-nums[i],i+1);
        }
    }
}