package com.wjiany.leetcode.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue_406 {

    public int[][] reconstructQueue(int[][] people) {


        Arrays.sort(people, (o1, o2) -> {
           int i =  o2[0]- o1[0];
           if(i == 0){
               return o1[1]- o2[1];
           }
           return i;
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1],people[i]);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = list.get(i);
        }
        int[][] array = list.toArray(new int[list.size()][2]);
        return people;
    }

}
