package 그래프;
import java.util.ArrayList;

/*
 * [인접리스트 방식]
 * - 메모리 사용량은 적지만, 탐색 속도는 느리다.
 * - 특정 노드와 연결된 모든 인접 노드를 순회해야 하는 경우 사용하는 것이 좋다. (DFS, BFS)
 */

class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.print("(" + index + ", " + distance + ") ");
    }
}

public class 그래프_인접리스트_방식 {

    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        // 그래프 초기화 (노드는 3개)
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 0에 연결된 노드 정보
        graph.get(0).add(new Node(1, 7));
        graph.get(0).add(new Node(2, 5));

        // 노드 1에 연결된 노드 정보
        graph.get(1).add(new Node(0, 7));
        
        // 노드 2에 연결된 노드 정보
        graph.get(2).add(new Node(0, 5));
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0, len = graph.get(i).size(); j < len; j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }
}