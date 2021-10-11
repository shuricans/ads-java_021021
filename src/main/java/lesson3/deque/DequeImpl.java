package lesson3.deque;

public class DequeImpl<E> implements Deque<E> {
    @Override
    public boolean insertLeft(E value) {
        return false;
    }

    @Override
    public boolean insertRight(E value) {
        return false;
    }

    @Override
    public E removeLeft() {
        return null;
    }

    @Override
    public E removeRight() {
        return null;
    }

    @Override
    public boolean insert(E value) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {

    }
}
