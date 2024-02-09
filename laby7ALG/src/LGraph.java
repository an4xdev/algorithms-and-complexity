import java.util.ArrayList;
import java.util.List;

/**
 * Listowa reprezentacja grafu.
 */
public abstract class LGraph {

    /**
     * aktualna liczba wierzcholkow w grafie
     */
    protected int iloscWierzcholkow = 0;
    /**
     * Lista list sasiadow wszystkich wiercholkow
     */
    protected ArrayList<List<Integer>> listaSasiedztwa;

    public LGraph() {
        listaSasiedztwa = new ArrayList<List<Integer>>();
    }

    /**
     * Wypisuje graf w postaci listowej.
     */
    public abstract void writeList();

    /**
     * Wypisuje graf w postaci macierzy sasiedztwa.
     */
    public abstract void writeMatrix();

    /**
     * dodaje wierzcholek do grafu i zwraca jego numer. Metoda ma utworzyc pusta
     * liste sasiedztwa dla nowo wstawionego wierzcholka oraz inkrementowac
     * atrybut iloscWierzcholkow
     * 
     * @return int numer wierzchołka
     */
    public abstract int addVertex();

    /**
     * Dodaje krawedz do grafu.
     * 
     * @param source - wierzchołek startowy
     * @param target - wierzchołek docelowy
     */
    public abstract void addEdge(int source, int target) throws IllegalArgumentException;

    /**
     * Zwraca liste sasiadow podanego wierzcholka.
     * 
     * @param v - wierzchołek
     * @return List<Integer> - lista wierzchołków
     * @throws IllegalArgumentException
     */
    public abstract List<Integer> sasiedzi(int v) throws IllegalArgumentException;

    /**
     * Sprawdza, czy istnieje krawedz pomiedzy wierzcholkiem i oraz j.
     * 
     * @param i - wierzchołek i
     * @param j - wierzchołek j
     * @throws IllegalArgumentException
     */
    public abstract boolean check(int i, int j) throws IllegalArgumentException;

    /**
     * Przeszukuje graf w glab. Wypisuje wierzcholki w kolejnosci odwiedzania.
     * Wykorzystuje metode odwiedzaj.
     */
    public abstract void dfs();

    /**
     * Metoda rekurencyjna odwiedzajaca wierzcholek i jego nastepniki.
     * 
     * @param wierzchołek - wierzchołek odwiedzany
     */
    protected abstract void odwiedzaj(int wierzcholek);

    /**
     * Wykonuje transpozycje grafu.
     */
    public abstract LGraph transpose();
}