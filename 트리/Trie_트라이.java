package 트리;
import java.util.HashMap;
import java.util.Map;

class Node {

    Map<Character, Node> childNode; // 자식 노드
    boolean isLast; // 단어의 끝 여부

    public Node() {
        childNode = new HashMap<>(); // 자식 노드 생성
    }
}

class Trie {

    Node root; // 루트 노드

    public Trie() {
        root = new Node(); // 루트 노드 생성
    }

    public void insert(String word) {
        Node now = this.root; // 루트 노드부터 확인하며 삽입 시작

        for (int i = 0; i < word.length(); i++) {
            // 현재 노드의 자식 노드 중 word.charAt(i)를 Key로 갖는 자식 노드가
            // 1) 없다면, {word.charAt(i): new Node()} 새로 추가 후 Value 반환
            // 2) 있다면, Value 가져옴
            now = now.childNode.computeIfAbsent(word.charAt(i), key -> new Node());
        }

        now.isLast = true; // 현재 문자는 단어의 마지막 문자임
    }

    public boolean search(String word) {
        Node now = this.root; // 루트 노드부터 확인하며 검색 시작

        for (int i = 0; i < word.length(); i++) {
            // 현재 노드의 자식 노드 중 word.charAt(i)를 Key로 갖는 자식 노드가
            // 1) 없다면, null 리턴
            // 2) 있다면, Value 가져옴
            Node child = now.childNode.get(word.charAt(i));

            if (child == null) {
                return false;
            }

            now = child;
        }

        return now.isLast; // 단어의 마지막 문자인지
    }
}

public class Trie_트라이 {

    public static void main(String[] args) throws Exception {
        // Trie 자료구조 생성
		Trie trie = new Trie();
		
		// Trie에 문자열 저장
		trie.insert("kakao");
		trie.insert("busy");
		trie.insert("card");
		trie.insert("cap");
		
		// Trie에 저장된 문자열 확인
		System.out.println(trie.search("bus"));   // false
		System.out.println(trie.search("busy"));  // true
		System.out.println(trie.search("kakao")); // true
		System.out.println(trie.search("cap"));   // true
    }
}
