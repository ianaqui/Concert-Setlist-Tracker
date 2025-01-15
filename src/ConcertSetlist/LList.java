package ConcertSetlist;

// Linked implementation of list interface
public class LList<T> implements ListInterface<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node first;
    private int size;

    public LList() {
        first = null;
        size = 0;
    }

    public void add(T entry) {
        Node newNode = new Node(entry);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node last = getNodeAt(size);
            last.next = newNode;
        }
        size++;
    }

    public void add(int pos, T entry) {
        if (pos < 1 || pos > size + 1)
            throw new IndexOutOfBoundsException();

        Node newNode = new Node(entry);
        if (pos == 1) {
            newNode.next = first;
            first = newNode;
        } else {
            Node before = getNodeAt(pos - 1);
            newNode.next = before.next;
            before.next = newNode;
        }
        size++;
    }

    public T remove(int pos) {
        if (pos < 1 || pos > size)
            throw new IndexOutOfBoundsException();

        T result;
        if (pos == 1) {
            result = first.data;
            first = first.next;
        } else {
            Node before = getNodeAt(pos - 1);
            result = before.next.data;
            before.next = before.next.next;
        }
        size--;
        return result;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public T replace(int pos, T entry) {
        if (pos < 1 || pos > size)
            throw new IndexOutOfBoundsException();
        Node curr = getNodeAt(pos);
        T old = curr.data;
        curr.data = entry;
        return old;
    }

    public T getEntry(int pos) {
        if (pos < 1 || pos > size)
            throw new IndexOutOfBoundsException();
        return getNodeAt(pos).data;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[])new Object[size];
        Node curr = first;
        for (int i = 0; i < size; i++) {
            result[i] = curr.data;
            curr = curr.next;
        }
        return result;
    }

    public boolean contains(T entry) {
        Node curr = first;
        while (curr != null) {
            if (entry.equals(curr.data)) return true;
            curr = curr.next;
        }
        return false;
    }

    public int getLength() { return size; }
    public boolean isEmpty() { return size == 0; }

    private Node getNodeAt(int pos) {
        Node curr = first;
        for (int i = 1; i < pos; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void display() {
        int i = 1;
        for (Node curr = first; curr != null; curr = curr.next) {
            System.out.println(i++ + " " + curr.data);
        }
    }
}