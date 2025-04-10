package com.wjiany.leetcode.design;

import org.junit.Test;

import java.util.*;

public class MinStack_155 {
    @Test
    public void  test(){
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
      stack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        minStack.push(Math.min(minStack.peek(),val));
        stack.push(val);
    }

    public void pop() {
     stack.pop();
     minStack.pop();

    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}

/**

 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */