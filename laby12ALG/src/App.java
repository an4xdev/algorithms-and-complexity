public class App {
    public static void main(String[] args) throws Exception {

        // zad1();
        zad2();
    }

    public static void zad1() {
        TextSearch textSearch = new TextSearch("Agata jest bogata", "ata");
        textSearch.search();
        textSearch.setFind("jest");
        textSearch.search();
        textSearch.setFind("oho");
        textSearch.search();
    }

    public static void zad2() {
        MergSort mergSort = new MergSort();
        int[] t = { 1, 2, 30, 10, 20, 15, 7, 5 };
        mergSort.setTab(t);
        mergSort.print();
        mergSort.sort();
        mergSort.print();
        System.out.println("//////////////////////////////////////////////");
        t = new int[] { 43, 18, 21, 30, 13, 52, 51, 75, 80, 62 };
        mergSort.setTab(t);
        mergSort.print();
        mergSort.sort();
        mergSort.print();
        System.out.println("//////////////////////////////////////////////");
        t = new int[] { 1, 5, 7, 1, 0, 5, 2 };
        mergSort.setTab(t);
        mergSort.print();
        mergSort.sort();
        mergSort.print();
    }
}
