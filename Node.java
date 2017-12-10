/*
        Used to represent edge in adjacency list
     */
public class Node {
    public int vertex;
    public double weight;
    Node next;

    public Node(int vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
        this.next = null;
    }

    @Override
    public String toString(){
        return "" + vertex + " - " + weight;
    }
}