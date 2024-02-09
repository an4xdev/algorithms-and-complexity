public class TGraph extends MGraph {

    /**
     * Konstruktor
     *
     * @param k ilość wierzchołków
     */
    public TGraph(int k) {
        super(k);
    }

    /**
     * Zwraca liczbe krawedzi w grafie.
     *
     * @return liczba krawedzi
     */
    @Override
    public int getEdgeCount() {
        int count = 0;
        for (int i = 0; i < super.getVertexCount(); i++) {
            for (int j = 0; j < super.getVertexCount(); j++) {
                if (isEdge(i, j))
                    count++;
            }
        }
        return count;
    }

    /**
     * Wypisuje macierz sasiedztwa grafu.
     */
    @Override
    public void writeMatrix() {
        for (int index = 0; index < 3; index++) {
            System.out.print(" ");
        }
        System.out.print("| ");
        for (int index = 0; index < super.getVertexCount(); index++) {
            System.out.print(index + " | ");
        }
        System.out.println();
        for (int index = 0; index < super.getVertexCount() * 5 + 1; index++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < super.getVertexCount(); i++) {
            System.out.print(i + ": | ");
            for (int j = 0; j < super.getVertexCount(); j++) {
                if (isEdge(i, j)) {
                    System.out.print("1 | ");
                } else {
                    System.out.print("0 | ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
