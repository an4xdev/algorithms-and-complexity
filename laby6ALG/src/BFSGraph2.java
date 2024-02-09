import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph2 extends BFSGraph {

    private int[] distance;
    private int[] parent;

    /**
     * Konstruktor
     *
     * @param k ilość wierzchołków
     */
    public BFSGraph2(int k) {
        super(k);
        distance = new int[k];
        parent = new int[k];
    }

    /**
     * Wypisuje wierzchołki w kolejności odwiedzania algorytmu BFS
     *
     * @param sourceVertex wierzchołek startowy
     */
    @Override
    public void bfs(int sourceVertex) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> vertexVisited = new ArrayList<>();
        queue.offer(sourceVertex);
        super.setVisited(sourceVertex);
        distance[sourceVertex] = 0;

        vertexVisited.add(sourceVertex);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int i = 0; i < super.getVertexCount(); i++) {
                if (isEdge(currentNode, i) && !super.isVisited(i)) {
                    vertexVisited.add(i);
                    queue.add(i);
                    super.setVisited(i);
                    distance[i] = distance[currentNode] + 1;
                }
            }
        }
        System.out.println("\nBFS from : " + sourceVertex);
        for (Integer v : vertexVisited) {
            System.out.print(v + " -> distance: " + distance[v] + ", ");
        }
    }

    /**
     * Metoda wyszukująca najkrótszą drogę w grafie
     *
     * @param source      wierzchołek początkowy
     * @param destination wierzchołek końcowy
     * @return ArrayList<Integer> - droga jako lista wierzchołków/null
     */
    public ArrayList<Integer> findShortestPath(int source, int destination) {
        Arrays.fill(distance, 0);
        Arrays.fill(parent, 0);
        Queue<Integer> queue = new LinkedList<>();
        super.setVisited(source);
        distance[source] = 0;
        queue.add(source);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int i = 0; i < super.getVertexCount(); i++) {
                if (isEdge(currentNode, i)) {
                    super.setVisited(i);
                    distance[i] = distance[currentNode] + 1;
                    parent[i] = currentNode;
                    queue.add(i);
                    if (i == destination) {
                        ArrayList<Integer> path = new ArrayList<>();
                        int current = destination;
                        while (current != source) {
                            path.add(current);
                            current = parent[current];
                        }
                        path.add(source);
                        Collections.reverse(path);
                        return path;
                    }
                }
            }
        }
        return null;
    }
}
