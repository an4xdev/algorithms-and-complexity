import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // zad1();
        // zad2();
        // listOneSimilarCheck();
        // listTwoSimilarCheck();
        // loadFromFileOnlyEven();
        // loadFromFileAndSum();
        // loadFromFileAndDoStats();
        loadAndSort();
    }

    public static void zad1() {
        ListOne<Integer> list = new ListOne<Integer>();
        try {
            System.out.println("First removed: " + list.removeLast());
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        //////////////////////////////////////////////////
        list.addFirst(10);
        list.addLast(11);
        list.addLast(12);
        list.addLast(13);
        list.print();
        list.addFirst(9);
        list.print();
        //////////////////////////////////////////////////
        try {
            System.out.println("First removed: " + list.removeFirst());
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        list.addFirst(9);
        list.print();
        try {
            System.out.println("Last removed: " + list.removeLast());
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        list.addLast(13);
        // list.print();
        for (int integer : list) {
            System.out.print(integer + ", ");
        }
        System.out.println();

        //////////////////////////////////////////////////
        System.out.println("List contains 12: " + list.contains(12));
        System.out.println("List contains 20: " + list.contains(20));
        //////////////////////////////////////////////////
        try {
            System.out.println("Get at -1 position: " + list.get(-1));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Get at 1000 position: " + list.get(1000));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Get at 1 position: " + list.get(1));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        //////////////////////////////////////////////////
        try {
            list.addAtPosition(123, 1);
            list.print();
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        try {
            list.addAtPosition(123, -1);
            list.print();
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        try {
            list.addAtPosition(123, 1000);
            list.print();
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        //////////////////////////////////////////////////
        int position = list.find(15);
        System.out.println("Element with data: 15 "
                + (position == -1 ? "nie znaleziono" : "znaleziono na pozycji: " + position));
        position = list.find(12);
        System.out.println("Element with data: 12 "
                + (position == -1 ? "nie znaleziono" : "znaleziono na pozycji: " + position));
        //////////////////////////////////////////////////
        try {
            System.out.println("Removed from -1 position, data: " + list.remove(-1));
            list.print();
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Removed from 1000 position, data: " + list.remove(1000));
            list.print();
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Removed from 1 position, data: " + list.remove(1));
            list.print();
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }

        ListOne<Integer> second = new ListOne<Integer>();
        second.addFirst(100);
        second.addLast(101);
        second.addLast(102);
        second.addLast(103);
        second.addLast(104);
        second.addLast(105);
        second.addLast(106);
        second.addLast(107);
        // second.print();
        System.out.print("Połączenie dwóch list: ");
        list.join(second).print();

    }

    public static void zad2() {
        ListTwo<Integer> list = new ListTwo<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.print();
        try {
            System.err.println("Próba pobrania danych z elementu -1: " + list.get(-1));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.err.println("Próba pobrania danych z elementu 1: " + list.get(1));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.err.println("Próba pobrania danych z elementu 100: " + list.get(100));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(
                    "Próba usunięcia pierwszego elementu: " + list.removeFirst());

        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        list.print();
        try {
            System.out.println(
                    "Próba usunięcia ostatniego elementu: " + list.removeLast());
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        list.print();
        try {
            System.out.println(
                    "Próba usunięcia pierwszego elementu z pozycji 1: "
                            + list.remove(1));
        } catch (ListException e) {
            System.out.println(e.getMessage());
        }
        list.print();
        int position = list.find(5);
        System.out.println("Element z danymi 5 "
                + (position != -1 ? "znaleziony na pozycji: " + position : "nie został znaleziony"));
        System.out.println(
                "Element z danymi 5 " + (list.contains(5) ? "znaleziono" : "nie znaleziono"));

        ListTwo<Integer> second = new ListTwo<Integer>();
        second.addFirst(100);
        second.addLast(101);
        second.addLast(102);
        second.addLast(103);
        second.addLast(104);
        second.addLast(105);
        second.addLast(106);
        second.addLast(107);
        second.print();
        list.join(second).print();
    }

    public static void listOneSimilarCheck() {
        ListOne<Integer> first = new ListOne<Integer>();
        first.addLast(1);
        first.addLast(2);
        first.addLast(3);
        first.addLast(4);
        first.addLast(5);

        ListOne<Integer> second = new ListOne<Integer>();
        second.addFirst(1);
        second.addFirst(2);
        second.addFirst(3);
        second.addFirst(4);
        second.addFirst(5);

        System.out.print("Lista 1: ");
        first.print();
        System.out.print("Lista 2: ");
        second.print();

        System.out.println("Lista 1 i List 2 " + (first.similar(second) ? "są podobne" : "nie są podobne"));
        System.out.println();
        first = new ListOne<Integer>();
        first.addLast(1);
        first.addLast(2);
        first.addLast(3);
        first.addLast(4);
        first.addLast(5);
        first.addLast(6);

        second = new ListOne<Integer>();
        second.addFirst(1);
        second.addFirst(2);
        second.addFirst(3);
        second.addFirst(4);
        second.addFirst(5);

        System.out.print("Lista 1: ");
        first.print();
        System.out.print("Lista 2: ");
        second.print();

        System.out.println("Lista 1 i List 2 " + (first.similar(second) ? "są podobne" : "nie są podobne"));
        System.out.println();
        first = new ListOne<Integer>();
        first.addLast(1);
        first.addLast(2);
        first.addLast(3);
        first.addLast(4);
        first.addLast(5);

        second = new ListOne<Integer>();
        second.addFirst(1);
        second.addFirst(2);
        second.addFirst(3);
        second.addFirst(10);
        second.addFirst(5);

        System.out.print("Lista 1: ");
        first.print();
        System.out.print("Lista 2: ");
        second.print();

        System.out.println("Lista 1 i List 2 " + (first.similar(second) ? "są podobne" : "nie są podobne"));
    }

    public static void listTwoSimilarCheck() {
        ListTwo<Integer> first = new ListTwo<Integer>();
        first.addFirst(1);
        first.addLast(2);
        first.addLast(3);
        first.addLast(4);
        first.addLast(5);

        ListTwo<Integer> second = new ListTwo<Integer>();
        second.addFirst(1);
        second.addFirst(2);
        second.addFirst(3);
        second.addFirst(4);
        second.addFirst(5);

        System.out.print("Lista 1: ");
        first.print();
        System.out.print("Lista 2: ");
        second.print();

        System.out.println("Lista 1 i List 2 " + (first.similar(second) ? "są podobne" : "nie są podobne"));
        System.out.println();
        first = new ListTwo<Integer>();
        first.addFirst(1);
        first.addLast(2);
        first.addLast(3);
        first.addLast(4);
        first.addLast(5);
        first.addLast(6);

        second = new ListTwo<Integer>();
        second.addFirst(1);
        second.addFirst(2);
        second.addFirst(3);
        second.addFirst(4);
        second.addFirst(5);

        System.out.print("Lista 1: ");
        first.print();
        System.out.print("Lista 2: ");
        second.print();

        System.out.println("Lista 1 i List 2 " + (first.similar(second) ? "są podobne" : "nie są podobne"));
        System.out.println();
        first = new ListTwo<Integer>();
        first.addFirst(1);
        first.addLast(2);
        first.addLast(3);
        first.addLast(4);
        first.addLast(5);

        second = new ListTwo<Integer>();
        second.addFirst(1);
        second.addFirst(2);
        second.addFirst(3);
        second.addFirst(10);
        second.addFirst(5);

        System.out.print("Lista 1: ");
        first.print();
        System.out.print("Lista 2: ");
        second.print();

        System.out.println("Lista 1 i List 2 " + (first.similar(second) ? "są podobne" : "nie są podobne"));
    }

    public static void loadFromFileOnlyEven() {
        try {
            ArrayList<Integer> allNumbers = new ArrayList<Integer>();
            ListOne<Integer> onlyEvenList = new ListOne<Integer>();
            File plik = new File("onlyEven.txt");
            Scanner scanner = new Scanner(plik);

            while (scanner.hasNextInt()) {
                int liczba = scanner.nextInt();
                if (liczba % 2 == 0)
                    onlyEvenList.addLast(liczba);
                allNumbers.add(liczba);
            }
            System.out.println("Wszystkie liczby: " + allNumbers);
            System.out.print("Liczby parzyste: ");
            onlyEvenList.print();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został znaleziony.");
        }
    }

    public static void loadFromFileAndSum() {
        try {
            ListTwo<Integer> onlyEvenList = new ListTwo<Integer>();
            File plik = new File("onlyEven.txt");
            Scanner scanner = new Scanner(plik);
            int counter = 0;
            int sum = 0;
            while (scanner.hasNextInt()) {
                int liczba = scanner.nextInt();
                onlyEvenList.addLast(liczba);
                counter++;
                if (counter == 3) {
                    // System.out.println("Dodaję: " + liczba);
                    sum += liczba;
                    counter = 0;
                }
            }
            System.out.print("Lista: ");
            onlyEvenList.print();
            System.out.println("Suma co trzeciej: " + sum);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został znaleziony.");
        }
    }

    public static void loadFromFileAndDoStats() {
        try {
            ListTwo<Integer> onlyEvenList = new ListTwo<Integer>();
            File plik = new File("onlyEven.txt");
            Scanner scanner = new Scanner(plik);
            int counter = 0;
            int sum = 0;
            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;
            while (scanner.hasNextInt()) {
                int liczba = scanner.nextInt();
                onlyEvenList.addLast(liczba);
                counter++;
                sum += liczba;
                if (liczba < minValue)
                    minValue = liczba;
                if (liczba > maxValue)
                    maxValue = liczba;
            }
            System.out.print("Lista: ");
            onlyEvenList.print();
            System.out.println("Suma: " + sum);
            System.out.println("Średnia: " + ((float) sum / (float) counter));
            System.out.println("Max value: " + maxValue);
            System.out.println("Min value: " + minValue);

            double sumToOdchylenie = 0;
            double avg = (double) sum / (double) counter;
            for (Integer integer : onlyEvenList) {
                sumToOdchylenie += Math.pow((double) integer - avg, 2);
            }
            sumToOdchylenie = Math.sqrt(sumToOdchylenie / (double) counter);
            System.out.println("Odchylenie standardowe: " + sumToOdchylenie);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został znaleziony.");
        }
    }

    public static void loadAndSort() {
        ListOne<Integer> list = new ListOne<Integer>();
        list.addSorted(10);
        list.print();
        list.addSorted(9);
        list.print();
        list.addSorted(11);
        list.print();
        list.addSorted(7);
        list.print();
        list.addSorted(8);
        list.print();
    }
}
