public class Prime {
    public static boolean IsPrime(int a)
    {
        int n = (int) Math.sqrt(a);
        for (int i = 2; i <= n; i++)
        {
            if(a%i==0)
                return false;
        }
        return true;
    }
}
