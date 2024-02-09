public class Main {
    public static void main(String[] args) {
        // intType();
        // genericType();
        // iterableImplementation();
    }

    public static void iterableImplementation() {
        System.out.println("\nPrzykład implementacji interfejsu Iterable");
        ZbiorT<String> a = new ZbiorT<String>();
        a.wczytaj("src/sumaA.txt");
        for (String string : a) {
            System.out.println(string);
        }
    }

    public static void genericType() {
        System.out.println("\nSuma:");
        ZbiorT<String> a = new ZbiorT<String>();
        a.wczytaj("src/sumaA.txt");
        a.wypisz();
        ZbiorT<String> b = new ZbiorT<String>();
        b.wczytaj("src/sumaB.txt");
        b.wypisz();
        a.suma(b).wypisz();
        System.out.println("\nPrzecięcie:");
        a = new ZbiorT<String>();
        a.wczytaj("src/przeA.txt");
        a.wypisz();
        b = new ZbiorT<String>();
        b.wczytaj("src/przeB.txt");
        b.wypisz();
        a.przeciecie(b).wypisz();
        System.out.println("\nRóżnica:");
        a = new ZbiorT<String>();
        a.wczytaj("src/rozA.txt");
        a.wypisz();
        b = new ZbiorT<String>();
        b.wczytaj("src/rozB.txt");
        b.wypisz();
        a.roznica(b).wypisz();
        System.out.println("\nRóżnica symetralna:");
        a = new ZbiorT<String>();
        a.wczytaj("src/rsymA.txt");
        a.wypisz();
        b = new ZbiorT<String>();
        b.wczytaj("src/rsymB.txt");
        b.wypisz();
        a.roznicaSymetryczna(b).wypisz();
        System.out.println("\nCzy zbiór A zawiera się w B?");
        a = new ZbiorT<String>();
        a.wczytaj("src/zawieraA.txt");
        a.wypisz();
        b = new ZbiorT<String>();
        b.wczytaj("src/zawieraB.txt");
        b.wypisz();
        System.out.println(a.zawieraSie(b) ? "A zawiera się w B" : "A nie zawiera się w B");
        System.out.println("\nCzy zbiór A zawiera się w B?");
        a = new ZbiorT<String>();
        a.wczytaj("src/nieZawieraA.txt");
        a.wypisz();
        b = new ZbiorT<String>();
        b.wczytaj("src/nieZawieraB.txt");
        b.wypisz();
        System.out.println(a.zawieraSie(b) ? "A zawiera się w B" : "A nie zawiera się w B");
    }

    public static void intType() {
        System.out.println("\nSuma:");
        Zbior a = new Zbior(100);
        a.wczytaj("src/sumaA.txt");
        a.wypisz();
        Zbior b = new Zbior(100);
        b.wczytaj("src/sumaB.txt");
        b.wypisz();
        a.suma(b).wypisz();
        System.out.println("\nPrzecięcie:");
        a = new Zbior(100);
        a.wczytaj("src/przeA.txt");
        a.wypisz();
        b = new Zbior(100);
        b.wczytaj("src/przeB.txt");
        b.wypisz();
        a.przeciecie(b).wypisz();
        System.out.println("\nRóżnica:");
        a = new Zbior(100);
        a.wczytaj("src/rozA.txt");
        a.wypisz();
        b = new Zbior(100);
        b.wczytaj("src/rozB.txt");
        b.wypisz();
        a.roznica(b).wypisz();
        System.out.println("\nRóżnica symetralna:");
        a = new Zbior(100);
        a.wczytaj("src/rsymA.txt");
        a.wypisz();
        b = new Zbior(100);
        b.wczytaj("src/rsymB.txt");
        b.wypisz();
        a.roznicaSymetryczna(b).wypisz();
        System.out.println("\nCzy zbiór A zawiera się w B?");
        a = new Zbior(100);
        a.wczytaj("src/zawieraA.txt");
        a.wypisz();
        b = new Zbior(100);
        b.wczytaj("src/zawieraB.txt");
        b.wypisz();
        System.out.println(a.zawieraSie(b) ? "A zawiera się w B" : "A nie zawiera się w B");
        System.out.println("\nCzy zbiór A zawiera się w B?");
        a = new Zbior(100);
        a.wczytaj("src/nieZawieraA.txt");
        a.wypisz();
        b = new Zbior(100);
        b.wczytaj("src/nieZawieraB.txt");
        b.wypisz();
        System.out.println(a.zawieraSie(b) ? "A zawiera się w B" : "A nie zawiera się w B");
    }
}