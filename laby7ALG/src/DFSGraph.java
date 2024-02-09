import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFSGraph extends LGraph {

    private boolean[] visited;

    @Override
    public void writeList() {
        int i = 0;
        System.out.println("List representation: ");
        for (List<Integer> list : listaSasiedztwa) {
            System.out.print(i + ": ");
            for (int s : list) {
                System.out.print(s + ", ");
            }
            i++;
            System.out.println();
        }
    }

    @Override
    public void writeMatrix() {
        System.out.println("Matrix representation: ");
        for (int index = 0; index < 3; index++) {
            System.out.print(" ");
        }
        System.out.print("| ");
        for (int index = 0; index < iloscWierzcholkow; index++) {
            System.out.print(index + " | ");
        }
        System.out.println();
        for (int index = 0; index < iloscWierzcholkow * 5 + 1; index++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < iloscWierzcholkow; i++) {
            System.out.print(i + ": | ");
            for (int j = 0; j < iloscWierzcholkow; j++) {
                if (check(i, j)) {
                    System.out.print("1 | ");
                } else {
                    System.out.print("0 | ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public int addVertex() {
        listaSasiedztwa.add(new ArrayList<Integer>());
        iloscWierzcholkow++;
        return listaSasiedztwa.size() - 1;
    }

    @Override
    public void addEdge(int source, int target) throws IllegalArgumentException {
        if (source < 0 || target < 0)
            throw new IllegalArgumentException("Nie można dodać krawędzi do ujemnych wierzchołków.");
        if (source > listaSasiedztwa.size() || target > listaSasiedztwa.size())
            throw new IllegalArgumentException("Nie można dodać krawędzi do wierzchołka, który nie istnieje.");
        listaSasiedztwa.get(source).add(target);
    }

    @Override
    public List<Integer> sasiedzi(int v) throws IllegalArgumentException {
        if (v < 0)
            throw new IllegalArgumentException("Nie można pobrać listy sąsiedzctwa dla ujemnego wierzchołka.");
        if (v > listaSasiedztwa.size())
            throw new IllegalArgumentException(
                    "Nie można pobrać listy sąsiedzctwa dla wierzchołka, który nie istnieje.");
        return listaSasiedztwa.get(v);
    }

    @Override
    public boolean check(int i, int j) throws IllegalArgumentException {
        if (i < 0 || j < 0)
            throw new IllegalArgumentException("Nie można sprawdzić krawędzi do ujemnych wierzchołków.");
        if (i > listaSasiedztwa.size() || j > listaSasiedztwa.size())
            throw new IllegalArgumentException("Nie można sprawdzić krawędzi do wierzchołka, który nie istnieje");

        return listaSasiedztwa.get(i).contains(j);
    }

    @Override
    public void dfs() {
        visited = new boolean[iloscWierzcholkow];
        Arrays.fill(visited, false);
        for (int i = 0; i < iloscWierzcholkow; i++) {
            if (!visited[i])
                odwiedzaj(i);
        }
    }

    @Override
    protected void odwiedzaj(int wierzcholek) {
        visited[wierzcholek] = true;
        System.out.println("Odwiedzam: " + wierzcholek);
        for (Integer n : sasiedzi(wierzcholek)) {
            if (!visited[n])
                odwiedzaj(n);
        }
    }

    public void dfsWithStack() {
        visited = new boolean[iloscWierzcholkow];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<Integer>();
        int current = 0;
        stack.push(current);
        while (!stack.empty()) {
            System.out.println("Odwiedzam: " + current);
            visited[current] = true;
            for (Integer n : sasiedzi(current)) {
                if (!visited[n])
                    stack.push(n);
            }
            current = stack.pop();
        }
    }

    @Override
    public LGraph transpose() {
        DFSGraph temp = new DFSGraph();
        for (int i = 0; i < iloscWierzcholkow; i++) {
            temp.addVertex();
        }
        for (int i = 0; i < iloscWierzcholkow; i++) {
            for (int j = 0; j < iloscWierzcholkow; j++) {
                if (check(i, j))
                    temp.addEdge(j, i);
            }
        }
        return temp;
    }

}
