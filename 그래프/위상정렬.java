package 그래프;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * [위상 정렬 - 방향 그래프의 노드간 순서]
 * - 방향 그래프의 모든 노드를 '방향성에 거스르지 않도록' 순서대로 나열한다.
 * - 그래프에서 사이클이 발생하는 경우엔 사용할 수 없다.
 * - 노드 V개, 간선 E개일 때 시간복잡도는 O(V + E)이다.
 */

public class 위상정렬 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 노드의 개수
        int m = Integer.parseInt(st.nextToken());  // 간선의 개수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] degree = new int[n + 1];  // 진입 차수 배열
        
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);  // 노드 A에서 B로 이동 가능
            degree[b]++;  // 노드 b 진입 차수 1 증가
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 진입차수 0인 노드를 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int now, next;
        while (!queue.isEmpty()) {
            now = queue.poll();
            result.add(now);
            
            for (int i = 0, len = graph.get(now).size(); i < len; i++) {
                next = graph.get(now).get(i);
                degree[next]--;
                // 진입차수 0인 노드를 큐에 삽입
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}