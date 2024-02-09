/**
 * Klasa abstrakcyjna reprezentujaca graf.
 */
public abstract class AGraph {

    protected int size;

    public AGraph(int vertexCount) {
        size = vertexCount;
        if (size <= 0) {
            throw new IllegalArgumentException("Rozmiar grafu musi byc wiekszy od zera!");
        }
    }

    public int getSize() {
        return size;
    }

    /**
     * Wypisuje macierz sasiedztwa grafu.
     */
    public abstract void writeMatrix();

    /**
     * Sprawdza, czy istnieje krawedz pomiedzy wierzcholkiem i oraz j.
     * 
     * @param i - wierzchołek początkowy
     * @param j - wierzchołek końcowy
     */
    public abstract boolean check(int i, int j) throws IllegalArgumentException;

    /**
     * Tworzy krawedz pomiedzy wierzcholkiem i oraz j.
     * 
     * @param i - wierzchołek początkowy
     * @param j - wierzchołek końcowy
     */
    public abstract void connect(int i, int j) throws IllegalArgumentException;

    /**
     * Wypisuje graf jako listy sasiedztwa.
     */
    public abstract void writeList();

    /**
     * Wykonuje transpozycje grafu.
     */
    public abstract void transpositionGraph();

    /**
     * Wyświetla wierzchołki, które nie mają żadnych sąsiadów.
     */
    public abstract void writeEdgesWithoutNeighbors();

    public boolean isClique() {
        int counter = 0;
        int correctEdgeNumber = (size * (size - 1)) / 2;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                boolean firstConnection = check(i, j);
                boolean secondConnection = check(j, i);
                if ((firstConnection || secondConnection) && !(firstConnection && secondConnection)) {
                    counter++;
                }

            }
        }
        return counter == correctEdgeNumber;
    }

    public boolean isDirectedGraph() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) // nie uwzględniamy pętli?
                {
                    boolean firstConnection = check(i, j);
                    if (firstConnection) {
                        if (!check(j, i))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public void printIncidenceMatrix() {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (check(i, j) && i != j) {
                    matrix[i][j] = 1;
                    matrix[j][i] = -1;
                }
            }
        }
        System.out.println("Macierz incydencji: ");
        for (int index = 0; index < 3; index++) {
            System.out.print(" ");
        }
        System.out.print("|  ");
        for (int index = 0; index < size; index++) {
            System.out.print(index + "  |  ");
        }
        System.out.println();
        for (int index = 0; index < (size - 1) * 10; index++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": |  ");
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == -1)
                    System.out.print(matrix[i][j] + " |  ");
                else
                    System.out.print(matrix[i][j] + "  |  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object arg0) {
        if (arg0 instanceof AGraph) {
            if (((AGraph) arg0).size != size)
                return false;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (check(i, j) && !((AGraph) arg0).check(i, j))
                        return false;
                }
            }
            return true;
        }
        return false;
    }

}