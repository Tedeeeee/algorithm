package baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 14916 - 거스름돈
//  날짜 : 2025-12-12
// -------------------------------
public class Problem14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int result = 0;

        // 5원으로 최대한 나누는데
        result = n / 5;
        n %= 5;

        // 나눈 값이 홀수라면 5원을 더해준다
        // 홀수 + 홀수 = 짝수
        // 즉, 2로 나눌 수 있다
        if (n % 2 != 0 && result > 0) {
            n += 5;
            result--;
        }

        result += n / 2;
        n %= 2;

        if (n != 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

        // GPT 의 방법
        // 반복문을 어떻게 쓰면 좋을지 생각했었는데 얘가 하는고만...
        // gptSolution(n);
    }

    private static void gptSolution(int n) {
        int five = n / 5;

        while (five >= 0) {
            int rest = n - five * 5;
            if (rest % 2 == 0) {
                int two = rest / 2;
                System.out.println(five + two);
            }
            five--;
        }

        System.out.println(-1);
    }
}
