package 정렬;
/*
 * [병합정렬 (Merge Sort)]
 * - 안정 정렬이다. (중복된 값은 입력 순서와 동일하게 정렬함)
 * - 퀵 정렬과 달리 입력값에 관계 없이 성능이 일정하다.
 * - 파이썬에서는 기본 정렬 알고리즘으로 병합 정렬과 삽입 정렬을 조합한 팀소트를 사용한다.
 */

import java.util.Arrays;

public class 병합정렬 {

    // 배열 분할
    static void divide(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            divide(arr, left, mid);
            divide(arr, mid + 1, right);

            mergeSort(arr, left, mid, right);
        }
    }

    // 배열 정렬하며 합치기
    static void mergeSort(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0; // 왼쪽 배열 현재 인덱스
        int j = 0; // 오른쪽 배열 현재 인덱스
        int k = left; // arr의 현재 인덱스
        int leftLen = leftArr.length;
        int rightLen = rightArr.length;

        while (i < leftLen && j < rightLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // 왼쪽 배열에서 남은 원소 채우기
        while (i < leftLen) {
            arr[k++] = leftArr[i++];
        }

        // 오른쪽 배열에서 남은 원소 채우기
        while (j < rightLen) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) throws Exception {

        int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

        divide(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
