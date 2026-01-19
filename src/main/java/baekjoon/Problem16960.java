package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 16960 - 스위치와 램프
//  날짜 : 2026-01-19
// -------------------------------
public class Problem16960 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 스위치의 수 N
        int n = Integer.parseInt(st.nextToken());
        // 램프의 수 M
        int m = Integer.parseInt(st.nextToken());

        int[] count = new int[m + 1];

        int[][] switchLamps = new int[n][];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            int[] lamps = new int[k];
            for (int j = 0; j < k; j++) {
                int lamp = Integer.parseInt(st.nextToken());
                lamps[j] = lamp;
                count[lamp]++;
            }

            switchLamps[i] = lamps;
        }

        for (int i = 0; i < n; i++) {
            boolean removable = true;

            // 각 스위치마다 연결된 램프를 확인
            for (int lamp : switchLamps[i]) {
                // 해당 스위치가 램프를 담당하고 있는 유일한 스위치라면 끌 수 없다
                if (count[lamp] == 1) {
                    removable = false;
                    break;
                }
            }

            if (removable) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}