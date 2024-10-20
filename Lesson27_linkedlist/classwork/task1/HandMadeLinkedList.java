package Lesson27_LinkedList.classwork.task1;

import java.util.NoSuchElementException;

public class HandMadeLinkedList<T> {

    class Node<E> {
        public E data;
        public Node<E> next;
        public Node<E> prev;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }


    /**
     * Указатель на первый элемент списка. Он же first
     */
    private Node<T> head;

    /**
     * Указатель на последний элемент списка. Он же last
     */
    private Node<T> tail;

    private int size = 0;

    public void addFirst(T element) {
        final Node<T> oldHead = head;
        final Node<T> newNode = new Node<>(null, element, oldHead);
        head = newNode;
        if (oldHead == null)
            tail = newNode;
        else
            oldHead.prev = newNode;
        size++;
    }

    public T getFirst() {
        final Node<T> curHead = head;
        if (curHead == null)
            throw new NoSuchElementException();
        return head.data;
    }

    public void addLast(T element) {
        final Node<T> oldTail = tail;
        final Node<T> newNode = new Node<>(oldTail, element, null);
        tail = newNode;
        if (oldTail == null) {
            head = tail;
        } else {
            oldTail.next = newNode;
        }
        size++;
    }

    public T getLast() {
        final Node<T> curTail = tail;
        if (curTail == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current;
        if (index < (size / 2)) {
            current = head;
            for (int i = 0; i < size / 2; i++) {
                if (i == index) {
                   return current.data;
                }
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size; i > size/2; i--) {
                if (i == index) {
                    return current.data;
                }
                current = current.prev;
            }
        }
        return null;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size) {
            addLast(element);
            return;
        }

        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                final Node<T> newNode = new Node<>(current.prev, element, current.next);
                current.prev.next = newNode;
                current.next.prev = newNode;
            }
            current = current.next;
        }
        size++;
    }

    public void printAll() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        HandMadeLinkedList<Integer> integers = new HandMadeLinkedList<>();

        integers.addFirst(1);
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addLast(4);
        integers.addLast(5);
        integers.addFirst(1);

        integers.printAll();
        integers.add(3, 4);
        integers.printAll();
    }
}