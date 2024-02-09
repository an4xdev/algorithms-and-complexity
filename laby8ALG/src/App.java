public class App {

    public static Graph graph;

    public static void main(String[] args) {
        graph = new Graph();
        try {
            graph.addVertices(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(0, 1, 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(0, 3, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(0, 4, 7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(1, 2, 7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(1, 4, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(3, 4, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        // graph.writeGraph();
        try {
            graph.addVertices(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        // System.out.println("//////////////////////////////////////////////////////////////");
        // graph.writeGraph();
        try {
            graph.addEdge(1, 5, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(2, 6, 8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(4, 6, 8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(5, 2, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            graph.addEdge(5, 6, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        // System.out.println("//////////////////////////////////////////////////////////////");
        // graph.writeGraph();

        // dijkstra();
        // BF();
        SSS();
    }

    public static void dijkstra() {
        try {
            graph.dijkstra(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void BF() {
        try {
            graph.ford(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void SSS() {

        Graph sss = new Graph();
        try {
            sss.addVertices(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            sss.addEdge(0, 1, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            sss.addEdge(1, 0, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            sss.addEdge(1, 2, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            sss.addEdge(2, 1, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            sss.addEdge(2, 3, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            sss.addEdge(3, 4, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            sss.SSS();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
