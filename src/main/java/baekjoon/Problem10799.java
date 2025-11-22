package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 10799 - 쇠막대기
//  날짜 : 2025-11-22
// -------------------------------
public class Problem10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();

        int result = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (c == '(') {
                if (i + 1 < charArray.length && charArray[i + 1] == ')') {
                    result += stack.size();
                    i++;
                } else {
                    stack.push(c);
                }
            } else {
                stack.pop();
                result++;
            }
        }
        System.out.println(result);
    }
}