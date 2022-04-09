package com.wjiany.leetcode.Array2P;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveDuplicates_80 {

    @Test
    public void test(){
        int[] ints = {1, 2, 2, 2,3};
        System.out.println(removeDuplicates(ints));
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        int slow = 0, fast = 1, count = 0;

        while(fast < len){
            if(nums[fast] == nums[slow]){
                count++;
                if(count < 2) {                  //此处的判断可以适用于任何情况，取多少位相同的数都行
                    nums[++slow] = nums[fast];
                }
                fast++;
            }
            else{
                nums[++slow] = nums[fast++];
                count = 0;
            }
        }
        return slow+1 ;
    }
}
