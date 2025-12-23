package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 14921 - 용액 합설하기
//  날짜 : 2025-12-23
// -------------------------------
public class Problem14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int answer = arr[0] + arr[n - 1];
        while(left < right){
            int sum = arr[left] + arr[right];

            // 0과 가까운가?
            if (Math.abs(sum) < Math.abs(answer)) {
                answer = sum;
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }
}
