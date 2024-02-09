public class Fibbonaci {
    public static int Calculate(int n)
    {
        return Fibb(n);
    }

    private static int Fibb(int n)
    {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return Fibb(n-1) + Fibb(n-2);
    }
}
