package 순열_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 순열 - N개 중 M개 정렬

public class 순열 {
    
    static int n, m;
    static boolean[] included; // 포함 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        included = new boolean[n];

        permutation(new int[m], 0);
    }

    // 순열 (DFS, 재귀, 백트래킹)
    // 순서 보장을 위해 result 배열에 결과 담음
    static void permutation(int[] result, int count) {
        if (count == m) {
            // 포함된 수 출력
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!included[i]) {
                    included[i] = true;
                    result[count] = i;
                    permutation(result, count + 1);
                    included[i] = false;
                }
            }
        }
    }
}
