package 이진탐색;
/*
 * [이진탐색]
 * - 정렬된 배열에서 타켓을 찾는 검색 알고리즘이다.
 * - O(log N)의 시간복잡도를 갖는다.
 */

public class 이진탐색 {

    static int binarySearch1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // 찾는 값이 없는 경우
    }

    static int binarySearch2(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch2(arr, target, mid + 1, right);
        } else {
            return binarySearch2(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int result1 = binarySearch1(arr, 9);
        int result2 = binarySearch2(arr, 10, 0, arr.length);

        System.out.println(result1 + ", " + result2);
    }
}
