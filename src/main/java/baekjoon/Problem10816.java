package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 10816 - 숫자 카드2
//  날짜 : 2025-11-27
// -------------------------------
public class Problem10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> haveCard = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cardNum = Integer.parseInt(st.nextToken());

            haveCard.put(cardNum, haveCard.getOrDefault(cardNum, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int cardNum = Integer.parseInt(st.nextToken());
            int value = haveCard.getOrDefault(cardNum, 0);

            sb.append(value).append(" ");
        }

        System.out.println(sb);
    }
}
