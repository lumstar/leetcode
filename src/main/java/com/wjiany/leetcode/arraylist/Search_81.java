package com.wjiany.leetcode.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 *
 *
 */
public class Search_81 {

    @Test
    public void test(){
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(search_2(nums,target));
    }

    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }
    public boolean search_2(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        int mid =  nums.length/2;
        for(int i = 0;i<=mid;i++){
            if(nums[i] == target){
                return true;
            }
            if(mid+i<nums.length&&nums[mid+i]==target){
                return true;
            }
        }
        return false;
    }
}