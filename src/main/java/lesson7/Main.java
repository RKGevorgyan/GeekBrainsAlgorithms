package lesson7;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(7,8);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);

        BreadthFirstPath bfp  = new BreadthFirstPath(graph, 0);
        int path = 8;
        List<Integer> list = bfp.pathTo(path);
        System.out.printf("Shortest way: %s\n",list);
        int distance = list.stream().mapToInt(n -> n).sum();
        System.out.printf("Distance: %d",distance);

    }
}
