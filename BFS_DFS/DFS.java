package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
[DFS]
- 깊이 우선 탐색
- 재귀를 이용해서 구현한다.

[테스트용 입력 데이터]
9 18
1 2
1 3
1 8
2 1
2 7
3 1
3 4
3 5
4 3
4 5
5 3
5 4
6 7
7 2
7 6
7 8
8 1
8 7
 */

public class DFS {
    
    public static int n, m;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited; // 방문 여부
    public static ArrayList<Integer> result = new ArrayList<Integer>(); // 결과

    public static void dfs(int node) {
        // 현재 노드 방문 처리
        visited[node] = true;
        result.add(node);

        for (int i = 0; i < graph.get(node).size(); i++) {
            int next = graph.get(node).get(i);

            // 아직 방문하지 않은 경우
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 노드 개수 (1~n번)
        m = Integer.parseInt(st.nextToken()); // 간선 개수

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 그래프 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        visited = new boolean[n + 1]; // 방문 여부

        dfs(1); // 1번 노드부터 시작
        
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
