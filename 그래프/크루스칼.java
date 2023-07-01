package 그래프;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * [신장 트리]
 * - 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프(트리)를 의미한다.
 * - 최소 신장 트리는 일종의 트리 자료구조이며, 신장트리에 포함되는 간선의 개수가 (노드 개수 - 1)과 같다.
 * 
 * [크루스칼 알고리즘]
 * - 최소 신장 트리를 계산하는 알고리즘이다.
 * - 크루스칼 알고리즘에서 시간이 가장 오래 걸리는 부분이 간선을 정렬하는 작업이다.
 * - 따라서 간선의 개수가 E개일 때, O(ElogE)의 시간복잡도를 가진다.
 */

class Edge implements Comparable<Edge> {

    int cost;
    int node1;
    int node2;

    public Edge(int cost, int node1, int node2) {
        this.cost = cost;
        this.node1 = node1;
        this.node2 = node2;
    }

    // 거리가 짧은 것이 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class 크루스칼 {

    static int[] root;

    static int findRoot(int x) {
        if (root[x] != x) {
            root[x] = findRoot(root[x]);
        }
        return root[x];
    }

    static void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        // 루트 테이블 초기화
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }

        // 간선 정보
        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(cost, n1, n2);
        }

        // 간선 비용 오름차순 정렬
        Arrays.sort(edges);

        int minSum = 0;

        // 연결된 노드에 대해 union 연산 수행
        Edge now;
        for (int i = 0; i < m; i++) {
            now = edges[i];

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findRoot(now.node1) != findRoot(now.node2)) {
                union(now.node1, now.node2);
                minSum += now.cost;
            }
        }

        System.out.println(minSum);
    }
}