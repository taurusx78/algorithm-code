package 정렬;
/*
 * [거품정렬 (Bubble Sort)]
 * - 맨 앞에서부터 현재 원소와 다음 원소를 비교해서 정렬을 진행한다.
 * - 맨 뒤쪽부터 하나씩 정렬된다.
 * - O(N^2)의 시간복잡도를 가진다.
 */

public class 거품정렬 {
    
    public static void main(String[] args) throws Exception {

        int n = 10;
        int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
