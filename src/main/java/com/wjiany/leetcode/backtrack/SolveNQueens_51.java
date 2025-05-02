package com.wjiany.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens_51 {
        boolean[] col = null;  //这一列有没有Queen
        boolean[] left = null;//次对角线有没有
        boolean[] right = null; //主对角线有没有Q   一共 2n-1个主对角线
        List<List<String>> ret = new ArrayList<>();

        //看的答案
        public List<List<String>> solveNQueens(int n) {
            col = new boolean[n];
            left = new boolean[2*n-1];
            right = new boolean[2*n-1];
            char[][] board = new char[n][n];
            backTrack(board, 0, n);
            return ret;
        }

        private void backTrack(char[][] board, int r, int n) {
            if (r >= n) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    list.add(new String(board[i]));
                }
                ret.add(list);
                return;
            }
            Arrays.fill(board[r], '.');
            for (int i = 0; i < n; i++) {  //对于行r 遍历每一列i
                //对于所有的主对角线有 行号 - 列号 = 常数，对于所有的次对角线有 行号 + 列号 = 常数
                if (!col[i] && !left[r + i] && !right[r - i + n - 1]) {
                    board[r][i] = 'Q';
                    col[i] = true;
                    left[r + i] = true;
                    right[r - i + n - 1] = true;
                    backTrack(board, r + 1, n);
                    board[r][i] = '.';
                    col[i] = false;
                    left[r + i] = false;
                    right[r - i + n - 1] = false;
                }
            }
        }



        @Test
        public void  test(){
            System.out.println(solveNQueens_(4));
        }

    /**
     * 方法 2 ，使用used 来存储是否已经使用过
     */
    List<List<String>>  lists = new ArrayList<>();

    public List<List<String>> solveNQueens_(int n) {
        rec(new boolean[n][n],0,new ArrayList<>(),n);
        return lists;
    }
    public void rec(boolean[][] used,int deep,List<String> list,int n){

        if(deep == n){
            lists.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<n;i++){
            StringBuilder str = new StringBuilder();
            if(check(deep,i,used)){
                for(int f= 0;f<n;f++){
                    str.append(".");
                }

                str.setCharAt(i,'Q');
                used[deep][i] = true;
            }else {
                continue;
            }
            list.add(str.toString());
            rec(used,deep+1,list,n);
            list.remove(list.size()-1);
            used[deep][i] = false;

        }
    }

    /**
     *
     * @param x
     * @param y
     * @param used
     * @return
     */
    public  boolean check(int x,int y,boolean[][] used){

        for(int i = 0;i< used.length;i++){
            for(int j = 0;j<used[0].length;j++){
                if(used[i][j]){
                    // 注意这里应该使用绝对值，因为前后左右都需要判断是否相等
                    if(x==i || j==y || (Math.abs(x-i)==Math.abs(y-j))){
                        return false;
                    }
                }
            }
        }
        return true;

    }
}