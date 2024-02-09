public interface IZbior {
    void wczytaj(String filename);

    void wypisz();

    void dodaj(int nowy);

    void usun(int element);

    boolean czyZawiera(int element);

    boolean czyRowne(IZbior drugi);

    IZbior suma(IZbior drugi);

    IZbior roznica(IZbior drugi);

    IZbior przeciecie(IZbior drugi);

    IZbior roznicaSymetryczna(IZbior drugi);

    boolean zawieraSie(IZbior drugi);
}
