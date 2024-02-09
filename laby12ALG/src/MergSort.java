public class MergSort {
    private int[] tab;
    private int[] temp;

    public void setTab(int[] tab) {
        this.tab = tab;
    }

    public void print() {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println();
    }

    public void sort() {
        boolean run = true;
        temp = new int[tab.length];
        int i = 0, j = 1, right = 0, left = 0;
        while (run) {
            i = 0;
            while (tab[i] <= tab[i + 1] && i + 1 < tab.length - 1) {
                i++;
            }
            j = tab.length - 1;
            while (tab[j - 1] >= tab[j] && j - 1 != i) {
                j--;
            }
            right = 0;
            left = tab.length - 1;
            for (int k = 0; k <= tab.length - 1; k++) {
                if (left < j) {
                    temp[k] = tab[right];
                    right++;
                } else if (right > i) {
                    temp[k] = tab[left];
                    left--;
                } else {
                    if (tab[right] < tab[left]) {
                        temp[k] = tab[right];
                        right++;
                    } else {
                        temp[k] = tab[left];
                        left--;
                    }
                }
            }
            if (i + 1 == tab.length - 1) {
                run = false;
            }
            int[] foo = tab;
            tab = temp;
            temp = foo;
        }
    }

}
