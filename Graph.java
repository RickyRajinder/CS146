import java.util.*;

/*
    Program to create an adjacency list
    undirected weighted graph representation
 */
public class Graph {

    int numberOfVertices;
    public static final double MAX_WEIGHT = Double.MAX_VALUE;

    //Used to represent the adjacency list
    Map<Double, LinkedList<Node>> adjacencyList;

    //Tree map will contain nodes that have not yet been included
    TreeMap<Double, Double> heap = new TreeMap<>();


    /*
        Create a new graph with the specified number of vertices
     */
    public Graph(int numberOfVertices){
        this.numberOfVertices = numberOfVertices;
        this.adjacencyList = new TreeMap<>();
    }

    /*
        Add an edge to the graph
        @param graph: the specified graph to which to add an edge to
        @param source: the source Node from which the edge will be added
        @param destination: the Node that will be connected to source by this edge
        @param weight: the weight of the edge
     */
    public void addEdge(Graph graph, int source, int destination, double weight){

        Node node = new Node(destination, weight);
        LinkedList<Node> list = null;

        //Add an adjacent Node for source
        list = adjacencyList.get((double)source);
        if (list == null){
            list = new LinkedList<Node>();
        }

        list.addFirst(node);
        adjacencyList.put((double)source, list);

        //Add adjacent node again since graph is undirected
        node = new Node(source, weight);

        list = null;

        list = adjacencyList.get((double)destination);

        if (list == null){
            list = new LinkedList<Node>();
        }

        list.addFirst(node);
        adjacencyList.put((double)destination, list);
    }

    /*
        Find the minimum spanning tree of this graph using Prim's algorithm
        Uses a heap
     */
    public void PrimMST(Graph graph){
        //Create a list to store the MST
        Map<Double, Double> MST = new TreeMap<>();

        //Initialize a heap except for the root
        Set<Double> set = adjacencyList.keySet();

        //Create a heap for all the keys in the adjacency list
        for (Double i: set){
            createHeap(i, MAX_WEIGHT);
        }

        while (heap.size()!=0){

            //Find the vertex with the smallest edge
            //Remove it, and create a list from it
            double minEdgeVertex = findMin();
            System.out.println(minEdgeVertex);
            heap.remove(minEdgeVertex);
            LinkedList<Node> list = adjacencyList.get(minEdgeVertex);

            Iterator<Node> iterator = list.iterator();
            while(iterator.hasNext()){
                Node node = iterator.next();
                int vertex = node.vertex;

                //if the heap contains the vertex, put the vertex in the heap with the new weight
                //and put it in the MST
                if (heap.containsKey((double)vertex)){
                    heap.put((double)vertex, node.weight);
                    MST.put((double)vertex, minEdgeVertex);
                }
            }
        }
        print(MST);
        System.out.println("Cost: " + getCost(MST));
    }

    /*
        Used in PrimMST
     */
    private void createHeap(double vertex, double weight){
        if (heap == null){
            heap = new TreeMap<>();
        }
        heap.put((double)vertex, weight);
    }

    /*
       Find the minimum edge of a vertex
        Used in PrimMST
     */
    private double findMin(){
        Set<Map.Entry<Double, Double>> list = heap.entrySet();
        double minKey = heap.firstKey();
        double minVal = MAX_WEIGHT;
        if (list != null){
            for (Map.Entry<Double, Double> entry: list){
                if (minVal > entry.getValue()){
                    minVal = entry.getValue();
                    minKey = entry.getKey();
                }
            }
        }
        return minKey;
    }

    /*
        Get the total cost of all the edges in the MST
        Used by PrimMST
     */
    public double getCost(Map<Double,Double> MST){
        Set<Map.Entry<Double,Double>> set = MST.entrySet();
        double cost = 0;

        for (Map.Entry<Double, Double> entry: set){
            double key = entry.getKey();
            double value = entry.getValue();
            List<Node> list = adjacencyList.get(value);
            if (list!=null){
                for (int i = 0; i <list.size(); i++){
                    Node node = list.get(i);
                    if (node.vertex == key){
                        cost += node.weight;
                    }
                }
            }
        }
        return cost;
    }


    public void print(Map<Double, Double> MST){
        System.out.println("MST: ");
        Set<Map.Entry<Double, Double>> set = MST.entrySet();

        for (Map.Entry<Double, Double> entry: set){
            System.out.println(entry.getKey().intValue() + " -- " + entry.getValue().intValue());
        }
    }


}

