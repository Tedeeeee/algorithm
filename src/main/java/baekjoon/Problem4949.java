package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// -------------------------------
//  문제 : BOJ 4949 - 균형잡힌 세상
//  날짜 : 2025-11-24
// -------------------------------
public class Problem4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String sentence = br.readLine();

            if (".".equals(sentence)) {
                break;
            }

            boolean valid = true;
            char[] arr = sentence.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : arr) {
                if (c == '.') {
                    break;
                }

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        valid = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (valid && stack.isEmpty()) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }

        System.out.println(sb);
    }
}
