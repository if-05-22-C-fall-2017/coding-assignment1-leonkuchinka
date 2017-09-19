package gcd.calculator;

/**
 *
 * @author LK
 */
public class GCDCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Testfall 1: gcd(24,16)
        int a = 24;
        int b = 16;
        int c,d;        
        c = gcdEucledian(a,b);               
        d = gcdPrimeFactors(a,b);
        System.out.println("gcd(24,16):\nExpected: 8\ngcdEucledian: " + c +"\ngcdPrimeFactors: "+d);
        
        System.out.println("--------------------------");
        
        //Testfall 2: gcd(3528, 3780)
        a = 3528;
        b = 3780;
        c = gcdEucledian(a,b);               
        d = gcdPrimeFactors(a,b);
        System.out.println("gcd(3528,3780):\nExpected: 252\ngcdEucledian: " + c +"\ngcdPrimeFactors: "+d);
        
        System.out.println("--------------------------");
        
        //Testfall 3: gcd(3528, 3780)
        a = 144;
        b = 160;
        c = gcdEucledian(a,b);               
        d = gcdPrimeFactors(a,b);
        System.out.println("gcd(144,160):\nExpected: 16\ngcdEucledian: " + c +"\ngcdPrimeFactors: "+d);
        
    }
    
    public static int gcdPrimeFactors(int a, int b)
    {
        int [] counterA = getPrimeFactors(a);
        int [] counterB = getPrimeFactors(b);
        int sum = 1;
        for(int i = 0;i<counterA.length;i++)
        {
            sum *= Math.pow(i, Math.min(counterA[i], counterB[i]));            
        }
               
        return sum;
    }
    
    public static int[] getPrimeFactors(int a)
    {
        int [] counter = new int[50];
        
        while(a > 1)
        {
            int temp = 1;
            int i = 2;
            for(;i<50 && (isprime(i) == true && (a % i == 0)) != true;i++){
            }
            counter[i]++;
            a /= i;
        }
        return counter;
    }
    public static boolean isprime(int a)
    {
        for(int i = 2;i<a;i++)
        {
            if(a % i == 0)
                return false;
        }
        return true;
        
    }
    
    
    public static int gcdEucledian(int a, int b)
    {
        if(b == 0)
            return a;
        return gcdEucledian(b, a%b);
    }
    
    
}
