package 트리;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LCA_최소공통조상 {

    static int n, k;
    static ArrayList<ArrayList<Integer>> tree;
    static int[][] parents;
    static int[] depths;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        // 트리 생성 및 초기화
        tree = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<Integer>());
        }

        // n은 2^k 이하 (ex. n=15, k=4)
        k = 0;
        while (n >= Math.pow(2, k)) {
            k++;
        }

        parents = new int[n + 1][k]; // 조상 노드 (n번째 노드의 2^k번째 조상 노드)
        depths = new int[n + 1]; // 노드의 깊이
        
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 트리는 양방향 연결
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // 각 노드의 깊이와 첫번째 조상 노드 구하기
        dfs(1, 1);

        // 각 노드의 전체 조상 노드 구하기
        findAllParents();

        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(LCA(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int node, int depth) {
        depths[node] = depth;

        for (int next : tree.get(node)) {
            // 아직 깊이가 정해지지 않은 경우
            if (depths[next] == 0) {
                dfs(next, depth + 1);
                parents[next][0] = node; // next 노드의 첫번째(2^0) 조상 노드 설정
            }
        }
    }

    static void findAllParents() {
        for (int i = 1; i < k; i++) {
            for (int a = 1; a <= n; a++) {
                // a 노드의 2^i번째 조상 노드 = a 노드의 2^(i-1)번째 조상 노드의 2^(i-1)번째 조상 노드
                // (예시) 8번째 조상 노드 = 4번째 조상 노드의 4번째 조상 노드
                parents[a][i] = parents[parents[a][i - 1]][i - 1];
            }
        }
    }

    // 노드 a와 노드 b의 최소 공통 조상 노드 구하기
    static int LCA(int a, int b) {
        // (노드 a 깊이 >= 노드 b 깊이) 만족하도록 노드 변경
        if (depths[a] < depths[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // (예시) n = 15 일 때, k = 4
        // 노드 a 깊이와 노드 b 깊이가 8(2^3) 이상 차이나면 노드 a를 8번째 조상 노드로 점프
        // 높이가 같아질 때까지 반복
        for (int i = k - 1; i >= 0; i--) {
            if (depths[a] - depths[b] >= Math.pow(2, i)) {
                a = parents[a][i];
            }
        }

        // 노드 b가 노드 a의 조상 노드인 경우
        if (a == b) {
            return b;
        }

        // 같은 부모 노드를 가진 노드까지 깊이 올리기
        for (int i = k - 1; i >= 0; i--) {
            System.out.println(a + "와 " + b + "의 2^" + i + "번째 조상 노드: " + parents[a][i] + ", " + parents[b][i]);
            if (parents[a][i] != parents[b][i]) {
                a = parents[a][i];
                b = parents[b][i];
            }
        }

        return parents[a][0]; // 첫번째 조상 노드 리턴
    }
}