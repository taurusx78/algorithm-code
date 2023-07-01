package 기타;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소수찾기 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        boolean[] notPrime = new boolean[n + 1]; // 소수 여부 (false: 소수)

        // n의 제곱근까지 반복
        for (int i = 2, len = (int) Math.sqrt(n); i <= len; i++) {
            // 에라토스테네스의 체 이용
            if (!notPrime[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 2; i <= n; i++) {
            if (!notPrime[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }
}
