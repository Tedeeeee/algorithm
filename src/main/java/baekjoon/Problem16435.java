package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 16435 - 스네이크 버드
//  날짜 : 2025-11-11
// -------------------------------
public class Problem16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] fruit = new int[N];
        for (int i = 0; i < N; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fruit);

        for (int fruitHeight : fruit) {
            if (snake >= fruitHeight) {
                snake += 1;
            } else {
                break;
            }
        }

        System.out.println(snake);

    }
}
