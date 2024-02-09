public class Newton {
    public static int Calculate(int n, int k)
    {
        return N(n,k);
    }

    private static int N(int n, int k)
    {
        if( k == 0 || k == n)
            return 1;
        else
            return N(n-1,k-1)+N(n-1,k);
    }
}
