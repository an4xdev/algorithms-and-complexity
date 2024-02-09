
public class App {
    public static void main(String[] args) throws Exception {
        MySort mySort = new MySort();
        mySort.wypelnij(10, 20);
        System.out.println("##################################################################");
        System.out.println("Sortowanie bąbelkowe:");
        mySort.wypisz();
        mySort.sortuj(true, Sort.SortMethod.BUBBLE);
        System.out.println("##################################################################");
        System.out.println("Sortowanie przez selekcję:");
        mySort.wypisz();
        mySort.wypelnij(10, 20);
        mySort.sortuj(false, Sort.SortMethod.SELECTION);
        System.out.println("##################################################################");
        System.out.println("Sortowanie przez wstawianie:");
        mySort.wypelnij(10, 20);
        mySort.wypisz();
        mySort.sortuj(true, Sort.SortMethod.INSERTION);
    }
}
