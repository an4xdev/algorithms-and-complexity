import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph extends TGraph implements IBfsSearchable {

    private boolean[] visited;

    /**
     * Konstruktor
     *
     * @param k ilość wierzchołków
     */
    public BFSGraph(int k) {
        super(k);
        visited = new boolean[k];
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
        visited[sourceVertex] = true;

        vertexVisited.add(sourceVertex);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int i = 0; i < super.getVertexCount(); i++) {
                if (isEdge(currentNode, i) && !visited[i]) {
                    vertexVisited.add(i);
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println("\nBFS from : " + sourceVertex);
        for (Integer v : vertexVisited) {
            System.out.print(v + " ");
        }
    }

    /**
     * Metoda sprawdzająca czy wierzchołek został odwiedzony
     *
     * @param index wierzchołek
     * @return true - odwiedzony/false - niedowiedzony
     */
    public boolean isVisited(int index) {
        return visited[index];
    }

    /**
     * Metoda ustawiająca wierzchołek na odwiedzony
     *
     * @param index wierzchołek
     */
    public void setVisited(int index) {
        visited[index] = true;
    }

}
