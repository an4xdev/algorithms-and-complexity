import java.util.Random;

public class MySort extends Sort {

    private Random random;

    public MySort() {
        random = new Random();
    }

    @Override
    protected int losuj(int w_max) {
        return random.nextInt(w_max + 1);
    }

    @Override
    protected void selectionsort(boolean rosnaco) {
        for (int i = 0; i < tab.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < tab.length; j++)
                if ((rosnaco && tab[j] < tab[idx]) || (!rosnaco && tab[j] > tab[idx])) {
                    idx = j;
                }
            int temp = tab[idx];
            tab[idx] = tab[i];
            tab[i] = temp;
            wypisz();

        }
    }

    @Override
    protected void insertsort(boolean rosnaco) {
        for (int i = 1; i < tab.length; i++) {
            int key = tab[i];
            int j = i - 1;

            while (j >= 0 && ((rosnaco && tab[j] > key) || (!rosnaco && tab[j] < key))) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = key;
            wypisz();
        }
    }

    @Override
    protected void bubblesort(boolean rosnaco) {
        boolean checks = false;
        for (int i = tab.length - 1; i >= 0; i--) {
            checks = false;
            for (int j = 0; j < i; j++) {
                if ((rosnaco && tab[j + 1] < tab[j]) || (!rosnaco && tab[j + 1] > tab[j])) {
                    int temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
                    checks = true;
                }
            }
            wypisz();
            if (!checks)
                break;
        }
    }

    @Override
    public void wypelnij(int n, int wartosc_maksymalna) {
        tab = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = losuj(wartosc_maksymalna);
        }
    }

    @Override
    public void sortuj(boolean rosnaco, Sort.SortMethod metoda) {
        switch (metoda) {
            case SELECTION:
                selectionsort(rosnaco);
                break;
            case INSERTION:
                insertsort(rosnaco);
                break;
            case BUBBLE:
                bubblesort(rosnaco);
                break;
            default:
                System.out.println("Podano nieznany algorytm sortowania");
                break;
        }
    }

    @Override
    public void wypisz() {
        System.out.println("Zawartość tablicy:");
        if (tab != null) {
            for (int i = 0; i < tab.length; i++) {
                System.out.print(tab[i] + ", ");
            }
            System.out.println();
        } else {
            System.out.println("Tablica jest niezainicjalizowana");
        }
    }

}
