package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 3273 - 두 수의 합
//  날짜 : 2025-11-13
//  추가 설명 : 배열의 최대 길이가 2중 for문을 하면 시간복잡도 오류 발생으로 두번 반복할수 없다
//            그래서 이중 포인터로 해결해야한다
// -------------------------------
public class Problem3272 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 최대 길이 => 100000
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 더했을때 원하는 x 값
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int result = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                result++;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result);


    }
}
