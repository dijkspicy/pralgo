package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinStack {
    private final List<Integer> container = new ArrayList<>();
    private final LinkedList<Integer> minValueIndexes = new LinkedList<>();
    private int index = -1;
    private Integer minValue;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        this.container.add(x);
        this.index++;

        for (int i = 0; i < this.minValueIndexes.size(); i++) {
            Integer minValue = this.container.get(this.minValueIndexes.get(i));
            if (minValue > x) {
                this.minValueIndexes.add(i, this.index);
                break;
            }
        }
        this.minValueIndexes.add(this.index);

        this.minValue = this.container.get(this.minValueIndexes.get(0));
    }

    public void pop() {
        if (this.index < 0) {
            return;
        }
        this.minValueIndexes.removeIf(it -> it == this.index);
        this.container.remove(this.index--);

        if (this.index >= 0) {
            this.minValue = this.container.get(this.minValueIndexes.get(0));
        }
    }

    public int top() {
        this.ensureHasValue();
        return this.container.get(this.index);
    }

    public int getMin() {
        this.ensureHasValue();
        return this.minValue;
    }

    private void ensureHasValue() {
        if (this.index < 0) {
            throw new UnsupportedOperationException();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
