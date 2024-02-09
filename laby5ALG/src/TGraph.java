
public class TGraph extends AGraph {
    private int[][] matrix;

    /**
     * Konstruktor.
     * 
     * @param vertexCount - ilośc wierzchołków
     */
    public TGraph(int vertexCount) {
        super(vertexCount);
        matrix = new int[vertexCount][vertexCount];
    }

    @Override
    public void writeMatrix() {
        for (int index = 0; index < 3; index++) {
            System.out.print(" ");
        }
        System.out.print("| ");
        for (int index = 0; index < super.size; index++) {
            System.out.print(index + " | ");
        }
        System.out.println();
        for (int index = 0; index < super.size * 5 + 1; index++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < super.size; i++) {
            System.out.print(i + ": | ");
            for (int j = 0; j < super.size; j++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public boolean check(int i, int j) throws IllegalArgumentException {
        if (i < 0 || j < 0)
            throw new IllegalArgumentException("Nie można sprawdzić połącznia dla ujemnego wierzchołka");
        if (i > super.size - 1 || j > super.size - 1)
            throw new IllegalArgumentException("Nie można sprawdzić połącznia dla wierzchołka, który nie istnieje");
        return matrix[i][j] != 0;
    }

    @Override
    public void connect(int i, int j) throws IllegalArgumentException {
        if (i < 0 || j < 0)
            throw new IllegalArgumentException("Nie można ustawić lini dla ujemnego wierzchołka");
        if (i > super.size - 1 || j > super.size - 1)
            throw new IllegalArgumentException("Nie można ustawić linia dla wierzchołka, który nie istnieje");
        if (i != j)
            matrix[i][j] = 1;
        else
            matrix[i][j] = 2;
    }

    @Override
    public void writeList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeList'");
    }

    @Override
    public void transpositionGraph() {

        int transpose[][] = new int[super.size][super.size];

        for (int i = 0; i < super.size; i++) {
            for (int j = 0; j < super.size; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        matrix = transpose;
    }

    @Override
    public void writeEdgesWithoutNeighbors() {
        System.out.print("Wierzchołki bez sąsiadów: ");
        for (int i = 0; i < super.size; i++) {
            if (!checkNeighbors(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    private boolean checkNeighbors(int k) {
        for (int i = 0; i < super.size; i++) {
            if (matrix[k][i] != 0) {
                return true;
            }
        }
        for (int j = 0; j < super.size; j++) {
            if (matrix[j][k] != 0) {
                return true;
            }
        }
        return false;
    }
}
