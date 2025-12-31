package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 15721 - 번데기
//  날짜 : 2025-12-31
// -------------------------------
public class Problem15721 {

    static Deque<Integer> deque;
    static int hit, t, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        deque = new ArrayDeque<>();
        for (int i = 0; i < a; i++) {
            deque.add(i);
        }

        int round = 1;
        int bbun = 0;
        int daegy = 1;
        while (true) {
            if (shout(bbun)) {
                return;
            }

            if (shout(daegy)) {
                return;
            }
            if (shout(bbun)) {
                return;
            }
            if (shout(daegy)) {
                return;
            }

            // 번을 라운드 + 1 반큼 반복
            for (int i = 0; i < round + 1; i++) {
                if (shout(bbun)) {
                    return;
                }
            }

            // 데기도 라운드 + 1 만큼 반복
            for (int i = 0; i < round + 1; i++) {
                if (shout(daegy)) {
                    return;
                }
            }

            round++;
        }
    }

    private static boolean shout(int value) {
        Integer person = deque.pollFirst();

        if (value == n) {
            hit++;
        }

        if (hit == t) {
            System.out.println(person);
            return true;
        }

        deque.addLast(person);
        return false;
    }
}