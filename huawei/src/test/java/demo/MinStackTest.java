package demo;

import org.junit.Test;

public class MinStackTest {
    @Test
    public void should_return() {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());
    }

    @Test
    public void should2() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.
    }
}