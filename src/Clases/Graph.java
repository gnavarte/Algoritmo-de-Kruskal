package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import Interfaces.IGraph;

public class Graph implements IGraph {
    private List<Edge> edges;
    private Set<Integer> vertexes;

    public Graph() {
        edges = new ArrayList<>();
        vertexes = new HashSet<>();
    }

    @Override
    public void addEdge(int origen, int destino, int peso) {
        edges.add(new Edge(origen, destino, peso));
        vertexes.add(origen);
        vertexes.add(destino);
    }

    @Override
    public List<Edge> edges() {
        return edges;
    }

    // Método que devuelve la cantidad de vértices en el grafo
    public int getVertexCount() {
        return vertexes.size();
    }
}