/**
 * Created by Chiru on Jan 21, 2017
 */
package cci;

//Sort the stack using only one extra stack [smallest on top always]

public class SortStack {

    public static void main(String[] args) {

        MyStack<Integer> stack1 = new MyStack<>();

        stack1.push(66);
        stack1.push(44);
        stack1.push(22);
        stack1.push(77);
        stack1.push(11);
        stack1.push(33);
        stack1.push(55);

        sortStack(stack1);
    }

    public static void sortStack(MyStack<Integer> s) {

        MyStack<Integer> r = new MyStack<>();

        while (!s.isEmpty()) {
            int temp = s.pop();

            while (!r.isEmpty() && temp < r.peek()) {
                s.push(r.pop());
            }

            r.push(temp);
        }

        while (!r.isEmpty()) {
            s.push(r.pop());
        }

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}