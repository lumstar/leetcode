package com.wjiany.leetcode.Array2P;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2361969/215-shu-zu-zhong-de-di-k-ge-zui-da-yuan-d786p/
 */
public class FindKthLargest_215 {
    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue(k);
        int length = nums.length;
        for (int i = 0;i<length;i++){
            if(queue.size()<k){
                queue.add(nums[i]);
            }else if(queue.size() == k && nums[i] > queue.peek()){
                queue.remove();
                queue.add(nums[i]);
            }
        }
        return queue.remove();
    }
    public int findKthLargest(int[] nums, int k) {

        return Arrays.stream(nums).sorted().toArray()[nums.length-k];
    }
}
