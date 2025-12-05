package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// -------------------------------
//  문제 : BOJ 1697 - 숨바꼭질
//  날짜 : 2025-12-05
// -------------------------------
public class Problem1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 100000;
        boolean[] visited = new boolean[max + 1];
        int[] nextStep = {1, 1, 2};
        char[] nextCalc = {'-', '+', '*'};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] point = queue.poll();

            int number = point[0];
            int depth = point[1];

            if (number == target) {
                System.out.println(depth);
                break;
            }

            for(int i = 0; i < nextCalc.length; i++) {
                int calcNum = number;

                char calc = nextCalc[i];
                switch (calc) {
                    case '-': calcNum -= nextStep[i]; break;
                    case '+': calcNum += nextStep[i]; break;
                    case '*': calcNum *= nextStep[i]; break;
                }

                if (calcNum >= 0 && calcNum <= max && !visited[calcNum]) {
                    visited[calcNum] = true;
                    queue.add(new int[]{calcNum, depth + 1});
                }
            }
        }
    }
}
