
import java.lang.reflect.Array;

public class Stackk<T> {
    private T[] stack;
    private int top;
    private int size;

    public Stackk(int size, Class<T> clazz) {
        this.stack = (T[]) Array.newInstance(clazz, size);
        this.top = 0;
        this.size = size;
    }

    // O(1)
    public void push(T data) {
        if (isFull()) {
            return;
        }
        stack[top] = data;
        top++;
    }

    // O(1)
    public T pop() {
        if (top == 0) {
            return null;
        }
        T data = stack[top - 1];
        top--;
        return data;
    }

    // O(1)
    public T peek() {
        return stack[top - 1];
    }

    public boolean isFull() {
        return size - 1 == top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean hasSpace() {
        return !isFull();
    }

}

