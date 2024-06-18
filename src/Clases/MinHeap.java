package Clases;

import Interfaces.IHeap;
import java.util.ArrayList;
import java.util.List;

public class MinHeap implements IHeap {  

    // Lista que representa el heap
    private List<Edge> heap;  

    // Constructor que inicializa el MinHeap
    public MinHeap() {  
        heap = new ArrayList<>();  // Inicialización del heap como ArrayList
    }

    // Métodos privados para obtener índices de hijos e hijos
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    // Métodos privados para verificar la existencia de hijos y padre
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < heap.size();
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < heap.size();
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
    
    // Métodos privados para obtener los hijos y padre de un nodo
    private Edge leftChild(int index) {
        return heap.get(getLeftChildIndex(index));
    }

    private Edge rightChild(int index) {
        return heap.get(getRightChildIndex(index));
    }

    private Edge parent(int index) {
        return heap.get(getParentIndex(index));
    }

    // Método privado para intercambiar elementos en el heap
    private void swap(int indexOne, int indexTwo) {
        Edge temp = heap.get(indexOne);
        heap.set(indexOne, heap.get(indexTwo));
        heap.set(indexTwo, temp);
    }
    
    // Método para verificar si el heap está vacío
    @Override
    public boolean isEmpty() {  
        return heap.size() <= 0;
    }
    
    // Método para insertar un elemento en el heap
    @Override
    public void push(Edge edge) {  
        heap.add(edge);
        heapifyUp();
    }
    
    // Método para eliminar el elemento raíz (mínimo) del heap
    @Override
    public void pop() {  
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown();
    }
    
    // Método para obtener el primer elemento (mínimo) del heap
    @Override
    public Edge first() {  
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return heap.get(0);
    }

    // Método privado para mantener las propiedades del heap hacia arriba
    private void heapifyUp() {
        int index = heap.size() - 1;
        while (hasParent(index) && parent(index).getWeight() > heap.get(index).getWeight()) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    // Método privado para mantener las propiedades del heap hacia abajo
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).getWeight() < leftChild(index).getWeight()) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap.get(index).getWeight() < heap.get(smallerChildIndex).getWeight()) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
}
