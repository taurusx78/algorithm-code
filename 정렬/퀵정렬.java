package 정렬;
/*
 * [퀵정렬 (Quick Sort)]
 * - 기준 데이터(피벗)를 설정하고, 기준보다 큰 데이터와 작은 데이터의 위치를 교환한다.
 * - 불안정 정렬이다. (중복된 값을 입력 순서와 동일하게 정렬하지 않음)
 * - 평균 시간 복잡도는 O(NlogN)이다.
 * - 최악의 경우 O(N^2)의 시간복잡도는 가진다. -> 피벗을 잘 선택하는 것이 중요!
 */

public class 퀵정렬 {
    
    static void quickSort(int[] arr, int start, int end) {
        // 원소가 1개인 경우 재귀함수 종료
        if (start >= end) return;

        int pivot = arr[start];
        int left = start + 1; // 왼쪽 원소 인덱스
        int right = end; // 오른쪽 원소 인덱스

        int temp;
        while (left < right) {
            // 피벗보다 큰 원소를 만날 때까지 반복
            while (arr[left] <= pivot) {
                left++;
            }
            // 피벗보다 작은 원소를 만날 때까지 반복
            while (arr[right] >= pivot) {
                right--;
            }
           
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else {
                // 왼쪽 인덱스 > 오른쪽 인덱스인 경우, 작은 원소와 피벗 교환
                temp = arr[right];
                arr[right] = pivot;
                arr[start] = temp;
            }
        }

        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) throws Exception {

        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
