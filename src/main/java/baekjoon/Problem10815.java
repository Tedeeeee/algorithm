package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 10815 - 숫자 카드
//  날짜 : 2025-12-15
// -------------------------------
public class Problem10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // -10 2 3 6 10
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean match = false;

            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (right + left) / 2;

                int number = arr[mid];
                if (number == target) {
                    match = true;
                    break;
                }

                if (number > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (match) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
