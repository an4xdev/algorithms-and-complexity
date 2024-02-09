import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        BFSGraph2 graph = new BFSGraph2(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 9);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 4);
        graph.addEdge(6, 8);
        // graph.bfs(0);
        ArrayList<Integer> path = graph.findShortestPath(0, 6);
        if (path != null) {
            for (int v : path) {
                System.out.print(v + " ");
            }
        }
    }
}
