package 다이나믹프로그래밍;
public class 피보나치수열_재귀 {
    
    static int[] d = new int[10];

    static int fibo(int n) {
        if (n == 1 || n == 2) return 1;

        if (d[n] != 0) return d[n];

        d[n] = fibo(n - 1) + fibo(n - 2);
        return d[n];
    }

    public static void main(String[] args) throws Exception {
        d[1] = 1;
        d[2] = 1;

        System.out.println(fibo(9));
    }
}
