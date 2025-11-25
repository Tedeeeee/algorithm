package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 18115 - 카드 놓기
//  날짜 : 2025-11-25
// -------------------------------
public class Problem18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // skill 사용한 순서
        int[] skill = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            skill[i] = Integer.parseInt(st.nextToken());
        }

        // deque 손에 있어야 하는 카드
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int card = 1;
        for (int i = n - 1; i >= 0; i--) {
            int skillNum = skill[i];

            if (skillNum == 1) {
                deque.offerFirst(card);
            } else if (skillNum == 2) {
                if (deque.isEmpty()) {
                    deque.pollFirst();
                } else {
                    int top = deque.pollFirst();

                    deque.addFirst(card);
                    deque.addFirst(top);
                }
            } else {
                deque.addLast(card);
            }

            card++;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int top = deque.pollFirst();
            sb.append(top).append(" ");
        }

        System.out.println(sb);
    }
}
