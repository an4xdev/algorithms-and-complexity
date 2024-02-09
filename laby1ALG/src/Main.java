public class Main {
    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
        zad4();
        zad5();
        zad6();
        zad7();
        zad8();
        zad9();
    }

    public static void zad1() {
        int s = 86400 * 2 + 1000;
        SecondsConverter.Convert(s);
    }

    public static void zad2() {
        int a = 33;
        int b = 22;
        System.out.println("NWD A: " + a + ", B: " + b + " = " + NWD.Calculate(a, b));
    }

    public static void zad3() {
        int a = 17;
        System.out.println("A: " + a + " is prime: " + Prime.IsPrime(a));
    }

    public static void zad4() {
        String number = "1001";
        System.out.println("Binary: " + number + ", Decimal: " + BinaryToDecimal.Calculate(number));
    }

    public static void zad5() {
        PrimesInRange.Calculate(100);
    }

    public static void zad6() {
        int number = 4398;
        System.out.println("\nEntered number: " + number + ", result: " + SumOfDigits.Sum(number));
    }

    public static void zad7() {
        int number = 5;
        System.out.println(number + "! = " + Factorial.Calculate(number));
    }

    public static void zad8() {
        int n = 6;
        System.out.println(n + "-th Fibbonacci number = " + Fibbonaci.Calculate(n));
    }

    public static void zad9() {
        int n = 3;
        int k = 2;
        System.out.println("N: " + n + ", K: " + k + ", result = " + Newton.Calculate(n, k));
    }
}