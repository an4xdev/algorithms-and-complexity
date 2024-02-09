public class SecondsConverter {
    public static void Convert(int seconds)
    {
        int days = 0;
        int copy = seconds;
        while (seconds > 86400)
        {
            days++;
            seconds-=86400;
        }
        int hours = 0;
        while (seconds > 3600)
        {
            hours++;
            seconds-=3600;
        }
        int minutes = 0;
        while (seconds > 60)
        {
            minutes++;
            seconds-=60;
        }
        System.out.println(copy+" Seconds -> Days: "+days+", Hours: "+ hours+", minutes: "+minutes+", seconds: "+seconds);
    }

}
