import java.util.Random;

public class BST<T extends Comparable<T>> {

    /**
     * Wartosc przechowywana w wezle.
     */
    protected T dane;
    /**
     * Lewe i prawe poddrzewo.
     */
    protected BST<T> lewy, prawy;

    public BST(T dane) {
        this.dane = dane;
    }

    /**
     * Rekurencyjnie dodaje element do drzewa BST.
     * 
     * @param nowy dane do przechowywania w nowym wezle
     */
    public void addBSTRec(T nowy) {
        if (this.dane.compareTo(nowy) < 0) {
            if (this.lewy == null) {
                this.lewy = new BST<T>(nowy);
            } else {
                this.lewy.addBSTRec(nowy);
            }
        } else {
            if (this.prawy == null) {
                this.prawy = new BST<T>(nowy);
            } else {
                this.prawy.addBSTRec(nowy);
            }
        }

    }

    /**
     * Wypisuje drzewo
     * 
     * @param poziom odleglosc wezla od korzenia. Zaczynamy od 0.
     */
    public void print(int poziom) {
        if (this.prawy != null) {
            this.prawy.print(poziom + 1);
        }
        if (this.lewy != null) {
            this.lewy.print(poziom + 1);
        }
        for (int i = 0; i < poziom * 2; i++) {
            System.out.print("-");
        }
        System.out.println(this.dane);
    }

    /**
     * Itercyjne wyszukiwanie wartosci w drzewie BST.
     * Zwraca pare: wezel zawierajacy poszukiwany element oraz jego poprzednika.
     * Jesli szukanego elementu nie ma w drzewie, to pierwszym elementem pary jest
     * null.
     * Jesli pierwszy element pary jest korzeniem (nie ma poprzednika), to drugim
     * elementem pary jest null.
     * 
     * @param szukany poszukiwana wartosc
     * @return para wezlow: pierwszy to wezel zawierajacy szukana wartosc lub null,
     *         jesli nie znaleziono;
     *         drugi element pary to rodzic wezla (lub null, jesli szukana wartosc
     *         jest w korzeniu drzewa)
     */
    public Pair<BST<T>, BST<T>> searchBST(T szukany) {
        Pair<BST<T>, BST<T>> pair = new Pair<BST<T>, BST<T>>(null, this);
        while (pair.second != null && szukany != pair.second.dane) {
            pair.first = pair.second;
            if (szukany.compareTo(pair.second.dane) < 0) {
                pair.second = pair.first.prawy;
            } else {
                pair.second = pair.first.lewy;
            }
        }
        return pair;
    }

    /**
     * Rekurencyjne przeszukuje drzewo BST.
     * Zwraca true, jesli znajdzie element o podanej wartosci .
     * 
     * @param szukany poszukiwana wartosc
     * @return true, jesli podana wartosc jest w drzewie, false w przeciwnym wypadku
     */
    public boolean searchBSTRec(T szukany) {
        if (this.dane == szukany) {
            return true;
        } else {
            if (szukany.compareTo(this.dane) < 0) {
                if (this.prawy != null)
                    return this.prawy.searchBSTRec(szukany);
                else
                    return false;
            } else {
                if (this.lewy != null)
                    return this.lewy.searchBSTRec(szukany);
                else
                    return false;
            }
        }

    }

    /**
     * Wstawianie nowego elementu przy pomocy funkcji public Pair<BST<T>, BST<T>>
     * searchBST(T szukany)
     * 
     * @param data nowa wartość
     */
    public void insertBTS(T data) {
        Pair<BST<T>, BST<T>> pair = searchBST(data);
        if (data.compareTo(pair.first.dane) < 0)
            pair.first.prawy = new BST<T>(data);
        else
            pair.first.lewy = new BST<T>(data);
    }

    /*
     * Usuwanie elementu o podanym kluczu z drzewa
     * 
     * @param data wartość usuniętego elementu
     */
    public void deleteBST(T data) {
        Pair<BST<T>, BST<T>> pair = searchBST(data);
        BST<T> x = pair.second;
        BST<T> y = pair.first;
        BST<T> z;
        BST<T> t;
        int b = -1;
        if (x != null) {
            if (x.lewy == null || x.prawy == null) {
                if (x.lewy == null && x.prawy == null) {
                    z = null;
                } else if (x.lewy == null) {
                    z = x.prawy;
                } else {
                    z = x.lewy;
                }
                if (y == null) {
                    // this = z;
                } else {
                    if (x == y.lewy) {
                        y.lewy = z;
                    } else {
                        y.prawy = z;
                    }
                }
            } else {
                b = new Random().nextInt(0, 2);
                if (b == 0) {
                    z = x.lewy;
                    if (z.prawy == null) {
                        x.lewy = z.lewy;
                    } else {
                        do {
                            t = z;
                            z = z.prawy;
                        } while (z.prawy == null);
                        t.prawy = z.lewy;
                    }
                } else {
                    z = x.prawy;
                    if (z.lewy == null) {
                        x.prawy = z.prawy;
                    } else {
                        do {
                            t = z;
                            z = z.lewy;
                        } while (z.lewy == null);
                    }
                }
                x.dane = z.dane;
            }

        }

    }
}
