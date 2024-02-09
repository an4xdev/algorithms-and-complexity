import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Zbior implements IZbior, Iterable<Integer> {

    private int[] tab;
    private int licznik;

    private int N;

    public Zbior(int n) {
        N = n;
        licznik = 0;
        tab = new int[n];

    }

    @Override
    public void wczytaj(String filename) {
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextInt()) {
                int readed = sc.nextInt();
                if (!czyZawiera(readed)) {
                    tab[licznik] = readed;
                    licznik++;
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void wypisz() {
        System.out.println("Zbiór zawiera: ");
        for (int i = 0; i < licznik; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println();
    }

    @Override
    public void dodaj(int nowy) {
        if (licznik == 0) {
            tab[licznik++] = nowy;
        }
        if (licznik <= N - 1) {
            if (!czyZawiera(nowy)) {
                tab[licznik] = nowy;
                licznik++;
            }
        }

    }

    @Override
    public void usun(int element) {
        if (czyZawiera(element)) {
            for (int i = 0; i < licznik; i++) {
                if (tab[i] == element) {
                    int last = tab[licznik - 1];
                    tab[i] = last;
                    licznik--;
                    break;
                }
            }
        }
    }

    @Override
    public boolean czyZawiera(int element) {
        for (int i = 0; i < licznik; i++) {
            if (tab[i] == element)
                return true;
        }
        return false;
    }

    @Override
    public boolean czyRowne(IZbior drugi) {
        Zbior x = (Zbior) drugi;
        if (licznik != x.licznik)
            return false;
        for (int i = 0; i < licznik; i++) {
            if (!drugi.czyZawiera(tab[i]))
                return false;
        }
        return true;
    }

    @Override
    public IZbior suma(IZbior drugi) {
        Zbior x = (Zbior) drugi;
        Zbior nowyZbior = new Zbior(licznik + x.licznik);

        for (int i = 0; i < licznik; i++) {
            nowyZbior.dodaj(tab[i]);
        }
        for (int i = 0; i < x.licznik; i++) {
            nowyZbior.dodaj(x.tab[i]);
        }
        return nowyZbior;
    }

    @Override
    public IZbior roznica(IZbior drugi) {
        Zbior x = (Zbior) drugi;
        Zbior nowyZbior = new Zbior(licznik + x.licznik);

        for (int i = 0; i < licznik; i++) {
            if (!drugi.czyZawiera(tab[i])) {
                nowyZbior.dodaj(tab[i]);
            }
        }
        return nowyZbior;
    }

    @Override
    public IZbior przeciecie(IZbior drugi) {
        Zbior x = (Zbior) drugi;
        Zbior nowyZbior = new Zbior(licznik + x.licznik);
        for (int i = 0; i < licznik; i++) {
            if (drugi.czyZawiera(tab[i])) {
                nowyZbior.dodaj(tab[i]);
            }
        }
        return nowyZbior;
    }

    @Override
    public IZbior roznicaSymetryczna(IZbior drugi) {
        IZbior first = suma(drugi);
        IZbior second = przeciecie(drugi);
        return first.roznica(second);
    }

    @Override
    public boolean zawieraSie(IZbior drugi) {
        Zbior x = (Zbior) drugi;
        if (licznik > x.licznik)
            return false;
        for (int i = 0; i < licznik; i++) {
            if (!x.czyZawiera(tab[i]))
                return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < tab.length;
            }

            @Override
            public Integer next() {
                return tab[currentIndex++];
            }
        };
    }
}
