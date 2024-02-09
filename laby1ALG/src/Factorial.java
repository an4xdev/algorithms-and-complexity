public class Factorial {
    public static int Calculate(int n)
    {
        return F(n);
    }

    private static int F(int n)
    {
        if(n == 1)
            return 1;
        else
            return n * F(n-1);
    }
}
