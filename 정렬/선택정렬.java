package 정렬;
/*
 * [선택정렬(Selection Sort)]
 * - 가장 작은 원소를 선택해 맨 앞에 있는 원소와 바꾸는 정렬이다.
 * - 불안정 정렬이다. (중복된 값을 입력 순서와 동일하게 정렬하지 않음)
 * - 현재 데이터의 정렬 상태와 상관없이 무조건 모든 원소를 비교하고 위치를 바꾼다.
 * - 최선, 평균, 최악의 경우 O(n^2)의 시간복잡도를 가진다.
 */

public class 선택정렬 {
    
    public static void main(String[] args) throws Exception {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // 가장 작은 원소의 인덱스
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // 값 교환 (스와프)
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
