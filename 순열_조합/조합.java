package 순열_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 조합 - N개 중 M개 뽑기 (순서X)

public class 조합 {
    
    static int n, m;
    static boolean[] included; // 포함 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개 중 M개 뽑기 (조합)

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        included = new boolean[n];

        // M개 조합
        combination(0, 0);
    }

    // DFS, 재귀, 백트래킹
    static void combination(int start, int count) {
        if (count == m) {
            // 포함된 수 출력
            for (int i = 0; i < n; i++) {
                if (included[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                included[i] = true;
                combination(i + 1, count + 1);
                included[i] = false;
            }
        }
    }
}
