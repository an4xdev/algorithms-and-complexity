public abstract class Sort2 {

    int[] tab; // tablica liczb do sortowania
    int ileT; // ile elementów jest w tablicy

    protected abstract int losuj(int w_max); // zwraca losowa liczbe z przedzialu 0..w_max

    public abstract void wypelnij(int n, int wartosc_maksymalna);// wypelnia tablice n losowymi liczbami z przedzialu 0..w_max

    public abstract void wypisz(); // wypisuje zawartosc tablicy tab

    public abstract void wypiszDrzewo(); // wypisuje zawartosc tablicy tab w postaci drzewa (kopiec)

    protected abstract void downHeap(int i); // przesuwa i-ty element tablicy tab w dol kopca

    protected abstract void construct(); // przestawia elementy tablicy tak, zeby tworzyly kopiec

    protected abstract int deleteMax(); // usuwa element maksymalny z kopca

    protected abstract void heapSort(); // sortuje przez kopcowanie

    protected abstract void quicksort(); // sortowanie szybkie

    protected abstract void countsort(); // sortowanie przez zliczanie

}