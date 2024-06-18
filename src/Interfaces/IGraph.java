package Interfaces;
import Clases.Edge;
import java.util.List;

public interface IGraph {
    void addEdge(int origen, int destino, int peso);
    List<Edge> edges();
}