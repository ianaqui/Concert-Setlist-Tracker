package ConcertSetlist;

// Interface for list ADT with position-based operations
public interface ListInterface<T> {
    void add(T newEntry);
    void add(int position, T newEntry);
    T remove(int position);
    void clear();
    T replace(int position, T newEntry);
    T getEntry(int position);
    T[] toArray();
    boolean contains(T anEntry);
    int getLength();
    boolean isEmpty();
}