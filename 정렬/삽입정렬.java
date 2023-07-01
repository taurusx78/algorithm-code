package 정렬;
/*
 * [삽입정렬 (Insertion Sort)]
 * - 원소를 적절한 위치에 삽입하는 정렬이다.
 * - 안정 정렬이다. (중복된 값은 입력 순서와 동일하게 정렬함)
 * - 선택 정렬보다 좀 더 빠르다.
 * - 최선의 경우(거의 정렬된 경우) O(n)의 시간복잡도를 가진다.
 * - 평균, 최악의 경우(역으로 정렬된 경우) O(n^2)의 시간복잡도를 가진다.
 */

public class 삽입정렬 {
    
    public static void main(String[] args) throws Exception {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    break;
                }
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
