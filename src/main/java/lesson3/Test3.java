package lesson3;

import lesson3.deque.Deque;
import lesson3.deque.DequeImpl;
import lesson3.queue.PriorityQueueImpl;
import lesson3.queue.Queue;
import lesson3.queue.QueueImpl;
import lesson3.stack.Stack;
import lesson3.stack.StackImpl;


public class Test3 {

    public static void main(String[] args) {
//        testStack();
//        testQueue();
        testDeque();
    }

    private static void testDeque() {
        Deque<Integer> deque = new DequeImpl<>(3);
        deque.insertRight(1);
        System.out.println(deque);
        deque.insertRight(2);
        System.out.println(deque);
        deque.insertRight(3);
        System.out.println(deque);
        System.out.println("deque.removeLeft() = " + deque.removeLeft());
        System.out.println(deque);
        System.out.println("deque.removeRight() = " + deque.removeRight());
        System.out.println(deque);

        deque.insertRight(10);
        deque.insertLeft(9);
        System.out.println(deque);
        deque.removeLeft();
        deque.removeLeft();
        deque.removeLeft();
        System.out.println(deque);
        System.out.println("deque.peekFront() = " + deque.peekFront());

    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);
        if (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println(addToStack(stack, 12));
        System.out.println(addToStack(stack, 16));
        System.out.println(addToStack(stack, 22));
        System.out.println(addToStack(stack, 5));
        System.out.println(addToStack(stack, 1));
        System.out.println(addToStack(stack, 32));

        stack.display();

        System.out.println("top value: " + stack.pop() );
        System.out.println("top value: " + stack.peek() );
        stack.display();
    }

    private static boolean addToStack(Stack<Integer> stack, int num) {
        if (!stack.isFull()) {
            stack.push(num);
            return true;
        }
        return false;
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
        Queue<Integer> queue = new PriorityQueueImpl<>(5);
        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();

    }

}
