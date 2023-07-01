package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
[BFS]
- 너비 우선 탐색
- 큐(Queue)를 이용해서 구현한다.

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

public class BFS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 개수 (1~n번)
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        // 그래프 생성 및 초기화
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 그래프 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        boolean[] visited = new boolean[n + 1]; // 방문 여부
        ArrayList<Integer> result = new ArrayList<Integer>(); // 결과

        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // 1번 노드에서 시작
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);

                // 아직 방문하지 않은 경우
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
