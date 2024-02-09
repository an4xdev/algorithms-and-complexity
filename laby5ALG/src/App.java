
public class App {
    public static void main(String[] args) {
        // matrix();
        // list();
        // checkClique();
        // checkDirectedGraph();
        // printIncidenceMatrix();
        checkEquals();
    }

    public static void matrix() {
        TGraph matrixGraph = new TGraph(5);
        try {
            matrixGraph.connect(0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            matrixGraph.connect(2, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            matrixGraph.connect(3, 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            matrixGraph.connect(5, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            matrixGraph.connect(7, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        matrixGraph.writeMatrix();
        // try {
        // System.out.println(matrixGraph.check(1, 4));
        // } catch (IllegalArgumentException e) {
        // System.out.println(e.getMessage());
        // }
        matrixGraph.writeEdgesWithoutNeighbors();
        // matrixGraph.transpositionGraph();
        // matrixGraph.writeMatrix();
    }

    public static void list() {
        LGraph listGraph = new LGraph(5);
        try {
            listGraph.connect(0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            listGraph.connect(1, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            listGraph.connect(3, 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            listGraph.connect(5, 6);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        listGraph.writeList();
        try {
            System.out.println(listGraph.check(0, 3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        listGraph.writeEdgesWithoutNeighbors();
        // listGraph.transpositionGraph();
        // listGraph.writeList();
    }

    public static void checkClique() {
        TGraph graph = new TGraph(4);
        graph.connect(0, 1);
        graph.connect(0, 2);
        graph.connect(0, 3);
        graph.connect(1, 3);
        graph.connect(2, 1);
        graph.connect(2, 3);
        graph.writeMatrix();
        System.out.println(graph.isClique());
        graph = new TGraph(4);
        graph.connect(0, 1);
        graph.connect(0, 2);
        graph.connect(0, 3);
        graph.connect(1, 3);
        graph.connect(2, 1);
        graph.connect(2, 3);
        graph.connect(3, 0);
        graph.writeMatrix();
        System.out.println(graph.isClique());
    }

    public static void checkDirectedGraph() {
        LGraph graph = new LGraph(4);
        graph.connect(0, 1);
        graph.connect(1, 0);
        //
        graph.connect(0, 2);
        graph.connect(2, 0);
        //
        graph.connect(0, 3);
        graph.connect(3, 0);
        //
        graph.connect(1, 2);
        graph.connect(2, 1);
        //
        graph.connect(1, 3);
        graph.connect(3, 1);
        //
        graph.connect(2, 3);
        graph.connect(3, 2);
        graph.writeList();

        System.out.println(graph.isDirectedGraph());

        graph = new LGraph(4);
        graph.connect(0, 1);
        graph.connect(1, 0);
        //
        graph.connect(0, 2);
        graph.connect(2, 0);
        //
        graph.connect(0, 3);
        graph.connect(3, 0);
        //
        graph.connect(1, 2);
        graph.connect(2, 1);
        //
        graph.connect(1, 3);
        graph.connect(3, 1);
        //
        graph.connect(2, 3);
        graph.writeList();

        System.out.println(graph.isDirectedGraph());
    }

    public static void printIncidenceMatrix() {
        TGraph graph = new TGraph(4);
        graph.connect(0, 1);
        graph.connect(0, 3);
        graph.connect(2, 1);
        graph.connect(3, 2);
        graph.writeMatrix();
        graph.printIncidenceMatrix();
    }

    public static void checkEquals() {
        TGraph graph = new TGraph(4);
        graph.connect(0, 1);
        graph.connect(0, 3);
        graph.connect(2, 1);
        graph.connect(3, 2);
        graph.writeMatrix();

        TGraph graph2 = new TGraph(4);
        graph2.connect(0, 1);
        graph2.connect(0, 3);
        graph2.connect(2, 1);
        graph2.connect(3, 2);
        graph2.writeMatrix();

        System.out.println("Graf 1 i 2: " + (graph.equals(graph2) ? "są takie same" : "nie są takie same") + "\n\n");

        graph = new TGraph(4);
        graph.connect(0, 1);
        graph.connect(0, 3);
        graph.connect(2, 1);
        graph.connect(3, 2);
        graph.writeMatrix();

        graph2 = new TGraph(10);
        graph2.connect(0, 1);
        graph2.connect(0, 3);
        graph2.connect(2, 1);
        graph2.connect(3, 2);
        graph2.writeMatrix();

        System.out.println("Graf 1 i 2: " + (graph.equals(graph2) ? "są takie same" : "nie są takie same") + "\n\n");

        graph = new TGraph(4);
        graph.connect(0, 1);
        graph.connect(0, 3);
        graph.connect(2, 1);
        graph.connect(3, 2);
        graph.writeMatrix();

        graph2 = new TGraph(4);
        graph2.connect(0, 1);
        graph2.connect(0, 3);
        graph2.connect(2, 1);
        graph2.writeMatrix();

        System.out.println("Graf 1 i 2: " + (graph.equals(graph2) ? "są takie same" : "nie są takie same") + "\n\n");

        System.out.println("Graf 1 i String: 'ala ma kota': "
                + (graph.equals("ala ma kota") ? "są takie same" : "nie są takie same") + "\n\n");
    }
}
