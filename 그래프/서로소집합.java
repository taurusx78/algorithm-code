package 그래프;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서로소집합 {
    
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 노드의 개수
        int m = Integer.parseInt(st.nextToken());  // 간선의 개수
        
        // 루트 테이블 초기화
        root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }
        
        // 연결된 노드에 대해 union 연산 수행
        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        
        // 루트 노트 갱신
        for (int i = 1; i <= n; i++) {
            findRoot(i);
        }
        
        System.out.println(Arrays.toString(root));
    }
}