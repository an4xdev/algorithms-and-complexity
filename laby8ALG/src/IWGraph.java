/**
 * Interfejs grafu ważonego.
 */
public interface IWGraph {

    /**
     * Stała oznaczjąca brak krawędzi między wierzchołkami.
     * Zakładamy, że wagi na krawędziach będą istotnie mniejsze niż ta wartość.
     */
    public static int INFTY = 99999;

    /**
     * Dodaje podaną liczbę wierzchołków do grafu. W zależności od wybranej
     * reprezentacji grafu (listowa bądź macierzowa) należy dodać nowe elementy
     * do listy, lub zaalokować większą tablicę przepisując poprzednią
     * zawartość.
     *
     * @param i liczba wierzchołków do dodania
     * @throws java.lang.Exception jeśli podano ujemną liczbę wierzchołków
     */
    public void addVertices(int i) throws Exception;

    /**
     * Dodaje krawędź o określonej wadze pomiędzy dwoma wierzchołkami.
     *
     * @param start  wierzchołek źródłowy dodawanej krawędzi
     * @param stop   wierzchołek docelowy dodawanej krawędzi
     * @param weight waga dodawanej krawędzi
     * @throws java.lang.Exception jeśli wierzchołek żródłowy lub docelowy nie
     *                             istnieje lub jesli podano ujemną wagę
     */
    public void addEdge(int start, int stop, int weight) throws Exception;

    /**
     * Sprawdza, czy pomiędzy dwoma wierzchołkami istnieje krawędź. Jeśli tak,
     * to zwracana jest waga krawędzi. Jeśli nie to zwracana jest wartość INFTY.
     *
     * @param start numer wierzchołka żródłowego
     * @param stop  numer wierzchołka docelowego
     * @return wagę krawędzi lub INFTY, jesli krawędź nie istnieje
     * @throws java.lang.Exception jeśli podano nieistniejący numer wierzchołka
     *                             źródłowego lub docelowego
     */
    public int wCheck(int start, int stop) throws Exception;

    /**
     * Wypisuje na ekran graf w postaci tablicowej lub listowej.
     */
    public void writeGraph();

    /**
     * Wypisuje na ekran najmniejsze odległości od podanego wierzchołka do
     * wszystkich pozostałych wierzchołków, wykorzystując algorytm
     * Bellmana-Forda.
     *
     * @param start numer wierzchołka startowego
     * @throws java.lang.Exception jeśli podano nieprawidłowy numer wierzchołka
     */
    public void ford(int start) throws Exception;

    /**
     * Wypisuje na ekran najmniejsze odległości od podanego wierzchołka do
     * wszystkich pozostałych wierzchołków, wykorzystując algorytm Dijksrty.
     *
     * @param start numer wierzchołka startowego
     * @throws java.lang.Exception jeśli podano nieprawidłowy numer wierzchołka
     */
    public void dijkstra(int start) throws Exception;

    /**
     * Wypisuje na ekran silnie spójne składowe grafu.
     */
    public void SSS() throws Exception;

}