/**
 * Created by Chiru on Jan 11, 2017
 */
package cci;

public class TestStack {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("After pop:" + stack.peek());
        stack.pop();
        System.out.println("After pop:" + stack.peek());
        stack.pop();
        System.out.println("After pop:" + stack.peek());
        stack.pop();
        stack.push(40);
        System.out.println("After pop:" + stack.peek());
    }
}