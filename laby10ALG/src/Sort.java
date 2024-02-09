public abstract class Sort {

    public enum SortMethod {

        SELECTION, INSERTION, BUBBLE;
    }

    int[] tab; // tablica liczb do sortowania
    int ile; // ile elementów jest w tablicy

    /**
     * zwraca losowa liczbe z przedzialu 0..w_max
     * 
     * @param w_max maksymalna wartość
     * @return
     */
    protected abstract int losuj(int w_max);

    protected abstract void selectionsort(boolean rosnaco);

    protected abstract void insertsort(boolean rosnaco);

    protected abstract void bubblesort(boolean rosnaco);

    /**
     * wypelnia tablice n losowymi liczbami z przedzialu 0..w_max
     * 
     * @param n                  ilość liczb
     * @param wartosc_maksymalna maksymalna wartość liczby
     */
    public abstract void wypelnij(int n, int wartosc_maksymalna);

    /**
     * wywoluje odpowiedni algorytm sortowania
     * 
     * @param rosnaco typ sortowania true -> rosnąco, false -> malejąco
     * @param metoda  typ sortowania
     */
    public abstract void sortuj(boolean rosnaco, SortMethod metoda);

    /**
     * wypisuje zawartosc tablicy tab
     */
    public abstract void wypisz();
}