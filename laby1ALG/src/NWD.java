public class NWD {
    public static int Calculate(int a, int b)
    {
        while (a%b !=0)
        {
            int mod = a%b;
            a = b;
            b = mod;
        }
        return b;
    }
}
