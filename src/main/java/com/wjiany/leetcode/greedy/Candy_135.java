package com.wjiany.leetcode.greedy;

import org.junit.Test;

public class Candy_135 {

    @Test
    public void  test(){
        System.out.println(candy(new int[]{1,0,2}));
    }

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for(int i=1;i< ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }else{
                candy[i] = 1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            System.out.println("sss"+i);
            if(ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i+1]+1,candy[i]);
            }
        }
        int sum = 0;
        for(int i =0;i< candy.length;i++){
            sum += candy[i];
        }
        return sum;
    }
}
