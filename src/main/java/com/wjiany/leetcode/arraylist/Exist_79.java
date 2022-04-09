package com.wjiany.leetcode.arraylist;

import org.junit.Test;

public class Exist_79 {
    /*
    SEE
    ABCB
    'A','B','C','E'
    'S','F','C','S'
    'A','D','E','E'
     */
    @Test
    public void test(){
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(exist(board,i,j,word,0,isUsed)){
                    return true;
                }
            }
        }
       return false;
    }
    private boolean exist(char[][] board ,int x,int y,String word,int index,boolean[][] isUsed) {
        if(index == word.length()){
            return true;
        }
        if(x < 0 || x >= board.length){
            return false;
        }
        if(y < 0 || y>= board[0].length){
            return false;
        }
        if(isUsed[x][y]){
            return false;
        }
        isUsed[x][y] = true;
        boolean continueExit = (board[x][y] == word.charAt(index)) && (
                exist(board, x + 1, y, word, index + 1,isUsed) ||
                        exist(board, x - 1, y, word, index + 1,isUsed) ||
                        exist(board, x, y + 1, word, index + 1,isUsed) ||
                        exist(board, x, y - 1, word, index + 1,isUsed)
        );
        isUsed[x][y] = false;
        return continueExit;
    }
}