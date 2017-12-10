import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {

    @Test
    public void testPrim5(){
        Graph graph = new Graph(5);
        graph.addEdge(graph,0,1,2);
        graph.addEdge(graph,0,2,5);
        graph.addEdge(graph,1,2,7);
        graph.addEdge(graph,1,3,1);
        graph.addEdge(graph,2,3,6);
        graph.addEdge(graph,2,4,3);
        graph.addEdge(graph,3,4,8);

       graph.PrimMST(graph);
       System.out.println("Expected cost: 12");
    }

    @Test
    public void testPrimtiny() throws FileNotFoundException {
        File testGraph = new File("tinyEWG.txt");
        Scanner scan = new Scanner(testGraph);
        int numberOfVertices = Integer.parseInt(scan.nextLine());
        System.out.println("Number of vertices: " + numberOfVertices);
        Graph graph = new Graph(numberOfVertices);
        scan.nextLine();
        while (scan.hasNext()){
            int endpoint1 = Integer.parseInt(scan.next());
            int endpoint2 = Integer.parseInt(scan.next());
            double weight = Double.parseDouble(scan.nextLine());
            graph.addEdge(graph, endpoint1, endpoint2, weight);
        }
        long before = System.currentTimeMillis();
        graph.PrimMST(graph);
        long after = System.currentTimeMillis();
        System.out.println("Time: "+ (after-before) + " ms");
    }

    @Test
    public void testPrim1000() throws FileNotFoundException {
        File testGraph = new File("1000EWG.txt");
        Scanner scan = new Scanner(testGraph);
        int numberOfVertices = Integer.parseInt(scan.nextLine());
        System.out.println("Number of vertices: " + numberOfVertices);
        Graph graph = new Graph(numberOfVertices);
        scan.nextLine();
        while (scan.hasNext()){
            int endpoint1 = Integer.parseInt(scan.next());
            int endpoint2 = Integer.parseInt(scan.next());
            double weight = Double.parseDouble(scan.nextLine());
            graph.addEdge(graph, endpoint1, endpoint2, weight);
        }
        long before = System.currentTimeMillis();
        graph.PrimMST(graph);
        long after = System.currentTimeMillis();
        System.out.println("Time: "+ (after-before) + " ms");
    }

    @Test
    public void testPrim10000() throws FileNotFoundException {
        File testGraph = new File("10000EWG.txt");
        Scanner scan = new Scanner(testGraph);
        int numberOfVertices = Integer.parseInt(scan.nextLine());
        System.out.println("Number of vertices: " + numberOfVertices);
        Graph graph = new Graph(numberOfVertices);
        scan.nextLine();
        while (scan.hasNext()){
            int endpoint1 = Integer.parseInt(scan.next());
            int endpoint2 = Integer.parseInt(scan.next());
            double weight = Double.parseDouble(scan.nextLine());
            graph.addEdge(graph, endpoint1, endpoint2, weight);
        }
        double before = System.currentTimeMillis();
        graph.PrimMST(graph);
        double after = System.currentTimeMillis();
        System.out.println("Time: "+ (after-before)/1000 + " s");
    }

    @Test
    public void testPrimmedium() throws FileNotFoundException {
        File testGraph = new File("mediumEWG.txt");
        Scanner scan = new Scanner(testGraph);
        int numberOfVertices = Integer.parseInt(scan.nextLine());
        System.out.println("Number of vertices: " + numberOfVertices);
        Graph graph = new Graph(numberOfVertices);
        scan.nextLine();
        while (scan.hasNext()){
            int endpoint1 = Integer.parseInt(scan.next());
            int endpoint2 = Integer.parseInt(scan.next());
            double weight = Double.parseDouble(scan.nextLine());
            graph.addEdge(graph, endpoint1, endpoint2, weight);
        }
        long before = System.currentTimeMillis();
        graph.PrimMST(graph);
        long after = System.currentTimeMillis();
        System.out.println("Time: "+ (after-before) + " ms");
    }

    @Test
    public void testPrimlarge() throws FileNotFoundException {
        File testGraph = new File("largeEWG.txt");
        Scanner scan = new Scanner(testGraph);
        int numberOfVertices = Integer.parseInt(scan.nextLine());
        System.out.println("Number of vertices: " + numberOfVertices);
        Graph graph = new Graph(numberOfVertices);
        scan.nextLine();
        while (scan.hasNext()){
            int endpoint1 = Integer.parseInt(scan.next());
            int endpoint2 = Integer.parseInt(scan.next());
            double weight = Double.parseDouble(scan.nextLine());
            graph.addEdge(graph, endpoint1, endpoint2, weight);
        }
        double before = System.currentTimeMillis();
        graph.PrimMST(graph);
        double after = System.currentTimeMillis();
        System.out.println("Time: "+ (after-before)/1000 + " s");
    }
}
