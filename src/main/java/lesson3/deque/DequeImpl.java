package lesson3.deque;

public class DequeImpl<E> implements Deque<E> {

    protected final E[] data;
    protected int size;

    protected int head;
    protected int tail;

    private final int HEAD_DEFAULT = 0;
    private final int TAIL_DEFAULT = 0;

    public DequeImpl(int maxSize) {
        data = (E[])new Object[maxSize];
        head = HEAD_DEFAULT;
        tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = HEAD_DEFAULT;
            tail = TAIL_DEFAULT;
            data[head] = value;
        } else if (head == HEAD_DEFAULT) { // if head is first in data
            head = data.length - 1;
            data[head] = value;
        } else {
            data[--head] = value;
        }
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = HEAD_DEFAULT;
            tail = TAIL_DEFAULT;
            data[head] = value;
        } else if (tail == data.length - 1) { // if tail is last in data
            tail = TAIL_DEFAULT;
            data[tail] = value;
        } else {
            data[++tail] = value;
        }
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        E value;

        // if head is last in array
        if (head == data.length - 1) {
            value = data[head];
            head = HEAD_DEFAULT;
        } else {
            value = data[head++];
        }
        size--;

        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        E value;

        // if tail is first in array
        if (tail == 0) {
            value = data[tail];
            tail = data.length - 1;
        } else {
            value = data[tail--];
        }
        size--;

        return value;
    }

    @Override
    public boolean insert(E value) {
        return insertLeft(value);
    }

    @Override
    public E remove() {
        return removeLeft();
    }

    @Override
    public E peekFront() {
        if (!isEmpty()) {
            return data[head];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        int count = size;
        int index = head;
        while (count > 0) {
            // if out of bound
            if (index == data.length) {
                index = 0;
            }
            sb.append(data[index]);
            if (count > 1) {
                sb.append(", ");
            }
            index++;
            count--;
        }

        return sb.append("]").toString();
    }
}
