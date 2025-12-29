package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2792 - 보석 상자
//  날짜 : 2025-12-29
// -------------------------------
public class Problem2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];

        int left = 1;
        int right = 0;

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;

            right = Math.max(right, number);
        }

        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            for (int i = 0; i < m; i++) {
                int gem = arr[i];
                count += gem / mid;

                if (gem % mid > 0) {
                    count++;
                }
            }

            // 못받는 학생이 있어도 된다
            // 질투값은 낮을수록 좋기 때문에 총 인원이 모두 받지 못하더라도 보석을 모두 소진했다는 전제로 질투값이 최소여야 한다
            if (count <= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
