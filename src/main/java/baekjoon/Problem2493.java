package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 2493 - 탑
//  날짜 : 2025-11-23
//  추가 설명 : 가장 높은 탑을 stack에 어떻게 넣느냐가 중요한 포인트
//             2중 for 문을 사용해서 해결할 수 있지만 타워의 갯수가 최대 500,000 개가 될 수 있기 때문에 타임아웃이 발생
//             그래서 stack에는 모든 타워를 넣는게 아니라 이후에 가장 높은 탑을 저장하는 것이 가장 큰 목표
// -------------------------------
public class Problem2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Tower> stack = new Stack<>();

        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // 이번에 진행할 높이
            int height = Integer.parseInt(st.nextToken());

            // 이번 타워가 기존에 담겨 있는 타워보다 작은건 제외
            while (!stack.isEmpty() && stack.peek().height <= height) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek().idx + 1;
            }

            stack.push(new Tower(i, height));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
