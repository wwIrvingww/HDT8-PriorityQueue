import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] elements;
    private int size;
    private Comparator<T> comparator;

    public PriorityQueue() {
        this(DEFAULT_CAPACITY, null);
    }

    public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    public PriorityQueue(Comparator<T> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    public PriorityQueue(int initialCapacity, Comparator<T> comparator) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Invalid initial capacity: " + initialCapacity);
        }
        this.elements = (T[]) new Object[initialCapacity];
        this.size = 0;
        this.comparator = comparator;
    }

    public boolean offer(T element) {
        if (element == null) {
            throw new NullPointerException("Cannot add null element");
        }
        if (size == elements.length) {
            resize(elements.length * 2);
        }
        elements[size++] = element;
        bubbleUp(size - 1);
        return true;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T root = elements[0];
        elements[0] = elements[--size];
        elements[size] = null;
        bubbleDown(0);
        return root;
    }

    public T peek() {
        return isEmpty() ? null : elements[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp(int index) {
        while (index > 0 && compare(index, parent(index)) < 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown(int index) {
        while (leftChild(index) < size) {
            int minChildIndex = minChildIndex(index);
            if (compare(index, minChildIndex) <= 0) {
                break;
            }
            swap(index, minChildIndex);
            index = minChildIndex;
        }
    }

    private int minChildIndex(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        if (right >= size || compare(left, right) <= 0) {
            return left;
        }
        return right;
    }

    private void swap(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private int compare(int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) elements[i]).compareTo(elements[j]);
        } else {
            return comparator.compare(elements[i], elements[j]);
        }
    }

    private void resize(int newCapacity) {
        elements = Arrays.copyOf(elements, newCapacity);
    }
}
