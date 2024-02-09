import java.util.ArrayList;

public class LGraph extends AGraph {
    private ArrayList<ArrayList<Integer>> list;

    /**
     * Konstruktor.
     * 
     * @param vertexCount - ilośc wierzchołków
     */
    public LGraph(int vertexCount) {
        super(vertexCount);
        list = new ArrayList<ArrayList<Integer>>();
        initializeList(vertexCount);
    }

    private void initializeList(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new ArrayList<Integer>());
        }

    }

    @Override
    public void writeMatrix() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeMatrix'");
    }

    @Override
    public boolean check(int i, int j) throws IllegalArgumentException {
        if (i < 0 || j < 0)
            throw new IllegalArgumentException("Nie można sprawdzić połącznia dla ujemnego wierzchołka");
        if (i > super.size - 1 || j > super.size - 1)
            throw new IllegalArgumentException("Nie można sprawdzić połącznia dla wierzchołka, który nie istnieje");
        return list.get(i).contains(j);
    }

    @Override
    public void connect(int i, int j) throws IllegalArgumentException {
        if (i < 0 || j < 0)
            throw new IllegalArgumentException("Nie można ustawić lini dla ujemnego wierzchołka");
        if (i > super.size - 1 || j > super.size - 1)
            throw new IllegalArgumentException("Nie można ustawić linia dla wierzchołka, który nie istnieje");

        list.get(i).add(j);
    }

    @Override
    public void writeList() {
        int count = 0;
        for (ArrayList<Integer> row : list) {
            System.out.print(count + ": ");
            for (int column : row) {
                System.out.print(column + ", ");
            }
            count++;
            System.out.println();
        }
    }

    @Override
    public void transpositionGraph() {
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < super.size; i++) {
            transpose.add(new ArrayList<Integer>());
        }
        int counter = 0;
        for (ArrayList<Integer> row : list) {
            for (Integer column : row) {
                transpose.get(column).add(counter);
            }
            counter++;
        }
        list = transpose;

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
        if (!list.get(k).isEmpty())
            return true;

        for (int i = 0; i < super.size; i++) {
            if (i != k) {
                if (list.get(i).contains(k)) {
                    return true;
                }
            }
        }
        return false;
    }
}
