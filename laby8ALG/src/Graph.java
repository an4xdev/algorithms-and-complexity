import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Graph implements IWGraph {

    private int size;
    private int[][] edges;

    public Graph() {
        this.size = 0;
    }

    private void changeSizeOfMatrix(int prevSize) {
        int[][] temp = edges;
        edges = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j)
                    edges[i][j] = INFTY;
                else
                    edges[i][j] = 0;
            }
        }

        for (int i = 0; i < prevSize; i++) {
            for (int j = 0; j < prevSize; j++) {
                edges[i][j] = temp[i][j];
            }
        }
    }

    @Override
    public void addVertices(int i) throws Exception {
        if (i <= 0)
            throw new Exception("Nie można dodać ujemnej lub zerowej liczby wierzchołków");
        size += i;
        changeSizeOfMatrix(size - i);
    }

    @Override
    public void addEdge(int start, int stop, int weight) throws Exception {
        if (start < 0 || stop < 0)
            throw new Exception("Nie można połączyć wierzchołków gdy jeden z nich jest ujmeny");
        if (start >= size || stop >= size)
            throw new Exception("Nie można połączyć wierzchołków kiedy jeden z nich nie istnieje");
        if (weight < 0)
            throw new Exception("Waga musi być nieujemna");
        edges[start][stop] = weight;
    }

    @Override
    public int wCheck(int start, int stop) throws Exception {
        if (start < 0 || stop < 0)
            throw new Exception("Nie ma połączenia gdy jeden z wierchołków jest ujemny");
        if (start >= size || stop >= size)
            throw new Exception("Nie ma połączenia gdy jeden z wierchołków nie istnieje");
        return edges[start][stop];
    }

    @Override
    public void writeGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < size; j++) {
                if (edges[i][j] == INFTY)
                    System.out.print("(" + j + ",-) ");
                else
                    System.out.print("(" + j + "," + edges[i][j] + ") ");
            }
            System.out.println();
        }
    }

    @Override
    public void ford(int start) throws Exception {
        if (start < 0 || start > size)
            throw new Exception("Podano wierzchołek, który nie istnieje");
        int[] D = new int[size];
        for (int i = 0; i < size; i++) {
            D[i] = edges[start][i];
        }
        for (int step = 0; step < size; step++) {
            for (int i = 0; i < size; i++) {
                if (i != start) {
                    for (int j = 0; j < size; j++) {
                        if (j != start) {
                            D[i] = Math.min(D[i], D[j] + wCheck(j, i));
                        }
                    }
                }

            }
        }
        System.out.print("Z wierzchołka " + start + " najkrótsze drogi: ");
        for (int i = 0; i < size; i++) {
            System.out.print("(" + i + "," + D[i] + "), ");
        }
        System.out.println();
    }

    @Override
    public void dijkstra(int start) throws Exception {
        if (start < 0 || start > size)
            throw new Exception("Podano wierzchołek, który nie istnieje");
        int[] D = new int[size];
        for (int i = 0; i < size; i++) {
            D[i] = edges[start][i];
        }

        System.out.print("Z wierzchołka " + start + " najkrótsze drogi: ");
        for (int i = 0; i < size; i++) {
            System.out.print("(" + i + "," + D[i] + "), ");
        }
        System.out.println();

        LinkedList<Integer> noCalculated = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (i != start)
                noCalculated.add(i);
        }
        while (!noCalculated.isEmpty()) {
            int current = -1;
            int minDistance = INFTY;
            for (int v : noCalculated) {
                if (D[v] < minDistance) {
                    minDistance = D[v];
                    current = v;
                }
            }
            noCalculated.remove((Object) current);
            for (int i = 0; i < size; i++) {
                if (wCheck(current, i) != INFTY && i != current && i != start) {
                    if (D[current] + wCheck(current, i) < D[i]) {
                        D[i] = D[current] + wCheck(current, i);
                    }
                }
            }
            System.out.print("Z wierzchołka " + start + " najkrótsze drogi: ");
            for (int i = 0; i < size; i++) {
                System.out.print("(" + i + "," + D[i] + "), ");
            }
            System.out.println();
        }
    }

    private int index;
    private Stack<Integer> stack;
    private ArrayList<ArrayList<Integer>> sssList;

    @Override
    public void SSS() throws Exception {
        index = 0;
        stack = new Stack<>();
        sssList = new ArrayList<>();
        int[] vertexIndexes = new int[size];
        int[] lowlinks = new int[size];
        Arrays.fill(vertexIndexes, -1);

        for (int v = 0; v < size; v++) {
            if (vertexIndexes[v] == -1) {
                strongConnect(v, vertexIndexes, lowlinks);
            }
        }

        for (ArrayList<Integer> list : sssList) {
            for (int element : list) {
                System.out.print(element + ", ");
            }
            System.out.println();
        }
    }

    private void strongConnect(int v, int[] vertexIndexes, int[] lowlinks) throws Exception {
        vertexIndexes[v] = index;
        lowlinks[v] = index;
        index++;
        stack.push(v);
        for (int w = 0; w < size; w++) {
            if (wCheck(v, w) != INFTY && vertexIndexes[w] == -1) {
                strongConnect(w, vertexIndexes, lowlinks);
                lowlinks[v] = Math.min(lowlinks[v], lowlinks[w]);
            } else if (wCheck(v, w) != INFTY && stack.contains(w)) {
                lowlinks[v] = Math.min(lowlinks[v], vertexIndexes[w]);
            }
        }
        if (lowlinks[v] == vertexIndexes[v]) {
            ArrayList<Integer> component = new ArrayList<>();
            int w;
            do {
                w = stack.pop();
                component.add(w);
            } while (w != v);
            sssList.add(component);
        }
    }

}
