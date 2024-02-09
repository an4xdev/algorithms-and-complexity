import java.util.Random;

class MySort2 extends Sort2 {
    private final Random random = new Random();

    @Override
    protected int losuj(int w_max) {
        return random.nextInt(w_max + 1);
    }

    @Override
    public void wypelnij(int n, int wartosc_maksymalna) {
        tab = new int[n];
        ileT = n;
        for (int i = 0; i < n; i++) {
            tab[i] = losuj(wartosc_maksymalna);
        }
    }

    @Override
    public void wypisz() {
        for (int i = 0; i < ileT; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public void wypiszDrzewo() {
        wypiszDrzewoRekurencyjnie(0, 0);
    }

    private void wypiszDrzewoRekurencyjnie(int i, int level) {
        if (i < ileT) {
            wypiszDrzewoRekurencyjnie(2 * i + 2, level + 1);

            for (int j = 0; j < level; j++) {
                System.out.print("     ");
            }
            System.out.println(tab[i]);

            wypiszDrzewoRekurencyjnie(2 * i + 1, level + 1);
        }
    }

    @Override
    protected void downHeap(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < ileT && tab[left] > tab[largest]) {
            largest = left;
        }

        if (right < ileT && tab[right] > tab[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            downHeap(largest);
        }
    }

    @Override
    protected void construct() {
        for (int i = ileT / 2 - 1; i >= 0; i--) {
            downHeap(i);

        }
    }

    @Override
    protected int deleteMax() {
        int max = tab[0];
        tab[0] = tab[ileT - 1];
        ileT--;
        downHeap(0);

        return max;
    }

    @Override
    protected void heapSort() {
        construct();
        int orgSize = ileT;

        for (int i = ileT - 1; i >= 0; i--) {
            int temp = tab[0];
            tab[0] = tab[i];
            tab[i] = temp;
            ileT--;
            downHeap(0);
        }

        ileT = orgSize;
    }

    @Override
    protected void quicksort() {
        quicksortRekurencyjnie(0, ileT - 1);
    }

    private void quicksortRekurencyjnie(int left, int right) {
        if (left < right) {
            int pivotIndex = podzielTablice(left, right);
            quicksortRekurencyjnie(left, pivotIndex - 1);
            quicksortRekurencyjnie(pivotIndex + 1, right);
        }
    }

    private int podzielTablice(int left, int right) {
        int pivot = tab[left];
        int i = left;
        int j = right + 1;
        while (i < j) {
            do {
                i++;
            } while (i <= right && tab[i] < pivot);
            do {
                j--;
            } while (j >= left && tab[j] > pivot);
            if (i < j) {
                swap(i, j);
            }
        }
        tab[left] = tab[j];
        tab[j] = pivot;
        return j;
    }

    private void swap(int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

    @Override
    protected void countsort() {
        int max = znajdzMax();
        int[] count = new int[max + 1];
        int[] output = new int[ileT];

        for (int i = 0; i < ileT; i++) {
            count[tab[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ileT - 1; i >= 0; i--) {
            output[count[tab[i]] - 1] = tab[i];
            count[tab[i]]--;
        }

        for (int i = 0; i < ileT; i++) {
            tab[i] = output[i];
        }
    }

    private int znajdzMax() {
        int max = tab[0];
        for (int i = 1; i < ileT; i++) {
            if (tab[i] > max) {
                max = tab[i];
            }
        }
        return max;
    }

}