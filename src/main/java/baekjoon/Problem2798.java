package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2798 - 블랙잭
//  날짜 : 2025-11-08
//  추가설명 : 3중 for문을 사용해서 조금 찔리지만 문제의 조건에서 N 이 최대 100이다. 그럼 100의 3제곱이여도 백만 정도로 낮은 수치이기 때문에 부담없이 사용
// -------------------------------
public class Problem2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int targetNumber = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = list[i] + list[j] + list[k];
                    if (sum == targetNumber) {
                        System.out.println(sum);
                        return;
                    }

                    if (sum <= targetNumber && sum > max) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
