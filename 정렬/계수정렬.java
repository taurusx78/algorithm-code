package 정렬;
/*
 * [계수정렬 (Counting Sort)]
 * - 최대 크기가 제한되어 있고 0 이상의 정수일 때 사용 가능하다.
 * - 가장 큰 수와 가장 작은 수의 차이가 1,000,000을 넘지 않을 때 효과적이다.
 */

public class 계수정렬 {

    public static void main(String[] args) throws Exception {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8, 0, 5, 2};
        int max = 0; // 최대값

        for (int num : arr) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
