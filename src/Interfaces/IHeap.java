package Interfaces;
import Clases.Edge;

public interface IHeap {
    void push(Edge a);
    void pop();
    Edge first();
    boolean isEmpty();
}