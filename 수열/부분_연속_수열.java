package 수열;

// 목표 합을 만족하는 부분 연속 수열의 개수 구하기

public class 부분_연속_수열 {
    
    public static void main(String[] args) throws Exception {
        int n = 5; // 전체 데이터 개수
        int target = 5; // 목표 합
        int[] arr = {1, 2, 3, 2, 5}; // 전체 수열

        int start = 0; // 시작 인덱스
        int end = 0; // 끝 인덱스
        int sum = arr[0]; // 현재 합
        int count = 0; // target을 만족하는 부분 연속 수열 개수

        while (start < n) {
            if (sum >= target) {
                if (sum == target) {
                    count++;
                }
                sum -= arr[start];
                start++;
            } else if (sum < target) {
                end++;
                if (end == n) break;
                sum += arr[end];
            }
        }

        System.out.println(count);
    }
}
