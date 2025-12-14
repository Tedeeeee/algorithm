package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1920 - 수 찾기
//  날짜 : 2025-12-14
// -------------------------------
//  why?       : 기준 배열을 정렬한 뒤, 각 질문을 O(log N)으로 탐색해야 해서
//  시간복잡도  : O(N log N + M log N)
//  실수       : 중앙값 계산하는 방법을 몰랐음
public class Problem1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int firstN = Integer.parseInt(br.readLine());
        int[] firstArr = new int[firstN];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < firstN; i++) {
            firstArr[i] = Integer.parseInt(st.nextToken());
        }

        int secondN = Integer.parseInt(br.readLine());
        int[] secondArr = new int[secondN];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < secondN; i++) {
            secondArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(firstArr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < secondN; i++) {
            int target = secondArr[i];
            boolean match = false;

            int left = 0;
            int right = firstN - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                int number = firstArr[middle];

                if (target == number) {
                    match = true;
                    break;
                }

                if (target < number) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }

            if (match) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
