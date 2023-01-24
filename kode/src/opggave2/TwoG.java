package opggave2;

public class TwoG {

    public static void main(String[] args){

        snitt(10_000_000);
        snitt(100_000_000);
        snitt(1_000_000_000);
    }

    public static void snitt(long n){
        long sum = 0;
        for(int i = 0 ; i < 200 ; i++){
            sum += tid(n);
        }
        System.out.println(sum/10.0);
    }



    public static long tid(long n) {
        long start = System.currentTimeMillis();
        long k = 0;
        for (long i = 1; i <= n; i++) {
            k = k + 5;
        }
        return (System.currentTimeMillis() - start);
    }
}
