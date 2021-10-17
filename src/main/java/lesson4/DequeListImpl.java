package lesson4;

import lesson3.deque.Deque;

public class DequeListImpl<E> implements Deque<E> {

    protected Node<E> first;
    protected Node<E> last;
    protected int size;

    @Override
    public boolean insertLeft(E value) {

        Node<E> newNode;

        if (isEmpty()) {
            newNode = new Node<>(value, null, null);
            first = newNode;
            last = newNode;
        } else {
            newNode = new Node<>(value, first, null);
            first.prev = newNode;
            first = newNode;
        }

        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {

        Node<E> newNode;

        if (isEmpty()) {
            newNode = new Node<>(value, null, null);
            first = newNode;
            last = newNode;
        } else {
            newNode = new Node<>(value, null, last);
            last.next = newNode;
            last = newNode;
        }

        size++;

        return true;
    }

    @Override
    public E removeLeft() {

        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = removedNode.next;
            first.prev = null;
            removedNode.next = null;
            removedNode.prev = null;
        }
        size--;

        return removedNode.item;
    }

    @Override
    public E removeRight() {

        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = last;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = removedNode.prev;
            last.next = null;
            removedNode.next = null;
            removedNode.prev = null;
        }
        size--;

        return removedNode.item;
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
        if (isEmpty()) {
            return null;
        }
        return first.item;
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
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = first;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
