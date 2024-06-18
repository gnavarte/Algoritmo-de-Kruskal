import Clases.*;
import Interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Algoritmo de Kruskal\n");
        
        Graph grafo = new Graph();
        grafo.addEdge(4, 7, 9); // Añadir arista (d, g) con peso 9
        grafo.addEdge(1, 7, 1); // Añadir arista (a, g) con peso 1
        grafo.addEdge(1, 6, 5); // Añadir arista (a, f) con peso 5
        grafo.addEdge(2, 3, 3); // Añadir arista (b, c) con peso 3
        grafo.addEdge(1, 6, 5); // Añadir arista (a, f) con peso 5
        grafo.addEdge(3, 7, 3); // Añadir arista (c, g) con peso 3
        grafo.addEdge(1, 2, 4); // Añadir arista (a, b) con peso 4
        grafo.addEdge(5, 7, 4); // Añadir arista (e, g) con peso 4
        grafo.addEdge(4, 5, 7); // Añadir arista (d, e) con peso 7
        grafo.addEdge(5, 6, 8); // Añadir arista (e, f) con peso 8
        grafo.addEdge(1, 6, 5); // Añadir arista (a, f) con peso 5
        grafo.addEdge(3, 4, 5); // Añadir arista (c, d) con peso 5
        grafo.addEdge(6, 7, 2); // Añadir arista (f, g) con peso 2
        grafo.addEdge(1, 3, 7); // Añadir arista (a, c) con peso 7
        grafo.addEdge(4, 7, 9); // Añadir arista (d, g) con peso 9
        
        List<Edge> result = Kruskal(grafo);
        
        for (Edge edge : result) {
            System.out.println("Origen: " + edge.getOrigin() + " - Destino: " + edge.getDestination() + " - Peso: " + edge.getWeight());
        }
    }
    
    public static List<Edge> Kruskal(Graph grafo) {
        IHeap heap = new MinHeap();

        // Agregar todas las aristas del grafo al heap
        for (Edge edge : grafo.edges()) {
            heap.push(edge);
        }
        
        final int cantidadVertices = grafo.getVertexCount();
        IDisjointSet disjointset = new DisjointSet(cantidadVertices);
        List<Edge> result = new ArrayList<>();
        
        // Aplicar el algoritmo de Kruskal
        while (disjointset.count() > 1) {
            Edge edge = heap.first();
            heap.pop();

            int root1 = disjointset.find(edge.getOrigin());
            int root2 = disjointset.find(edge.getDestination());

            // Si los nodos de origen y destino no pertenecen al mismo conjunto, añadir la arista al resultado
            if (root1 != root2) {
                result.add(edge);
                disjointset.union(root1, root2);
            }
        }

        return result;
    }
}
