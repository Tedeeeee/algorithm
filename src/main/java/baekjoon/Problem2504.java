package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// -------------------------------
//  문제 : BOJ 2504 - 괄호의 값
//  날짜 : 2025-11-23
// -------------------------------
public class Problem2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        Stack<Object> stack = new Stack<>();
        for (char c : arr) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                int sum = 0;

                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    sum += (Integer) stack.pop();
                }

                if (stack.isEmpty() || !(stack.peek() instanceof Character) || (char) stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                stack.pop();

                if (sum == 0) {
                    sum = 2;
                } else {
                    sum *= 2;
                }

                stack.push(sum);
            } else if (c == ']') {
                int sum = 0;

                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    sum += (Integer) stack.pop();
                }

                if (stack.isEmpty() || !(stack.peek() instanceof Character) || (char) stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                stack.pop();

                if (sum == 0) {
                    sum = 3;
                } else {
                    sum *= 3;
                }

                stack.push(sum);
            } else {
                System.out.println(0);
                return;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            if (!(stack.peek() instanceof Integer)) {
                System.out.println(0);
                return;
            }

            result += (Integer) stack.pop();
        }

        System.out.println(result);
    }
}
