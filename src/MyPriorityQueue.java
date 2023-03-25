import java.util.Comparator;

import java.util.ArrayList;

public class MyPriorityQueue {


    ArrayList<Patient> heap;
    private Comparator<Patient> comparator;

    public MyPriorityQueue() {
        this.heap = new ArrayList<>();
        this.comparator = new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.getPriority().compareTo(p2.getPriority());
            }
        };
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public void offer(Patient patient) {
        heap.add(patient);
        bubbleUp(heap.size() - 1);
    }

    public Patient poll() {
        if (isEmpty()) {
            return null;
        }
        Patient root = heap.get(0);
        Patient last = heap.remove(size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            bubbleDown(0);
        }
        return root;
    }

    public Patient peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = parent(index);
            if (compare(heap.get(index), heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int index) {
        while (true) {
            int minChildIndex = minChildIndex(index);
            if (minChildIndex == -1) {
                break;
            }
            if (compare(heap.get(minChildIndex), heap.get(index)) < 0) {
                swap(index, minChildIndex);
                index = minChildIndex;
            } else {
                break;
            }
        }
    }

    private int minChildIndex(int index) {
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);
        if (leftChildIndex >= size() && rightChildIndex >= size()) {
            return -1;
        }
        if (leftChildIndex >= size()) {
            return rightChildIndex;
        }
        if (rightChildIndex >= size()) {
            return leftChildIndex;
        }
        return compare(heap.get(leftChildIndex), heap.get(rightChildIndex)) < 0 ?
                leftChildIndex : rightChildIndex;
    }

    private void swap(int i, int j) {
        Patient temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
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

    private int compare(Patient p1, Patient p2) {
        return comparator.compare(p1, p2);
    }

    public Patient getPatient(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites del heap");
        }
        return heap.get(index);
    }




}
