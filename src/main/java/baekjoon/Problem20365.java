package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 20365 - 블로그2
//  날짜 : 2026-01-05
// -------------------------------
public class Problem20365 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();
        int redCnt = 0;
        int blueCnt = 0;

        char prev = charArray[0];
        if (prev == 'R') {
            redCnt++;
        } else {
            blueCnt++;
        }

        for (int i = 1; i < n; i++) {
            char c = charArray[i];
            if (prev != c) {
                if (c == 'R') {
                    redCnt++;
                } else {
                    blueCnt++;
                }

                prev = c;
            }
        }

        int minCount = Math.min(redCnt, blueCnt);
        System.out.println(minCount + 1);
    }
}
