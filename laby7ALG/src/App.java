public class App {
    public static void main(String[] args) throws Exception {
        // zad1();
        // zad2();
        zad3();
    }

    public static void zad1() {
        DFSGraph graph = new DFSGraph();
        System.out.println("Dodałem: " + graph.addVertex() + ", wierzchołek.");
        System.out.println("Dodałem: " + graph.addVertex() + ", wierzchołek.");
        System.out.println("Dodałem: " + graph.addVertex() + ", wierzchołek.");
        System.out.println("Dodałem: " + graph.addVertex() + ", wierzchołek.");
        System.out.println("Dodałem: " + graph.addVertex() + ", wierzchołek.");
        System.out.println("Dodałem: " + graph.addVertex() + ", wierzchołek.");
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.writeList();
        graph.writeMatrix();
        System.out.print("Sąsiedzi wierzchołka 1: ");
        for (int n : graph.sasiedzi(1)) {
            System.out.print(n + ", ");
        }
        System.out.println();
        System.out.println("Transpozycja grafu:");
        graph.transpose().writeList();
    }

    public static void zad2() {
        DFSGraph graph = new DFSGraph();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.dfs();
    }

    public static void zad3() {
        DFSGraph graph = new DFSGraph();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.dfsWithStack();
    }
}
