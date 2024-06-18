package Clases;

import Interfaces.IDisjointSet;

public class DisjointSet implements IDisjointSet {

    private int[] parent;
    private int[] size;
    private int count;

    public DisjointSet(int n) {
        parent = new int[n + 1]; // Ajuste para manejar índices de 1 a n
        size = new int[n + 1]; // Ajuste para manejar índices de 1 a n
        count = n;

        // Inicialización: Cada elemento es su propio padre al principio, y su tamaño es 1
        for (int i = 1; i <= n; i++) { // Cambio en el rango del bucle
            parent[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public int find(int x) {
        // Aplicación de path compression: Hacemos que los nodos en el camino apunten directamente a la raíz
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Recursivamente encontrar la raíz y hacer path compression
        }
        return parent[x];
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Aplicación de union by size: Unir el árbol más pequeño debajo del más grande
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            count--; // Reducir el número de conjuntos disjuntos
        }
    }

    @Override
    public int count() {
        return count;
    }
}
