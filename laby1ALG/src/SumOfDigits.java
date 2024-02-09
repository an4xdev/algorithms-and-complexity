public class SumOfDigits {
    public static int Sum(int n)
    {
        return Calculate(n);
    }

    private static int Calculate(int n)
    {
        int result = n;
        do {
            result = SumOfDigit(result);
        }while (result >= 10);
        return result;
    }

    private static int SumOfDigit(int n)
    {
        int sum = 0;
        while (n>0)
        {
            sum+= n%10;
            n/=10;
        }
        return sum;
    }
}
