package 다이나믹프로그래밍;
public class 피보나치수열_반복문 {
    
    public static void main(String[] args) throws Exception {
        long[] d = new long[10];

        d[1] = 1;
        d[2] = 1;

        for (int i = 3; i < 10; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println(d[9]);
    }
}
