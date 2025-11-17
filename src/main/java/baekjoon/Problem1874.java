package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// -------------------------------
//  문제 : BOJ 1874 - 스택 수열
//  날짜 : 2025-11-17
// -------------------------------
public class Problem1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 10만개 -> 2중 for 문 하면 문제 발생
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int next = 1;
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];

            while (next <= target) {
                stack.push(next);
                sb.append("+").append("\n");
                next++;
            }

            if (target != stack.peek() || stack.isEmpty()) {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }

            // while 에서 걸리지 않았다면 어차피 더 낮은 수라는거
            // 그럼 빼야 함
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}
