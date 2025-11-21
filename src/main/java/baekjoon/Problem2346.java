package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2346 - 풍선 터뜨리기
//  날짜 : 2025-11-21
//  추가 설명 : 해당 내용은 Deque 를 사용해서 많이 푸는 문제지만 직접 만들어서 마치 원형 리스트 처럼 만들어보고 싶었다
// -------------------------------
public class Problem2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solveWithCircularArray(n, arr);
        solveWithDeque(n, arr);
    }

    private static void solveWithCircularArray(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        int nextNumber = arr[0];
        arr[0] = 0;
        sb.append(1).append(" ");

        for (int i = 0; i < n - 1; i++) {

            if (nextNumber > 0) {
                for (int j = 0; j < nextNumber; j++) {
                    index++;
                    if (index >= n) {
                        index = 0;
                    }

                    while (arr[index] == 0) {
                        index++;
                        if (index >= n) {
                            index = 0;
                        }
                    }
                }
            } else {
                int moveCount = Math.abs(nextNumber);
                for (int j = 0; j < moveCount; j++) {
                    index--;
                    if (index < 0) {
                        index = n - 1;
                    }

                    while (arr[index] == 0) {
                        index--;
                        if (index < 0) {
                            index = n - 1;
                        }
                    }
                }
            }

            sb.append(index + 1).append(" ");
            nextNumber = arr[index];
            arr[index] = 0;
        }

        System.out.println(sb.toString().trim());
    }

    private static void solveWithDeque(int n, int[] arr) {

    }


}