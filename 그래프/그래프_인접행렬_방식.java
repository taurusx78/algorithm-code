package 그래프;
/*
 * [인접행렬 방식]
 * - 메모리 사용량은 많지만, 탐색 속도는 빠르다.
 */

public class 그래프_인접행렬_방식 {

    static final int INF = 999999999;

    public static void main(String[] args) throws Exception {
        int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
