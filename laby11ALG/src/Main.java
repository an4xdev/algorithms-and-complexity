public class Main {
    public static void main(String[] args) {
        MySort2 sortowanie = new MySort2();
        sortowanie.wypelnij(10, 50);
        System.out.println("Tablica przed sortowaniem:");
        sortowanie.wypisz();

        System.out.println("Drzewo kopca:");
        sortowanie.construct();
        sortowanie.wypiszDrzewo();

        System.out.println("\nTablica po sortowaniu:");
        sortowanie.heapSort();
        sortowanie.wypisz();
        System.out.println("Drzewo kopca:");
        sortowanie.wypiszDrzewo();

        System.out.println("///////////////////////////////////");
        System.out.println("quicksort:");
        sortowanie.wypelnij(10, 100);
        System.out.println("Tablica przed sortowaniem:");
        sortowanie.wypisz();

        System.out.println("Tablica po posortowaniu:");
        sortowanie.quicksort();
        sortowanie.wypisz();

        System.out.println("///////////////////////////////////");
        System.out.println("countsort:");
        sortowanie.wypelnij(10, 15);
        System.out.println("Tablica przed sortowaniem:");
        sortowanie.wypisz();

        System.out.println("Tablica po posortowaniu:");
        sortowanie.countsort();
        sortowanie.wypisz();
    }
}
