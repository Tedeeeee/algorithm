package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// -------------------------------
//  문제 : BOJ 1945 - 후위 표현식2
//  날짜 : 2025-11-22
// -------------------------------
public class Problem1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            char key = (char) ('A' + i);
            map.put(key, num);
        }

        Stack<Double> stack = new Stack<>();

        for (char c : arr) {
            double number;
            if (c >= 'A' && c <= 'Z') {
                number = map.get(c);
            } else {
                double secondNumber = stack.pop();
                double firstNumber = stack.pop();

                number = calc(firstNumber, secondNumber, c);
            }

            stack.push(number);
        }

        System.out.printf("%.2f\n", stack.pop());
    }

    static double calc(double first, double second, char op) {
        switch (op) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            default:
                return 0;
        }
    }
}