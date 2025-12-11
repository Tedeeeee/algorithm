package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// -------------------------------
//  문제 : BOJ 5014 - 스타트링크
//  날짜 : 2025-12-11
// -------------------------------
public class Problem5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 총 층 수
        int f = Integer.parseInt(st.nextToken());
        // 현재 층 수
        int s = Integer.parseInt(st.nextToken());
        // 목표 층 수
        int g = Integer.parseInt(st.nextToken());
        // 올라갈때
        int u = Integer.parseInt(st.nextToken());
        // 내려갈때
        int d = Integer.parseInt(st.nextToken());

        int[] move = {u, -d};

        boolean[] visited = new boolean[f + 1];

        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(s, 0));
        visited[s] = true;

        int answer = -1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.num == g) {
                answer = p.count;
                break;
            }

            for (int j : move) {
                int nextPoint = j + p.num;
                if (nextPoint < 1 || nextPoint > f) {
                    continue;
                }

                if (visited[nextPoint]) {
                    continue;
                }

                visited[nextPoint] = true;
                queue.offer(new Point(nextPoint, p.count + 1));
            }
        }

        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    static class Point {
        int num;
        int count;

        public Point(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
