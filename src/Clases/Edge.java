package Clases;

// Clase Edge para representar una arista con un peso
public class Edge {
    private int origin;
    private int destination;
    private int weight;
    
    public Edge(int origin, int destination, int weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public int getOrigin() {
        return origin;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}


