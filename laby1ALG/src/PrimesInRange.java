public class PrimesInRange {
    public static void Calculate(int range)
    {
        int[] tab = new int[range];
        for (int i = 0; i < range; i++)
        {
            tab[i] = i;
        }
        tab[0] = 0;
        tab[1] = 0;
        for (int i = 2; i < range; i++)
        {
            int number = tab[i];
            if(number == 0)
                continue;
            for (int j = number +1;j < range; j++)
            {
                if(tab[j]% number == 0)
                    tab[j]=0;
            }
        }
        System.out.print("In range (0-"+range+") are primes: ");
        for (int i = 2; i < range; i++)
        {
            if(tab[i] != 0)
                System.out.print(tab[i]+", ");
        }
    }
}
