public interface IZbiorT<T> {
    void wczytaj(String filename);

    void wypisz();

    void dodaj(T nowy);

    void usun(T element);

    boolean czyZawiera(T element);

    boolean czyRowne(IZbiorT<T> drugi);

    IZbiorT<T> suma(IZbiorT<T> drugi);

    IZbiorT<T> roznica(IZbiorT<T> drugi);

    IZbiorT<T> przeciecie(IZbiorT<T> drugi);

    IZbiorT<T> roznicaSymetryczna(IZbiorT<T> drugi);

    boolean zawieraSie(IZbiorT<T> drugi);
}
