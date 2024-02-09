public interface IStos<T> {
    public void push(T i); // dodaje i na stos

    public T pop(); // zdejmuje element, zwraca wartość z wierzchołka

    public T peek(); // zwraca wartość z wierzchołka stosu

    public boolean isEmpty(); // sprawdza, czy stos jest pusty

    public void print(boolean withComa); // wypisuje na ekran zawartość stosu

    public void clear(); // usuwa wszystkie elementy ze stosu

}
