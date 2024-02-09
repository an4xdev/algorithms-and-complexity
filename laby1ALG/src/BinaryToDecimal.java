public class BinaryToDecimal {
    public static int Calculate(String number)
    {
        int decimal = 0;
        int exp = 0;
        for (int i = number.length()-1;i>=0;i--)
        {
            if(number.charAt(i) == '1')
                decimal += Math.pow(2, exp);
            exp++;
        }
        return decimal;
    }
}
