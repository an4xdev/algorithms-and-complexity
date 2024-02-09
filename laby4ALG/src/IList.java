
/**
 * Interfejs listy jedno- i dwukierunkowej, do zaimplementowania.
 * 
 * @param <T> typ elementow przechowywanych w liscie
 */
public interface IList<T> {

    /**
     * Dodaje dane na poczatek listy.
     *
     * @param newData dane do dodania
     */
    public void addFirst(T newData);

    /**
     * Dodaje dane na koniec listy.
     *
     * @param newData dane do dodania
     */
    public void addLast(T newData);

    /**
     * Dodaje dane do listy we wskazanym miejscu.
     *
     * @param newData  dane do dodania
     * @param position pozycja w liscie, na ktorej maja znajdowac sie nowe dane
     *                 po pomyslnym wykonaniu operacji. Wartosc zero odpowiada
     *                 pocztkowi listy.
     * @throws ListException jezeli podana pozycja jest mniejsza niz zero lub
     *                       wieksza niz liczba elementow w liscie
     */
    public void addAtPosition(T newData, int position) throws ListException;

    /**
     * Zwraca liczbe elementow listy.
     *
     * @return liczba elementow listy
     */
    public int size();

    /**
     * Zwraca wartosc przechowywana w liscie na podanej pozycji.
     * 
     * @param position indeks elementu do pobrania, 0 oznacza pierwszy element.
     * @return wartosc przechowywana w liscie na podanej pozycji
     * @throws ListException jesli nie istnieje element o podanym indeksie
     */
    public T get(int position) throws ListException;

    /**
     * Usuwa poczatkowy element listy.
     *
     * @return dane z usuwanego elementu
     * @throws ListException jezeli lista jest pusta
     */
    public T removeFirst() throws ListException;

    /**
     * Usuwa ostatni element listy.
     *
     * @return dane z usuwanego elementu
     * @throws ListException jezeli lista jest pusta
     */
    public T removeLast() throws ListException;

    /**
     * Usuwa element listy o podanym indeksie.
     *
     * @param position indeks elementu do usuniecia. Pierwszy element listy ma
     *                 indeks zero.
     * @return dane z usuwanego elementu
     * @throws ListException jezeli podany indeks jest mniejszy niz zero lub
     *                       wiekszy niz aktualny rozmiar listy
     */
    public T remove(int position) throws ListException;

    /**
     * Wyszukuje w liscie element o podanej wartosci.
     *
     * @param dataToFind poszukiwane dane
     * @return indeks pierwszego elementu listy, ktory zawiera poszukiwane dane,
     *         lub -1, jesli lista nie zawiera poszukiwanej wartosci
     */
    public int find(T dataToFind);

    /**
     * Sprawdza, czy lista zawiera podana wartosc.
     * 
     * @param data poszukiwane dane
     * @return true, jesli lista zawiera poszukiwane dane, lub false w przeciwnym
     *         wypadku
     */
    public boolean contains(T data);

    /**
     * Wypisuje na ekran zawartosc listy.
     */
    public void print();

    /**
     * Łączy dwie listy w jedną.
     * 
     * @param druga druga lista
     * @return IList, lista zawierające dane z dwóch list
     */
    public IList<T> join(IList<T> druga);

    /**
     * Sprawdza czy obie listy zawierają takie same elementy w dowolnej kolejności.
     * 
     * @param druga druga lista
     * @return true, jeżeli warunki są spełnione, false w przeciwnym przypadku
     */
    public boolean similar(IList<T> druga);
}
