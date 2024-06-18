package Interfaces;

public interface IDisjointSet {
    int find(int x);
    void union(int x, int y);
    int count();
}
