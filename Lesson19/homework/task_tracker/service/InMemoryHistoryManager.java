package Lesson19.homework.task_tracker.service;

import Lesson19.homework.task_tracker.model.Task;
import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private final Map<Integer, Node> nodeMap = new HashMap<>();
    private Node head;
    private Node tail;
    private int currentHistorySize = 0;
    private static final int MAX_HISTORY_SIZE = 10;

    class Node {
        public Task data;
        public Node next;
        public Node prev;

        public Node(Node prev, Task data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(Task task) {
        if (nodeMap.containsValue(task.getId())) {
            remove(task.getId());
        }

        if (currentHistorySize == MAX_HISTORY_SIZE) {
            removeNode(head);
        }
        linkLast(task);
    }

    @Override
    public void remove(int id) {
        removeNode(nodeMap.get(id));
        nodeMap.remove(id);
    }

    @Override
    public List<Task> getHistory() {
        return getTasks();
    }

    private void linkLast(Task task) {
        Node oldTail = tail;
        tail = new Node(oldTail, task, null);

        if (oldTail == null) {
            head = tail;
        } else {
            oldTail.next = tail;
        }

        nodeMap.put(task.getId(), tail);
        currentHistorySize++;
    }

    public List<Task> getTasks() {
        List<Task> taskList = new ArrayList<>();
        Node current = head;
        while (current != null) {
            taskList.add(current.data);
            current = current.next;
        }

        return taskList;
    }

    private void removeNode(Node node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.next;
            head.prev = null;
        } else if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        currentHistorySize--;
    }
}
