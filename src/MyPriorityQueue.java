import java.util.Comparator;

import java.util.ArrayList;

public class MyPriorityQueue {

    //Variables
    ArrayList<Patient> heap;
    private Comparator<Patient> comparator;

    //Constructor
    public MyPriorityQueue() {
        this.heap = new ArrayList<>();
        this.comparator = new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.getPriority().compareTo(p2.getPriority());
            }
        };
    }

    /**
     * Devuelve true si el heap está vacío
     * @return
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Devuelve el numero de elementos en el heap
     * @return
     */
    public int size() {
        return heap.size();
    }

    /**
     * Agrega elemento
     * @param patient
     */
    public void offer(Patient patient) {
        heap.add(patient);
        bubbleUp(heap.size() - 1);
    }

    /**
     *Retorna y elimina el elemento raíz (mínimo) del heap
     * @return
     */
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

    /**
     * Devuelve el elemento en la cima
     * @return
     */
    public Patient peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /**
     * Desplaza hacia arriba el elemento en el índice especificado en el montón hasta que esté en su posición correcta
     * @param index
     */
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

    /**
     *Desplaza hacia abajo el elemento en el índice especificado en el montón hasta que esté en su posición correcta
     * @param index
     */
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

    /**
     ** Devuelve el índice del nodo hijo mínimo del índice dado en un árbol binario
     *  Si el nodo no tiene hijos, devuelve -1
     * @param index
     * @return
     */
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

    /**
     * Intercambia los elementos en las posiciones especificadas en el heap
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Patient temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Devuelve el índice del nodo padre del índice dado en un árbol binario.
     * @param index
     * @return
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Devuelve el índice del nodo hijo izquierdo del índice dado en el árbol binario
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * Devuelve el índice del nodo hijo derecho del índice dado en el árbol binario
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * Compara dos objetos Patient utilizando un comparador
     * @param p1
     * @param p2
     * @return
     */
    private int compare(Patient p1, Patient p2) {
        return comparator.compare(p1, p2);
    }

    /**
     * Metodo implementado para obtener el elemento en cirto index
     * @param index
     * @return
     */
    public Patient getPatient(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites del heap");
        }
        return heap.get(index);
    }


}
