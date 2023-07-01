package 최단경로;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * [다익스트라]
 * - 특정 노드에서 다른 노드로의 최단 경로를 구하는 알고리즘이다.
 */

class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    // 거리가 짧은 노드가 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class 다익스트라 {

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        int start = Integer.parseInt(br.readLine()); // 시작 노드

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 최단경로 배열
        int[] shortest = new int[n + 1];
        Arrays.fill(shortest, INF);

        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(n1).add(new Node(n2, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        shortest[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int index = now.index;
            int cost = now.cost;

            // 이미 최단 경로를 구한 노드인 경우
            if (shortest[index] < cost) continue;

            for (int i = 0, len = graph.get(index).size(); i < len; i++) {
                Node next = graph.get(index).get(i);
                int newCost = cost + next.cost;

                if (newCost < shortest[next.index]) {
                    shortest[next.index] = newCost;
                    pq.offer(new Node(next.index, newCost));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(shortest[i]);
        }
    }
}