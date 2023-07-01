package 최단경로;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * [플로이드 워셜]
 * - 모든 노드 간의 최단 경로를 구하는 알고리즘이다.
 */

public class 플로이드워셜 {

    public static final int INF = (int) 1e9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 최단 경로를 담는 2차원 리스트 생성
        int[][] graph = new int[n + 1][n + 1];

        // 그래프 무한으로 초기화
        for (int[] g : graph) {
            Arrays.fill(g, INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        // 간선 정보
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[n1][n2] = cost;
        }

        // f(a, b) = min(f(a, b), f(a, i) + f(i, b))
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                if (i == a) continue;
                for (int b = 1; b <= n; b++) {
                    if (i == b) continue;
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        for (int[] g : graph) {
            System.out.println(Arrays.toString(g));
        }
    }
}