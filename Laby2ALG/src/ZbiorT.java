import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ZbiorT<T> implements IZbiorT<T>, Iterable<T> {

    private ArrayList<T> tab;

    public ZbiorT() {
        tab = new ArrayList<T>();
    }

    @Override
    public void wczytaj(String filename) {
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String readed = sc.next();
                if (!czyZawiera((T) readed)) {
                    dodaj((T) readed);
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void wypisz() {
        System.out.println("Zbiór zawiera:");
        for (T element : tab) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    @Override
    public void dodaj(T nowy) {
        tab.add(nowy);
    }

    @Override
    public void usun(T element) {
        tab.remove(element);
    }

    @Override
    public boolean czyZawiera(T element) {
        return tab.contains(element);
    }

    @Override
    public boolean czyRowne(IZbiorT<T> drugi) {
        ZbiorT<T> x = (ZbiorT<T>) drugi;
        if (tab.size() != x.tab.size())
            return false;
        for (T element : tab) {
            if (!drugi.czyZawiera(element))
                return false;
        }
        return true;
    }

    @Override
    public IZbiorT<T> suma(IZbiorT<T> drugi) {
        ZbiorT<T> x = (ZbiorT<T>) drugi;
        ZbiorT<T> nowyZbior = new ZbiorT<T>();

        for (T element : tab) {
            nowyZbior.dodaj(element);
        }
        for (T element : x.tab) {
            nowyZbior.dodaj(element);
        }
        return nowyZbior;
    }

    @Override
    public IZbiorT<T> roznica(IZbiorT<T> drugi) {
        ZbiorT<T> nowyZbior = new ZbiorT<T>();
        for (T element : tab) {
            if (!drugi.czyZawiera(element)) {
                nowyZbior.dodaj(element);
            }
        }
        return nowyZbior;
    }

    @Override
    public IZbiorT<T> przeciecie(IZbiorT<T> drugi) {
        IZbiorT<T> nowyZbior = new ZbiorT<T>();
        for (T element : tab) {
            if (drugi.czyZawiera(element)) {
                nowyZbior.dodaj(element);
            }
        }
        return nowyZbior;
    }

    @Override
    public IZbiorT<T> roznicaSymetryczna(IZbiorT<T> drugi) {
        IZbiorT<T> first = suma(drugi);
        IZbiorT<T> second = przeciecie(drugi);
        return first.roznica(second);
    }

    @Override
    public boolean zawieraSie(IZbiorT<T> drugi) {
        ZbiorT<T> x = (ZbiorT<T>) drugi;
        if (tab.size() > x.tab.size())
            return false;

        for (T element : tab) {
            if (!x.czyZawiera(element))
                return false;
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return tab.iterator();
    }

}
