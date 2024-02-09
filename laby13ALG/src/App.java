public class App {
    public static void main(String[] args) {
        // zad1();
        // zad2();
        // zad3();
        zad4();
    }

    public static void zad1() {
        var find = new FindText();
        find.setTemplate("aaac");
        System.out.println("Wzorzec: aaac " + (find.isEasy() ? "jest" : "nie jest") + " łatwy");

        find.setTemplate("aadc");
        System.out.println("Wzorzec: aadc " + (find.isEasy() ? "jest" : "nie jest") + " łatwy");

        find.setTemplate("abababc");
        System.out.println("Wzorzec: abababc " + (find.isEasy() ? "jest" : "nie jest") + " łatwy");

        find.setTemplate("ababacc");
        System.out.println("Wzorzec: ababacc " + (find.isEasy() ? "jest" : "nie jest") + " łatwy");

        find.setTemplate("abaabaabac");
        System.out.println("Wzorzec: abaabaabac " + (find.isEasy() ? "jest" : "nie jest") + " łatwy");

        find.setTemplate("abaabaabdc");
        System.out.println("Wzorzec: abaabaabdc " + (find.isEasy() ? "jest" : "nie jest") + " łatwy");
    }

    public static void zad2() {
        var find = new FindText();
        find.setTemplate("abbabbbab");
        find.setText("abbabbbabFabbabbbabLabbabbbab");
        find.GS();
        find.setTemplate("abaaaaab");
        find.setText("aaaaaaaab");
        find.GS();
    }

    public static void zad3() {
        var find = new FindText();
        find.setTemplate("abbabcabb");
        find.setText("abbabcabbFFFabbabcabbLLLabbabcabb");
        find.KMP();
    }

    public static void zad4() {
        var find = new FindText();
        find.setTemplate("ABC");
        find.setText("ABDAABCAABC");
        find.BM();
    }
}
